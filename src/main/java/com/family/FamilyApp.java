package com.family;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;



/**
 * @author
 */

@Slf4j
@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
@EnableAsync
@EnableScheduling
public class FamilyApp {

    @Value("${application.name}")
    String applicationName;

    @Value("${spring.profiles.active}")
    String currentActiveEnv;



    public static void main(String[] args) {
        try {
            SpringApplication.run(FamilyApp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {
            log.info("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                log.info(beanName);
            }
            init();
        };
    }


    public void init() {
        log.info("---------Started: {} in {}---------", applicationName, currentActiveEnv);
    }
}