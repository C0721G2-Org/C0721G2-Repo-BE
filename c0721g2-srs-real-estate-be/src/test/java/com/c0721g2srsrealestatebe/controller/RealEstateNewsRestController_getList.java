package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class RealEstateNewsRestController_getList {
    @Autowired
    private RealEstateNewsRestController realEstateNewsRestController;

    @Test
    public void getListRealEstateNew_1() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsRestController.getListRealEstateNews(100);
        //expected: kq mong muốn, res.... kq nhận được
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }



    @Test
    public void getListRealEstateNew_2() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsRestController.getListRealEstateNews(0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(6, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Huyền",
//                responseEntity.getBody().getContent().get(1).get());
//        Assertions.assertEquals("2002-05-03",
//                responseEntity.getBody().getContent().get(1).getDateOfBirth());
    }
}
