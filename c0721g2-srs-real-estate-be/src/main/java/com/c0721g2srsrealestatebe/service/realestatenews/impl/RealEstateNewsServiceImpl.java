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
    private IRealEstateNewsRepository realEstateNewsRepository;

    @Override
    public Page<RealEstateNews> findAllNewsByCustomerId(String customerId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RealEstateNews> findAllNewsByCustomerIdAndTitleAndType(String customerId, String title, Integer typeOfNew, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RealEstateNews> findAllNewsByCustomerIdAndTitle(String customerId, String title, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RealEstateNews> findAllNewsByCustomerIdAndType(String customerId, Integer typeOfNew, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<RealEstateNews> findNewsById(String newId) {
        return realEstateNewsRepository.findById(newId);
    }

    @Override
    public RealEstateNews saveRealEstateNews(RealEstateNews realEstateNews) {
//        realEstateNewsRepository.saveNews(realEstateNews.getAddress(),realEstateNews.getApproval(),realEstateNews.getArea(),realEstateNews.getDescription(),
//                realEstateNews.getKindOfNews(),realEstateNews.getPrice(),realEstateNews.getStatus(),realEstateNews.getTitle(),realEstateNews.getCustomer().getId(),
//                realEstateNews.getDirection().getId(),realEstateNews.getRealEstateType().getId());
        realEstateNewsRepository.save(realEstateNews);
        System.out.println(realEstateNewsRepository.lastId());
        return realEstateNewsRepository.findNewsById(realEstateNewsRepository.lastId()).orElse(null);
    }

}
