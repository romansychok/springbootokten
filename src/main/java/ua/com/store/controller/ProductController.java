package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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



}
