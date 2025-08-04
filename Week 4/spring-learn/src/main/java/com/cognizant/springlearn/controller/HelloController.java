package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController marks this class as a Spring REST controller.
 * This means it's ready to handle incoming web requests.
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * @GetMapping("/hello") maps this method to handle HTTP GET requests
     * for the URL "/hello".
     *
     * @return A simple String which Spring Web will automatically send
     * back as the HTTP response body.
     */
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START - sayHello");
        LOGGER.info("END - sayHello");
        return "Hello World!!";
    }
}
