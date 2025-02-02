package com.eusoof.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
private static final Logger log = LoggerFactory.getLogger(WelcomeMessage.class);


    public String getWelcomeMessage() {
        return "Welcome to Spring Boot";
    }





}
