package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RealEstateNewsController {
    @Autowired
    private IRealEstateNewsService realEstateNewsService;
    @Autowired
    IRealEstateTypeService iRealEstateTypeService;

    @GetMapping(value = "/dealEstateType")
    public List<RealEstateType> realEstateTypes(){
        return iRealEstateTypeService.realEstateTypeList();
    }

//    // 5.6.1  List real-estate ket hop tim kiem approvel, address, kindOfNews, realEstateType
    @GetMapping("/list-real-estate-new/search")
    public ResponseEntity< Page< RealEstateNews > > getListRealEstateNews(
            @RequestParam(defaultValue = "", value = "address") String address,
            @RequestParam(defaultValue = "", value = "kindOfNews") String kindOfNews,
            @RequestParam(defaultValue = "", value = "realEstateType") String realEstateType,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.
                findAllRealEstateNewsByFilter(address, kindOfNews,realEstateType, pageable);

        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }
}
