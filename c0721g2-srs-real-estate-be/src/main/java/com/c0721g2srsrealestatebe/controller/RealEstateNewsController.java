package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class RealEstateNewsController {
    @Autowired
    private IRealEstateNewsService realEstateNewsService;

    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    @GetMapping("/real-estate-new")
    public ResponseEntity< Page< RealEstateNews > > getHistoryPost(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(value = "customerId") String customerId) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerId
                (customerId, pageable);
        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }

    //    // 5.5.4 Search title and customerId and kindOfNew
//    @GetMapping("/real-estate-new")
//    public ResponseEntity< Page< RealEstateNews > > findNewByCustomerIdAndTitleAndKindOfNew(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(value = "customerId") String customerId,
//            @RequestParam(value = "title") String title,
//            @RequestParam(value = "kindOfNew") Integer kindOfNew) {
//        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
//        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndTitleAndType
//                (customerId, title, kindOfNew, pageable);
//        if (realEstateNewsPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
//    }
//    // 5.5.4 List search customerId and title
//    @GetMapping("/real-estate-new")
//    public ResponseEntity< Page< RealEstateNews > > findNewByCustomerIdAndTitle(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(value = "customerId") String customerId,
//            @RequestParam(value = "title") String title) {
//        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
//        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndTitle
//                (customerId, title, pageable);
//        if (realEstateNewsPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
//    }
//    // 5.5.4 List search customerId and kindOfNew
//    @GetMapping("/real-estate-new")
//    public ResponseEntity< Page< RealEstateNews > > findNewByCustomerIdAndKindOfNew(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(value = "customerId") String customerId,
//            @RequestParam(value = "kindOfNew") Integer kindOfNew) {
//        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
//        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndType
//                (customerId, kindOfNew, pageable);
//        if (realEstateNewsPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
//    }
    // 5.6.3 show Real estate new detail
    @GetMapping("/real-estate-new/{id}")
    public ResponseEntity< RealEstateNews > findNewById(@PathVariable(value = "id") String id) {
        Optional< RealEstateNews > realEstateNews = realEstateNewsService.findNewsById(id);
        if (realEstateNews.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNews.get(), HttpStatus.OK);
    }
}
