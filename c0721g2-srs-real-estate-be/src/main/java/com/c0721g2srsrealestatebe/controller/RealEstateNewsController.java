package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import com.c0721g2srsrealestatebe.service.realestatenews.IDirectionService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequestMapping("/real-estate-new")
@RestController
public class RealEstateNewsController {
    @Autowired
    IDirectionService iDirectionService;
    @Autowired
    IRealEstateTypeService iRealEstateTypeService;
    @Qualifier("realEstateNewsServiceImpl")
    @Autowired
    IRealEstateNewsService iRealEstateNewsService;


    @GetMapping(value = "/direction")
    public ResponseEntity<List<Direction>> getDirection() {
        List<Direction> directions = iDirectionService.findAllDirection();
        if (directions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(directions, HttpStatus.OK);
    }

    @GetMapping(value = "/realEstateType")
    public ResponseEntity<List<RealEstateType>> getRealEstateType() {
        List<RealEstateType> realEstateTypes = iRealEstateTypeService.findAllRealEstateType();
        if (realEstateTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateTypes, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<RealEstateNews>> getListPostApproval(@PageableDefault(value = 5) Pageable pageable){
        Page<RealEstateNews> realEstateNewsPage = iRealEstateNewsService.findAllNewsPage(pageable);
        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }
}
