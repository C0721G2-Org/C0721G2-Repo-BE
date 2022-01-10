package com.c0721g2srsrealestatebe.service.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRealEstateNewsService{

    List<RealEstateType>findAllByRealEstateType();
    void save(RealEstateNews realEstateNews);
    void delete(RealEstateNews realEstateNews);

    Page<RealEstateNews> search(Pageable pageable, String idTypeSearch, String directionCusSearch, String areaSearch);

    Page<RealEstateNews> findAllNewsByCustomerId(String customerId, Pageable pageable);
    Page<RealEstateNews> findAllNewsPage( Pageable pageable);

    List<Direction> findAllByDirection();
}
