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
    Page< RealEstateNews > findAllNewsByCustomerId(String customerId,
                                                   Pageable pageable);

    // 5.5.4 Search title and customerId and kindOfNew
    Page< RealEstateNews > findAllNewsByCustomerIdAndTitleAndType(String customerId,
                                                                  String title,
                                                                  Integer typeOfNew,
                                                                  Pageable pageable);

    // 5.5.4 List search customerId and title
    Page< RealEstateNews > findAllNewsByCustomerIdAndTitle(String customerId,
                                                           String title,
                                                           Pageable pageable);

    // 5.5.4 List search customerId and kindOfNew
    Page< RealEstateNews > findAllNewsByCustomerIdAndType(String customerId,
                                                          Integer typeOfNew,
                                                          Pageable pageable);
    // 5.6.3 show Real estate new detail
    Optional<RealEstateNews> findNewsById(String Id);

    // 5.5.4 List search customerId and Nhà
    Page< RealEstateNews > findAllNewsByCustomerIdAndNewType(String customerId,
                                                             Integer realNewType,
                                                             Pageable pageable);

    RealEstateNews saveRealEstateNews(RealEstateNews realEstateNews);

}
