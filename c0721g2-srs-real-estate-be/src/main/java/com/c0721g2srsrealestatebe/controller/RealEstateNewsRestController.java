package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/realEstateNewsRest")
@RestController
@CrossOrigin
public class RealEstateNewsRestController {

    @Autowired
    private IRealEstateNewsService realEstateNewsService;
    //    /studentRest/list?page=0
//    /studentRest/list?page=1
//    @GetMapping(value = {"/", "/list"})
//    public ResponseEntity<Page<RealEstateNews>> getListRealEstateNews(@PageableDefault(size = 2) Pageable pageable) {
//        Page<RealEstateNews> realEstateNewstList = this.realEstateNewsService.findAllRealEstateNewsByApproval(pageable);
//
//        if (realEstateNewstList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(realEstateNewstList, HttpStatus.OK);
//    }

    @GetMapping(value = {"/", "/list"})
    public ResponseEntity< Page<RealEstateNews> > getAllRealEstatesByApproval(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id"));
        Page< RealEstateNews > realEstatesList = realEstateNewsService.findAllRealEstateNewsByApproval(pageable);
        if (realEstatesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstatesList, HttpStatus.OK);
    }
}
