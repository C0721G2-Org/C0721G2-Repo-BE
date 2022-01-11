package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.customid.CustomIdGenerator;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.repository.realestatenews.IRealEstateNewsRepository;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RealEstateNewsServiceImpl implements IRealEstateNewsService {
    @Autowired
    private IRealEstateNewsRepository iRealEstateNewsRepository;

    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    @Override
    public Page< RealEstateNews > findAllNewsByCustomerId(String customerId, Pageable pageable) {
        return iRealEstateNewsRepository.findAllNewsByCustomerId(customerId, pageable); 
    }
    // 5.5.4 Search title and customerId and kindOfNew
    @Override
    public Page< RealEstateNews > findAllNewsByCustomerIdAndTitleAndType
    (String customerId, String title, Integer typeOfNew, Pageable pageable) {
        return iRealEstateNewsRepository.findAllNewsByCustomerIdAndTitleAndType
                (customerId, title, typeOfNew, pageable);
    }

    // 5.5.4 List search customerId and title
    @Override
    public Page< RealEstateNews > findAllNewsByCustomerIdAndTitle
    (String customerId, String title, Pageable pageable) {
        return iRealEstateNewsRepository.findAllNewsByCustomerIdAndTitle(customerId, title, pageable);
    }

    // 5.5.4 List search customerId and kindOfNew
    @Override
    public Page< RealEstateNews > findAllNewsByCustomerIdAndType
    (String customerId, Integer typeOfNew, Pageable pageable) {
        return iRealEstateNewsRepository.findAllNewsByCustomerIdAndType(customerId, typeOfNew, pageable);
    }

    // 5.6.3 show Real estate new detail
    @Override
    public Optional< RealEstateNews > findNewsById(String id) {
        return iRealEstateNewsRepository.findById(id);
    }

    // 5.6.3 show Real estate new detail
    @Override
    public Page< RealEstateNews > findAllNewsByCustomerIdAndNewType(String customerId, Integer realNewType, Pageable pageable) {
        return iRealEstateNewsRepository.findAllNewsByCustomerIdAndRealNewType(customerId,realNewType, pageable);
    }


    // 5.6.2 add Real estate new detail
    @Override
    public RealEstateNews saveRealEstateNews(RealEstateNews realEstateNews) {
//        realEstateNewsRepository.saveNews(realEstateNews.getAddress(),realEstateNews.getApproval(),realEstateNews.getArea(),realEstateNews.getDescription(),
//                realEstateNews.getKindOfNews(),realEstateNews.getPrice(),realEstateNews.getStatus(),realEstateNews.getTitle(),realEstateNews.getCustomer().getId(),
//                realEstateNews.getDirection().getId(),realEstateNews.getRealEstateType().getId());
        System.out.println(123);
        System.out.println(realEstateNews);
        iRealEstateNewsRepository.save(realEstateNews);
        System.out.println(iRealEstateNewsRepository.lastId());
        return iRealEstateNewsRepository.findNewsById(iRealEstateNewsRepository.lastId()).orElse(null);
    }

}