package com.c0721g2srsrealestatebe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    // Replace with your email here:
    public static final String MY_EMAIL = "...@gmail.com";

    // Replace password!!
    public static final String MY_PASSWORD = "...";

    // And receiver!
    public static final String MAIL_RECEIVER= "";

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        // mail FROM
        mailSender.setUsername(MY_EMAIL);
        mailSender.setPassword(MY_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
