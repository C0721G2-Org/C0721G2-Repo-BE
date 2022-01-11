package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.service.realestatenews.EmailService;
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

@RequestMapping("/real-estate-new")
@RestController
public class RealEstateNewsController {
    @Autowired
    private IRealEstateNewsService realEstateNewsService;
    @Autowired
    private EmailService emailService;


    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    @GetMapping("/history-post")
    public ResponseEntity< Page< RealEstateNews > > showHistoryPostNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "title") Optional< String > title,
            @RequestParam(value = "kindOfNew") Optional< Integer > kindOfNew) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
        Page< RealEstateNews > realEstateNewsPage =null;
        if ((!title.isPresent()) && !kindOfNew.isPresent()) {

            realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerId
                    (customerId, pageable);
            System.out.println("s");
        }
        if (title.isPresent() && !kindOfNew.isPresent()) {
            realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndTitle
                    (customerId, title.get(), pageable);
        }
        if (!title.isPresent() && kindOfNew.isPresent()) {
            realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndType
                    (customerId, kindOfNew.get(), pageable);
        }
        if (title.isPresent() && kindOfNew.isPresent()) {
            realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndTitleAndType
                    (customerId, title.get(), kindOfNew.get(), pageable);
        }
        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }

    @GetMapping("/history-post/new-type")
    public ResponseEntity< Page< RealEstateNews > > getHistoryPostHouseOrLand(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "realNewType") Integer realNewType) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.findAllNewsByCustomerIdAndNewType
                (customerId, realNewType, pageable);
        if (realEstateNewsPage.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println("abc");
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }

    //     5.6.3 show Real estate new detail
    @GetMapping("/{id}")
    public ResponseEntity< RealEstateNews > findNewById(@PathVariable(value = "id") String id) {
        Optional< RealEstateNews > realEstateNews = realEstateNewsService.findNewsById(id);
        System.out.println(id);
        if (realEstateNews.isPresent()) {
            return new ResponseEntity<>(realEstateNews.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // 5.6.3 send mail to customer
    @PostMapping("/email")
    public ResponseEntity<Void> emailSend(@RequestParam ("customerMail") Optional<String> customerMail,
                                          @RequestParam ("name") Optional<String> name,
                                          @RequestParam ("phone")Optional<String> phone) {
        if(customerMail.isPresent() && name.isPresent() && phone.isPresent()){
            emailService.sendSimpleMessage(customerMail.get(),name.get(),phone.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
