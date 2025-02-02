package com.eusoof.runnerz;

import com.eusoof.runnerz.run.Location;
import com.eusoof.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {

		//ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		SpringApplication.run(Application.class, args);

		//WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		//var welcomeMessage = new WelcomeMessage();
		//System.out.println(welcomeMessage.getWelcomeMessage());

		log.info("Welcome to Spring Boot!!");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			log.info("Welcome to Spring Boot!!!!");
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusDays(2), 5, Location.OUTDOOR);
			log.info("Run: {}", run);
		};
	}

}
