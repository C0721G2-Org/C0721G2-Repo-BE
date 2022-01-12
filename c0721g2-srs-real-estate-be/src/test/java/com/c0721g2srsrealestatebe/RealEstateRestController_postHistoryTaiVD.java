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
public class RealEstateRestController_postHistoryTaiVD {
    @Autowired
    private RealEstateNewsController estateNewsController;
    @Test
    public void showHistoryPostNews_KH1000() {

        ResponseEntity< Page< RealEstateNews > > responseEntity
                = this.estateNewsController.showHistoryPostNews
                (0, "KH1000", "", "", "");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    @Test
    public void showHistoryPostNews_KH0002() {

        ResponseEntity< Page< RealEstateNews > > responseEntity
                = this.estateNewsController.showHistoryPostNews
                (0, "KH-0002", "", "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1002",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Nguyễn Hữu Thọ, Thanh Khê, Đà Nẵng",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(1).getArea());
        Assertions.assertEquals("Bán đất nền trung tâm thành phố, " +
                        "Đường rộng, mặt tiền gần sân bay gần trung tâm",
                responseEntity.getBody().getContent().get(1).getDescription());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getKindOfNews());
        Assertions.assertEquals(15000000000.0,
                responseEntity.getBody().getContent().get(1).getPrice());
        Assertions.assertEquals("Bán đất mặt tiền Nguyễn Hữu Thọ",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("KH-0002",
                responseEntity.getBody().getContent().get(1).getCustomer().getId());
        Assertions.assertEquals(4,
                responseEntity.getBody().getContent().get(1).getDirection().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getRealEstateType().getId());
    }
    @Test
    public void showHistoryPostNews_KH0002_Title() {

        ResponseEntity< Page< RealEstateNews > > responseEntity
                = this.estateNewsController.showHistoryPostNews
                (0, "KH-0002", "Thọ", "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1002",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Nguyễn Hữu Thọ, Thanh Khê, Đà Nẵng",
                responseEntity.getBody().getContent().get(0).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(0).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(0).getArea());
        Assertions.assertEquals("Bán đất nền trung tâm thành phố, Đường rộng, " +
                        "mặt tiền gần sân bay gần trung tâm",
                responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getKindOfNews());
        Assertions.assertEquals(15000000000.0,
                responseEntity.getBody().getContent().get(0).getPrice());
        Assertions.assertEquals("Bán đất mặt tiền Nguyễn Hữu Thọ",
                responseEntity.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals("KH-0002",
                responseEntity.getBody().getContent().get(0).getCustomer().getId());
        Assertions.assertEquals(4,
                responseEntity.getBody().getContent().get(0).getDirection().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getRealEstateType().getId());
    }
    @Test
    public void showHistoryPostNews_KH0002_Title_KindOfNew() {

        ResponseEntity< Page< RealEstateNews > > responseEntity
                = this.estateNewsController.showHistoryPostNews
                (0, "KH-0002", "Thọ", "1", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1002",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Nguyễn Hữu Thọ, Thanh Khê, Đà Nẵng",
                responseEntity.getBody().getContent().get(0).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(0).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(0).getArea());
        Assertions.assertEquals("Bán đất nền trung tâm thành phố, Đường rộng, " +
                        "mặt tiền gần sân bay gần trung tâm",
                responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getKindOfNews());
        Assertions.assertEquals(15000000000.0,
                responseEntity.getBody().getContent().get(0).getPrice());
        Assertions.assertEquals("Bán đất mặt tiền Nguyễn Hữu Thọ",
                responseEntity.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals("KH-0002",
                responseEntity.getBody().getContent().get(0).getCustomer().getId());
        Assertions.assertEquals(4,
                responseEntity.getBody().getContent().get(0).getDirection().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getRealEstateType().getId());
    }
    @Test
    public void showHistoryPostNews_KH0002_Title_KindOfNew_RealNewType() {

        ResponseEntity< Page< RealEstateNews > > responseEntity
                = this.estateNewsController.showHistoryPostNews
                (0, "KH-0002", "Thọ", "1", "1");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1002",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Nguyễn Hữu Thọ, Thanh Khê, Đà Nẵng",
                responseEntity.getBody().getContent().get(0).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(0).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(0).getArea());
        Assertions.assertEquals("Bán đất nền trung tâm thành phố, Đường rộng, " +
                        "mặt tiền gần sân bay gần trung tâm",
                responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getKindOfNews());
        Assertions.assertEquals(15000000000.0,
                responseEntity.getBody().getContent().get(0).getPrice());
        Assertions.assertEquals("Bán đất mặt tiền Nguyễn Hữu Thọ",
                responseEntity.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals("KH-0002",
                responseEntity.getBody().getContent().get(0).getCustomer().getId());
        Assertions.assertEquals(4,
                responseEntity.getBody().getContent().get(0).getDirection().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getRealEstateType().getId());
    }
}
