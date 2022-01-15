package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.service.realestatenews.IDirectionService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateTypeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@RequestMapping("real-estate-new")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RealEstateNewsController {
    @Autowired
    IDirectionService iDirectionService;
    @Autowired
    IRealEstateTypeService iRealEstateTypeService;


    @Qualifier("realEstateNewsServiceImpl")
    @Autowired
    IRealEstateNewsService iRealEstateNewsService;

    // 5.7.1 Xem danh sách nhu cầu - Hiển thị List DoanhNV
    @GetMapping(value = "/list")
    public ResponseEntity<Page<RealEstateNews>> getListPostApproval(@PageableDefault(value = 10) Pageable pageable){
        Page<RealEstateNews> realEstateNewsPage = iRealEstateNewsService.findAllNewsPage(pageable);
        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }

    // 5.7.1 Xem danh sách nhu cầu - Tìm kiếm DoanhNV
    @GetMapping("/search")
    public ResponseEntity<Page<RealEstateNews>> searchListPostApproval(@PageableDefault(value = 10) Pageable pageable,
                                                                       @RequestParam(defaultValue = "",value ="kind_of_news" ) String kindOfNews,
                                                                       @RequestParam(defaultValue = "", value = "direction_id") String directionId,
                                                                       @RequestParam(defaultValue = "", value = "real_estate_type_id") String realEstateTypeId){
        Page<RealEstateNews> realEstateNewsPage =
                iRealEstateNewsService.searchRealEstateNewsByKindOfNewsAndRealEstateTypeAndDirection(pageable, kindOfNews, directionId, realEstateTypeId);
        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }

    // 5.7.1 Xem danh sách nhu cầu - Khi Không Duyệt hiển thị Dialog DoanhNV
    @DeleteMapping("delete/{id}")
    public ResponseEntity<RealEstateNews> delete(@PathVariable String id) {
        Optional<RealEstateNews> realEstateNewsOptional = this.iRealEstateNewsService.findByIdOp(id);
        if (!realEstateNewsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iRealEstateNewsService.deleteById(id);
        return new ResponseEntity<>(realEstateNewsOptional.get(), HttpStatus.OK);
    }
}
