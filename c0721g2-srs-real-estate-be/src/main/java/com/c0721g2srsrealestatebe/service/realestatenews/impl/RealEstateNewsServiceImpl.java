package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
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
    public List<RealEstateType> findAllByRealEstateType() {
        return null;
    }

    @Override
    public void save(RealEstateNews realEstateNews) {

    }

    @Override
    public void delete(RealEstateNews realEstateNews) {

    }

    @Override
    public Page<RealEstateNews> search(Pageable pageable, String idTypeSearch, String directionCusSearch, String areaSearch) {
        return null;
    }

    @Override
    public Page<RealEstateNews> findAllNewsByCustomerId(String customerId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RealEstateNews> findAllNewsPage(Pageable pageable) {
        return iRealEstateNewsRepository.findAll(pageable);
    }

    @Override
    public List<Direction> findAllByDirection() {
        return null;
    }
}
