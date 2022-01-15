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

    // 5.7.1 Xem danh sách nhu cầu - Câu Query hiển thị List DoanhNV
    @Query(value = "select * from real_estate_news ", nativeQuery = true)
    Page<RealEstateNews> findAllByRealEstateNews(Pageable pageable);

    // 5.7.1 Xem danh sách nhu cầu - Câu Query tìm kiếm DoanhNV
    @Query(value = "select * \n" +
            "from real_estate_news \n" +
            "where kind_of_news like :kind_of_news " +
            " and direction_id like :direction_id " +
            " and real_estate_type_id like :real_estate_type_id "
            , nativeQuery = true )
    Page<RealEstateNews> searchRealEstateNewsByKindOfNewsAndRealEstateTypeAndDirection(Pageable pageable,@Param("kind_of_news") String kindOfNews,
                                                                                       @Param("direction_id") String directionId,
                                                                                       @Param("real_estate_type_id") String realEstateTypeId);
}
