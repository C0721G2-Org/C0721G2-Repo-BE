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
public class RealEstateNewsController_getListApproval {

    @Autowired
    private RealEstateNewsController realEstateNewsController;

    @Test
    public void getListApproval_5() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListPostApproval(PageRequest.of(0, 10));

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListApproval_6() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListPostApproval(PageRequest.of(0, 10));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(11, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BÁN GẤP CẶP ĐẤT ĐƯỜNG 2/9",
                responseEntity.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals("100.0",
                responseEntity.getBody().getContent().get(0).getArea());
    }
}
