package com.c0721g2srsrealestatebe.service.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IRealEstateNewsService{

    List<RealEstateType>findAllByRealEstateType();
    List<Direction> findAllByDirection();
    void save(RealEstateNews realEstateNews);
    void delete(RealEstateNews realEstateNews);
    Page<RealEstateNews> findAllNewsByCustomerId(String customerId, Pageable pageable);



    // 5.7.1 Xem danh sách nhu cầu - Method Tìm kiếm DoanhNV
    Page<RealEstateNews> searchRealEstateNewsByKindOfNewsAndRealEstateTypeAndDirection(Pageable pageable, String kindOfNews, String directionId, String realEstateTypeId);

    // 5.7.1 Xem danh sách nhu cầu - Method hiển thị List DoanhNV
    Page<RealEstateNews> findAllNewsPage( Pageable pageable);

    // 5.7.1 Xem danh sách nhu cầu - Method Không duyệt gọi Dialog DoanhNV
    Optional<RealEstateNews> findByIdOp(String id);

    // 5.7.1 Xem danh sách nhu cầu - Method Không duyệt gọi Dialog DoanhNV
    void deleteById(String id);
}
