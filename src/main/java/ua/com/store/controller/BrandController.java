package ua.com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.store.service.BrandService;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

}
