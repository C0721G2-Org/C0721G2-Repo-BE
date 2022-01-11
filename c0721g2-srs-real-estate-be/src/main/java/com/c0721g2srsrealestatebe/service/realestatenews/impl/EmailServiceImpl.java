package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.service.realestatenews.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
//    @Qualifier("getJavaMailSender")
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public void sendSimpleMessage(String customerEmail, String name, String phone) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hungthinhc07g2@gmail.com");
        message.setTo(customerEmail);
        message.setSubject("Một khách hàng quan tâm tới bài đăng của bạn");
        message.setText("Chào bạn \n" +
                "Khách hàng" + name + " số điện thoại " + phone + " đang quan tâm đến bài đăng của bạn tên trang \n" +
                "hungthinhgroup.com.\n" +
                "Thanks and Regards\n");
        emailSender.send(message);
    }
}
