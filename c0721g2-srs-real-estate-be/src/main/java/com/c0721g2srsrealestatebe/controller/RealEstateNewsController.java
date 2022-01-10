package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.dto.RealEstateDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.model.image.Image;
import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import com.c0721g2srsrealestatebe.service.image.IImageService;
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
@RequestMapping("/real-estate-new")
public class RealEstateNewsController {
    @Autowired
    private IRealEstateNewsService realEstateNewsService;
    @Autowired
    private IImageService iImageService;

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

    @GetMapping("/{id}")
    public ResponseEntity< RealEstateNews > findNewById(@PathVariable(value = "id") String id) {
        Optional< RealEstateNews > realEstateNews = realEstateNewsService.findNewsById(id);
        if (!realEstateNews.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNews.get(), HttpStatus.OK);
    }

    // 5.6.2 add Real estate new detail
    @PostMapping("/post")
    public void saveRealEstateNews(@RequestBody RealEstateDTO realEstateDTO){
        RealEstateNews news = this.formatDTO(realEstateDTO);
        System.out.println(news);
        RealEstateNews realEstateNews = realEstateNewsService.saveRealEstateNews(news);
        realEstateDTO.getImageList().forEach((imageDTO -> {
            Image image = new Image();
            image.setUrl(imageDTO.getUrl());
            iImageService.saveImg(image,realEstateNews.getId());
            })
        );
    }

    public RealEstateNews formatDTO(RealEstateDTO realEstateDTO){
        RealEstateNews realEstateNews = new RealEstateNews();
        Customer customer = new Customer();
        customer.setId(realEstateDTO.getCustomer().getId());
        realEstateNews.setTitle(realEstateDTO.getTitle());
        realEstateNews.setDescription(realEstateDTO.getDescription());
        realEstateNews.setAddress(realEstateDTO.getAddress());
        realEstateNews.setArea(realEstateDTO.getArea());
        realEstateNews.setPrice(realEstateDTO.getPrice());
        realEstateNews.setApproval(1);
        realEstateNews.setKindOfNews(realEstateDTO.getKindOfNews());
        realEstateNews.setStatus(realEstateDTO.getStatus());
        realEstateNews.setRealEstateType(new RealEstateType(realEstateDTO.getRealEstateType().getId()));
        realEstateNews.setDirection(new Direction(realEstateDTO.getDirection().getId()));
        realEstateNews.setCustomer(customer);
        return realEstateNews;
    }
}
