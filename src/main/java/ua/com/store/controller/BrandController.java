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
import ua.com.store.entity.Brand;
import ua.com.store.service.BrandService;

import java.io.File;
import java.io.IOException;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;


    @GetMapping("/brandAdmin")
    public String next(Model model){
        model.addAttribute("eBrand",new Brand());
        return "/adminView/brandAdmin";
    }

    @PostMapping("/saveBrand")
    public String save(@ModelAttribute("eBrand") Brand brand, BindingResult result,
                       @RequestParam("brandImage") MultipartFile multipartFile, Model model){
        String path = System.getProperty("user.home") + File.separator + "projectImages\\";

        try {
            multipartFile.transferTo(new File(path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        brand.setBrandImage("\\images\\" + multipartFile.getOriginalFilename());
        brandService.save(brand);
        return "/mainView/index";
    }



    @GetMapping("/brands")
    public String showAllBrands(Model model){
        model.addAttribute("brands",brandService.findAll());
        return "/brandView/brands";
    }


}
