package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.store.entity.Product;
import ua.com.store.service.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("productAdmin")
    public String next(Model model){
        model.addAttribute("eProduct",new Product());
        return "/adminView/productAdmin";
    }


//    @GetMapping("/productPage")
//    public String productPage(){
//        return "productView/productPage";
//    }


    @PostMapping("/saveProduct")
    public String save(@ModelAttribute("eProduct")  Product product, BindingResult result,
                       @RequestParam("pathImage") MultipartFile multipartFile ){
        String path = System.getProperty("user.home") + File.separator + "projectImages\\";

        try {
            multipartFile.transferTo(new File(path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setPathImage("\\images\\" + multipartFile.getOriginalFilename());
        productService.save(product);
        return "/mainView/index";
    }

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products",productService.findAll());
        System.out.println(ProductController.class.getName() + " products line 52");
        return "/productView/products";
    }

    @GetMapping("/product/{id}")
    public String productPage(@PathVariable("id") int id, Model model){
        Product product = productService.findOne(id);
        model.addAttribute("product",product);
        return "/productView/productPage";
    }

    @GetMapping("/productDelete/{id}")
    public String deletingCurrentProduct(@PathVariable int id){
        productService.delete(id);
        return "/mainView/index";
    }


}
