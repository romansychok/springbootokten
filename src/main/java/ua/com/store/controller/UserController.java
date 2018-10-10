package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.store.entity.User;
import ua.com.store.service.UserService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
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
        System.out.println("1111");
        user.setUserImage("\\images\\" + multipartFile.getOriginalFilename());
        userService.save(user);

        return "/userView/register";
    }

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users",userService.findAll());
        System.out.println("2222");
        return "/userView/users";
    }

    @GetMapping("/user-{id}")
    public String user(@PathVariable("id") int id,Model model){
        System.out.println("1111");
        User one = userService.findOne(id);
        model.addAttribute("user",one);
        return "userView/user";
    }


}
