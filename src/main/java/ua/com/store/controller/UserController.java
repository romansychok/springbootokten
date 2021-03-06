package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.store.entity.User;
import ua.com.store.service.ProductService;
import ua.com.store.service.UserService;
import ua.com.store.validation.UserValidator;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("productsIndex",productService.findAll());
        return "/mainView/index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/adminView/admin";
    }

    @GetMapping("/user")
    public String user(){
        return "/userView/user";
    }

    @GetMapping("/login")
    public String login(){
        return "/userView/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/userView/register";
    }

//    @PostMapping("/save")
//    public String save(@RequestParam("username") String username,
//                       @RequestParam("password") String password){
//        userService.save(new User(username,password));
//        return "redirect:/";
//
//    }

    @PostMapping("/save")
    public String saveUser(User user , BindingResult result,
                           @RequestParam("userImageX")MultipartFile multipartFile){
        if (result.hasErrors()){
            System.out.println("We have error!!!");
            return "/userView/register";
        }
        String path = System.getProperty("user.home") + File.separator + "projectImages\\";

        try {
            multipartFile.transferTo(new File(path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setUserImage("\\images\\" + multipartFile.getOriginalFilename());
        userService.save(user);

        return "/userView/register";
    }

    @GetMapping("/users")
    public String seeAllUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "/userView/users";
    }

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable("id") int id,Model model){
        User one = userService.findOne(id);
        model.addAttribute("user",one);
        return "userView/user";
    }
    @InitBinder
    public void bind(WebDataBinder binder){
        binder.addValidators(userValidator);
    }

}
