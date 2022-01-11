package com.c0721g2srsrealestatebe.service.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IRealEstateNewsService {


    List<RealEstateNews> findAllRealEstateNews();

    Page<RealEstateNews> findAllRealEstateNewsByApproval(Pageable pageable);

    Page<RealEstateNews> findAllRealEstateNewsByApprovalAndAddress(String address,Pageable pageable);

}
