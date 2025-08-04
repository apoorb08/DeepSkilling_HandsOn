package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

@Service
public class CountryService {

    /**
     * This method finds a specific country from the list defined in country.xml
     * based on a provided country code.
     *
     * @param code The 2-letter country code to search for.
     * @return The matching Country object.
     */
    public Country getCountry(String code) {
        // 1. Load the Spring context from the XML file.
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // 2. Get the entire list of countries.
        List<Country> countries = (List<Country>) context.getBean("countryList");

        // 3. Use a lambda expression (stream) to find the matching country.
        // This is a modern and concise way to iterate and filter a list.
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); // Returns null if no country is found
    }
}
