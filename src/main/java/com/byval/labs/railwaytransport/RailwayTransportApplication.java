package com.byval.labs.railwaytransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.MapInfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RefreshScope
public class RailwayTransportApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwayTransportApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        Locale rus = new Locale("ru", "RU");
        localeResolver.setDefaultLocale(rus);
        return localeResolver;
    }
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    InfoContributor getInfoContributor() {
        Map<String, Object> details = new HashMap<>();
        details.put("nameApp", "Railway Transport");
        details.put("description", "It`s a Java Spring Boot application");
        details.put("developer", "Nikolai Byvaltsev");
        details.put("email", "nikolai-byvaltsev@email.com");
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("info", details);
        return new MapInfoContributor(wrapper);
    }

}
