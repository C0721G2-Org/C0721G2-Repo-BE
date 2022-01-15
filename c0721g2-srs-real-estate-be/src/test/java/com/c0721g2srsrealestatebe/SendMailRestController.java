package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.controller.RealEstateNewsController;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


@SpringBootTest
@AutoConfigureMockMvc
public class SendMailRestController {
//    @Autowired
//    private RealEstateNewsController estateNewsController;
//
//    @Test
//    public void sendMailSuccess() {
//        ResponseEntity<  Void > responseEntity
//                = this.estateNewsController.emailSend
//                ("Ductai4992@gmail.com", "Tai", "0918876320");
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//    }
//    @Test
//    public void sendMailError() {
//        ResponseEntity<  Void > responseEntity
//                = this.estateNewsController.emailSend
//                ("", "Tai", "0918876320");
//
//        Assertions.assertEquals(501, responseEntity.getStatusCode().isError());
//    }
}
