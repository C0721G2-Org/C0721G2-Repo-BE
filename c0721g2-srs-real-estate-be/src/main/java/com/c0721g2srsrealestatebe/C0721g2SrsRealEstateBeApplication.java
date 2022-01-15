package com.c0721g2srsrealestatebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class C0721g2SrsRealEstateBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(C0721g2SrsRealEstateBeApplication.class, args);
    }
}
