package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.repository.realestatenews.IRealEstateNewsRepository;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RealEstateNewsServiceImpl implements IRealEstateNewsService {
    @Autowired
    IRealEstateNewsRepository iRealEstateNewsRepository;

    @Override
    public Page<RealEstateNews> findAllRealEstateNewsByFilter(String address, String kindOfNews, String realEstateType, String direction, String minPrice, String maxPrice, Pageable pageable) {
        return iRealEstateNewsRepository.findAllRealEstateNewsByFilter(address,kindOfNews, realEstateType, direction,  minPrice,  maxPrice, pageable);
    }

}
