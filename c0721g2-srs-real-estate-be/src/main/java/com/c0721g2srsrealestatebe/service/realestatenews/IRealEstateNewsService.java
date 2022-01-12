package com.c0721g2srsrealestatebe.service.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IRealEstateNewsService {
    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    Page< RealEstateNews > findAllNewsBySearchField(String customerId,
                                                                  String title,
                                                                  String typeOfNew,
                                                                  String realNewType,
                                                                  Pageable pageable);
    ;
    // 5.6.3 show Real estate new detail
    Optional<RealEstateNews> findNewsById(String Id);

    RealEstateNews saveRealEstateNews(RealEstateNews realEstateNews);

}