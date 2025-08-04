package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        // This line runs the Spring Boot application as before.
        SpringApplication.run(SpringLearnApplication.class, args);

        // This line calls our new method to test the XML configuration.
        displayCountry();
    }

    /**
     * This method loads the Spring IoC container from the country.xml file,
     * retrieves the 'country' bean, and logs its details.
     */
    public static void displayCountry() {
        LOGGER.info("START - displayCountry");

        // 1. Create the ApplicationContext from the XML file.
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // 2. Get the bean with the ID "country".
        Country country = context.getBean("country", Country.class);

        // 3. Log the details of the retrieved bean.
        LOGGER.debug("Country : {}", country.toString());

        LOGGER.info("END - displayCountry");
    }
}
