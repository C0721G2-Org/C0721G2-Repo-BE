package com.c0721g2srsrealestatebe.repository.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRealEstateNewsRepository extends JpaRepository<RealEstateNews, Integer> {

    @Query(value = " select * \n" +
            " from real_estate_news\n " +
            " where address like concat('%',trim(:address),'%')\n " +
            " and kind_of_news like concat('%',trim(:kindOfNews),'%')\n " +
            " and real_estate_type_id like concat('%',trim(:realEstateType),'%')\n " +
            " and direction_id like concat('%',trim(:direction),'%')\n " +
            " and price between :minPrice and :maxPrice " +
            " and approval =2 ", nativeQuery = true, countQuery = " select count(*) from real_estate_news " +
            " where address like concat('%',trim(:address),'%') " +
            " and kind_of_news like concat('%',trim(:kindOfNews),'%') " +
            " and real_estate_type_id like concat('%',trim(:realEstateType),'%') " +
            " and direction_id like concat('%',trim(:direction),'%') " +
            " and price between :minPrice and :maxPrice " +
            " and approval =2 ")
    Page<RealEstateNews> findAllRealEstateNewsByFilter(@Param("address")String address,
                                                       @Param("kindOfNews")String kindOfNews,
                                                       @Param("realEstateType")String realEstateType,
                                                       @Param("direction")String direction,
                                                       @Param("minPrice")String minPrice,
                                                       @Param("maxPrice")String maxPrice,
                                                       Pageable pageable);
}
