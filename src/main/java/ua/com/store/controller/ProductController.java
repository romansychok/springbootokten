package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.store.entity.Category;
import ua.com.store.entity.Product;
import ua.com.store.service.CategoryService;
import ua.com.store.service.OrdersService;
import ua.com.store.service.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/productAdmin")
    public String next(Model model){
        model.addAttribute("eProduct",new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "/adminView/productAdmin";
    }


    @GetMapping("/productPage")
    public String productPage(){
        return "productView/productPage";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("eProduct")  Product product, BindingResult result,
                       @RequestParam("pathImage") MultipartFile multipartFile, Model model ){
        String path = System.getProperty("user.home") + File.separator + "projectImages\\";

        try {
            multipartFile.transferTo(new File(path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setPathImage("\\images\\" + multipartFile.getOriginalFilename());
        model.addAttribute("categories",categoryService.findAll());
        productService.save(product);
        return "/mainView/index";
    }

//    @GetMapping("/products")
//    public String showCurrentProductInMainPage(Model model){
//        model.addAttribute("products", productService.findAll());
//        return "/mainView/index";
//    }


    @GetMapping("/products")
    public String seeAllProductsIntoAList(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "/productView/products";
    }

    @GetMapping("/product/{id}")
    public String goToTheProductPageToSeeDescriptionOfProduct(@PathVariable("id") int id, Model model){
        Product product = productService.findOne(id);
        model.addAttribute("product",product);
        model.addAttribute("categories",categoryService.findAll());
        return "/productView/productPage";
    }

    @GetMapping("/productDelete/{id}")
    public String deletingCurrentProduct(@PathVariable int id){
        productService.delete(id);
        return "/mainView/index";
    }

    @GetMapping("/productEdit/{id}")
    public String productEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("eProduct",productService.findOne(id));
        model.addAttribute("categories",categoryService.findAll());
        return "/adminView/productAdmin";
    }



}
