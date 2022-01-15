package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import com.c0721g2srsrealestatebe.repository.realestatenews.IDirectionRepository;
import com.c0721g2srsrealestatebe.repository.realestatenews.IRealEstateNewsRepository;
import com.c0721g2srsrealestatebe.repository.realestatenews.IRealEstateTypeRepository;
import com.c0721g2srsrealestatebe.service.realestatenews.IRealEstateNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealEstateNewsServiceImpl implements IRealEstateNewsService {
    @Autowired
    IRealEstateNewsRepository iRealEstateNewsRepository;

    @Autowired
    IRealEstateTypeRepository iRealEstateTypeRepository;

    @Autowired
    IDirectionRepository iDirectionRepository;

    // 5.7.1 Xem danh sách nhu cầu - Override method hiển thị List DoanhNV
    @Override
    public Page<RealEstateNews> findAllNewsPage(Pageable pageable) {
        return iRealEstateNewsRepository.findAllByRealEstateNews(pageable);
    }
    // 5.7.1 Xem danh sách nhu cầu - Override method tìm kiếm DoanhNV
    @Override
    public Page<RealEstateNews> searchRealEstateNewsByKindOfNewsAndRealEstateTypeAndDirection(Pageable pageable,
                                                                                              String kinOfNews,
                                                                                              String directionId,
                                                                                              String realEstateTypeId) {
        return iRealEstateNewsRepository.searchRealEstateNewsByKindOfNewsAndRealEstateTypeAndDirection(pageable,
                "%" +kinOfNews+ "%","%" +directionId+ "%", "%" +realEstateTypeId+ "%");
    }
    // 5.7.1 Xem danh sách nhu cầu - Override method Không Duyệt hiển thị Dialog DoanhNV
    @Override
    public Optional<RealEstateNews> findByIdOp(String id) {
        return iRealEstateNewsRepository.findById(id);
    }
    // 5.7.1 Xem danh sách nhu cầu - Override method Không Duyệt hiển thị Dialog DoanhNV
    @Override
    public void deleteById(String id) {
        iRealEstateNewsRepository.deleteById(id);
    }






    @Override
    public List<RealEstateType> findAllByRealEstateType() {
        return iRealEstateTypeRepository.findAll();
    }

    @Override
    public void save(RealEstateNews realEstateNews) {
        //update data
    }

    @Override
    public void delete(RealEstateNews realEstateNews) {
        //update data
    }

    @Override
    public Page<RealEstateNews> findAllNewsByCustomerId(String customerId, Pageable pageable) {
        return null;
    }

    @Override
    public List<Direction> findAllByDirection() {
        return iDirectionRepository.findAll();
    }


}
