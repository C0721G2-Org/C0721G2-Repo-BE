package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.controller.RealEstateNewsController;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.ResponseEntity;
@SpringBootTest
@AutoConfigureMockMvc
public class RealEstateRestController_postHistoryTaiVD {
    @Autowired
    private RealEstateNewsController estateNewsController;

    @Test
    public void showHistoryPostNews() {

        ResponseEntity< Page< RealEstateNews > > responseEntity
                = this.estateNewsController.showHistoryPostNews(PageRequest.of(0, 2));

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

}
