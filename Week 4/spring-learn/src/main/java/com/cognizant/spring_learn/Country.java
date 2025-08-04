package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // Empty constructor with a log message
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    // Getters and Setters with log messages
    public String getCode() {
        LOGGER.debug("Inside getCode()");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode(): {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName()");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName(): {}", name);
        this.name = name;
    }

    // toString() method to display object state
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
