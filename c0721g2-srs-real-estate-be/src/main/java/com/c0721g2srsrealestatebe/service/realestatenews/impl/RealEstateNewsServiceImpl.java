package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.repository.realestatenews.IRealEstateNewsRepository;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateNewsServiceImpl implements IRealEstateNewsService {
    @Autowired
    IRealEstateNewsRepository iRealEstateNewsRepository;

    @Override
    public List<RealEstateNews> findAllRealEstateNews() {
        return iRealEstateNewsRepository.findAll();
    }

    @Override
    public Page<RealEstateNews> findAllRealEstateNewsByApproval(Pageable pageable) {
        return iRealEstateNewsRepository.findAllRealEstateNewsByApproval(pageable);
    }

    @Override
    public Page<RealEstateNews> findAllRealEstateNewsByApprovalAndAddress(String address, Pageable pageable) {
        return iRealEstateNewsRepository.findAllRealEstateNewsByApprovalAndAddress(address,pageable);
    }

}
