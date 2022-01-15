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
//
//    @Autowired
//    private RealEstateNewsController realEstateNewsController;
//
//    @Test
//    public void getListApproval_5() {
//        ResponseEntity<Page<RealEstateNews>> responseEntity
//                = this.realEstateNewsController.getListPostApproval(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void getListApproval_6() {
//        ResponseEntity<Page<RealEstateNews>> responseEntity
//                = this.realEstateNewsController.getListPostApproval(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(11, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("BÁN GẤP CẶP ĐẤT ĐƯỜNG 2/9",
//                responseEntity.getBody().getContent().get(0).getTitle());
//        Assertions.assertEquals(100,
//                responseEntity.getBody().getContent().get(0).getArea());
//        Assertions.assertEquals("BD-1001",
//                responseEntity.getBody().getContent().get(0).getId());
//        Assertions.assertEquals("Đường 2/9, Phường Hòa Cường Bắc, Hải Châu, Đà Nẵng",
//                responseEntity.getBody().getContent().get(0).getAddress());
//        Assertions.assertEquals(1,
//                responseEntity.getBody().getContent().get(0).getApproval());
//        Assertions.assertEquals("Chính chủ cần bán cặp đất mặt tiền đường 2/9, trục đường chính của thành phố Đà Nẵng,\n" +
//                        "  Nằm trong cụm khai thác tổ hợp khách sạn, du lịch, văn phòng cho thuê...\n" +
//                        "  Đối diện khu thương mại tổ hợp dịch vụ du lịch bậc nhất Đà Nẵng.",
//                responseEntity.getBody().getContent().get(0).getDescription());
//        Assertions.assertEquals(1,
//                responseEntity.getBody().getContent().get(0).getKindOfNews());
//        Assertions.assertEquals(15000000000.0,
//                responseEntity.getBody().getContent().get(0).getPrice());
//        Assertions.assertEquals(1,
//                responseEntity.getBody().getContent().get(0).getStatus());
//        Assertions.assertEquals("KH-0002",
//                responseEntity.getBody().getContent().get(0).getCustomer().getId());
//        Assertions.assertEquals(1,
//                responseEntity.getBody().getContent().get(0).getDirection().getId());
//        Assertions.assertEquals(1,
//                responseEntity.getBody().getContent().get(0).getRealEstateType().getId());
//    }
}
