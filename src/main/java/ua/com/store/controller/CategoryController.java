package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.store.entity.Category;
import ua.com.store.service.CategoryService;
import ua.com.store.validation.CategoryValidator;

import javax.validation.Valid;

@Controller
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryValidator categoryValidator;



    @GetMapping("/categoryAdmin")
    public String next(Model model){
        model.addAttribute("eCategory", new Category());
        return "/adminView/categoryAdmin";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("eCategory") @Valid Category category, BindingResult result){
        if (result.hasErrors()){
            System.out.println("Category has errorrrrrrr");
            return "/adminView/categoryAdmin";
        }
        categoryService.save(category);
        return "/adminView/categoryAdmin";
    }



    @InitBinder
    public void bind(WebDataBinder binder){
        binder.addValidators(categoryValidator);
    }


}
