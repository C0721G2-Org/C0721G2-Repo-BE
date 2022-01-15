package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.dto.RealEstateDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.model.image.Image;
import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.Email;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import com.c0721g2srsrealestatebe.service.image.IImageService;
import com.c0721g2srsrealestatebe.service.realestatenews.EmailService;
import com.c0721g2srsrealestatebe.service.realestatenews.IDirectionService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/real-estate-new")
public class RealEstateNewsController {
    @Autowired
    private IRealEstateNewsService realEstateNewsService;
    @Autowired
    private IImageService iImageService;
    @Autowired
    private EmailService emailService;
    @Autowired
    IRealEstateTypeService iRealEstateTypeService;
    @Autowired
    IDirectionService iDirectionService;
    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    @GetMapping("/history-post")
    public ResponseEntity< Page< RealEstateNews > > showHistoryPostNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "", value = "customerId") String customerId,
            @RequestParam(defaultValue = "", value = "title") String title,
            @RequestParam(defaultValue = "", value = "kindOfNew") String kindOfNew,
            @RequestParam(defaultValue = "", value = "realNewType") String realNewType) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id"));
        Page< RealEstateNews > realEstateNewsPage = realEstateNewsService.
                findAllNewsBySearchField(customerId, title, kindOfNew, realNewType, pageable);

        if (realEstateNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(realEstateNewsPage, HttpStatus.OK);
    }
    //     5.6.3 show Real estate new detail
    @GetMapping("/{id}")
    public ResponseEntity< RealEstateNews > findNewById(@PathVariable(value = "id") String id) {
        Optional< RealEstateNews > realEstateNews = realEstateNewsService.findNewsById(id);
//        System.out.println(id);
        if (realEstateNews.isPresent()) {
            return new ResponseEntity<>(realEstateNews.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 5.6.3 send mail to customer
    @PostMapping("/email")
    public ResponseEntity< Void > emailSend(@RequestBody() Email email) throws UnsupportedEncodingException, MessagingException {
        if (email == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            emailService.sendSimpleMessage(email.getCustomerMail(), email.getName(), email.getPhone());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // 5.6.2 add Real estate new detail
    @PostMapping("/post")
    public ResponseEntity< List< FieldError > > saveRealEstateNews(@RequestBody @Valid RealEstateDTO realEstateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult);
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        RealEstateNews news = this.copyProperties(realEstateDTO);
        RealEstateNews realEstateNews = realEstateNewsService.saveRealEstateNews(news);
//        System.out.println(realEstateNews);
        realEstateDTO.getImageList().forEach((imageDTO -> {
                    Image image = new Image();
                    image.setUrl(imageDTO.getUrl());
                    iImageService.saveImg(image, realEstateNews.getId());
                })
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public RealEstateNews copyProperties(RealEstateDTO realEstateDTO) {
        RealEstateNews realEstateNews = new RealEstateNews();
        BeanUtils.copyProperties(realEstateDTO, realEstateNews);
        Customer customer = new Customer();
        customer.setId(realEstateDTO.getCustomer().getId());
        realEstateNews.setRealEstateType(new RealEstateType(realEstateDTO.getRealEstateType().getId()));
        realEstateNews.setDirection(new Direction(realEstateDTO.getDirection().getId()));
        realEstateNews.setCustomer(customer);
        return realEstateNews;
    }
}