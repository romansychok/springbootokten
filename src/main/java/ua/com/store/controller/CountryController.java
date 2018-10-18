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
import ua.com.store.entity.Country;
import ua.com.store.service.CountryService;
import ua.com.store.validation.CountryValidator;

import javax.validation.Valid;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryValidator countryValidator;


    @GetMapping("/countryAdmin")
    public String next(Model model){
        model.addAttribute("eCountry",new Country());
        model.addAttribute("countries",countryService.findAll());
        return "/adminView/countryAdmin";

    }

    @PostMapping("/saveCountry")
    public String save(@ModelAttribute("eCountry") @Valid Country country, BindingResult result){
        if (result.hasErrors()) {
            System.out.println("Country class has error");
            return "/adminView/countryAdmin";
        }
        countryService.save(country);
        return "/adminView/countryAdmin";
    }



    @InitBinder
    public void bind(WebDataBinder binder){
        binder.addValidators(countryValidator);
    }


}
