package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/country/{id}")
    public String pageWhereCanSeeCountryOfOriginProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("country",countryService.findOne(id));
        return "/countryView/CountryPage";
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


    @GetMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable int id){
        countryService.delete(id);
        return "/mainView/index";
    }


    @InitBinder
    public void bind(WebDataBinder binder){
        binder.addValidators(countryValidator);
    }


}
