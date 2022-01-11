package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.model.image.Image;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.repository.realestatenews.IRealEstateNewsRepository;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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

    // 5.5.4 real new type
    @Override
    public Page< RealEstateNews > findAllNewsByCustomerIdAndNewType(String customerId, Integer realNewType, Pageable pageable) {
        return iRealEstateNewsRepository.findAllNewsByCustomerIdAndRealNewType(customerId,realNewType, pageable);
    }

}
