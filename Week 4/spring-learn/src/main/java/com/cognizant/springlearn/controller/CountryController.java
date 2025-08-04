package com.cognizant.springlearn.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {

    @RequestMapping("/country")
    public Country getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        // We ask for the bean with the ID "in" to get India specifically
        Country country = context.getBean("in", Country.class);
        return country;
    }

    /**
     * @GetMapping("/countries/{code}") maps this method to URLs like "/countries/IN", "/countries/us", etc.
     * @PathVariable("code") tells Spring to take the value from the {code} part of the URL
     * and pass it into the 'code' method parameter.
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        // Create an instance of the service and call the method to find the country.
        CountryService countryService = new CountryService();
        return countryService.getCountry(code);
    }
}
