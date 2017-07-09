package com.books.controller;

import com.books.entity.Country;
import com.books.service.CountryService;
import com.books.validator.countryValidator.CountryValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by User on 28.05.2017.
 */

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String country(Model model){
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("country", new Country());
        return "views-country-country";
    }

    @PostMapping("/saveCountry")
    public String country(@ModelAttribute Country country, Model model) {
        try {
            countryService.save(country);
        } catch (Exception e) {
            if(e.getMessage().equals(CountryValidationMessages.COUNTRYNAME_ALREADY_EXISTS)
                    || e.getMessage().equals(CountryValidationMessages.EMPTY_COUNTRYNAME_FIELD)){
                model.addAttribute("CounyryNmaeException", e.getMessage());
            }
            return "views-country-country";
        }
        return "redirect:/country";
    }

    @GetMapping("/deleteCountry")
    public String deleteCountry(@PathVariable int id) {
        countryService.delete(id);
        return "redirect:/country";
    }

    @GetMapping("/updateCountry{id}")
    public String getCoutry(@PathVariable int id, Model model){
        model.addAttribute("countryAttribute", countryService.findOne(id));
        return "views-country-updateCountry";
    }

    public String updateCountry(@ModelAttribute("country") Country country, @PathVariable int id, Model model){
        country.setId(id);
        countryService.update(country);
        model.addAttribute("countries", countryService.findAll());
        return "views-country-country";
    }
}

