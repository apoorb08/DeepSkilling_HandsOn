package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts") // Sets the base path for all methods in this controller
public class AccountController {

    // Handles GET requests to /accounts/{number}
    @GetMapping("/{number}")
    public Account getAccountDetails(@PathVariable String number) {
        // Create and return a dummy Account object
        // The 'number' from the URL is used in the response
        return new Account(number, "savings", 234343);
    }
}