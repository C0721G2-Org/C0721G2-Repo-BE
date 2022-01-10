package com.c0721g2srsrealestatebe.repository.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRealEstateNewsRepository extends JpaRepository<RealEstateNews, String> {
//    @Query(value = "select * from real_estate_news where real_estate_type_id like :idTypeSearch and direction_id like :directionCusSearch and area like areaSearch" , nativeQuery = true)
//    Page<RealEstateNews> search(Pageable pageable, @Param("idTypeSearch")  String idTypeSearch ,
//                                @Param("directionCusSearch")  String directionCusSearch ,
//                                @Param("areaSearch")  String areaSearch );
}
