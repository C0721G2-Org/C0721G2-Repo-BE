package com.c0721g2srsrealestatebe.repository.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IRealEstateNewsRepository extends JpaRepository<RealEstateNews, String> {
    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    @Query(value = "    select * \n" +
            "  from real_estate_news\n" +
            "  where customer_id like concat('%',:customerId,'%') and kind_of_news like concat('%',:kindOfNew,'%')" +
            "  and title like concat('%',trim(:title),'%') and approval =2 ", nativeQuery = true)
    Page< RealEstateNews > findAllNewsBySearchField(@Param("customerId") String customerId,
                                                                  @Param("title") String title,
                                                                  @Param("kindOfNew") String typeOfNew,
                                                                  @Param("realNewType") String realNewType,
                                                                  Pageable pageable);

    // 5.6.3 show Real estate new detail
    @Query(value = " select * from real_estate_news where id =:id ", nativeQuery = true)
    Optional<RealEstateNews> findNewsById(@Param("id") String id);

    // 5.6.2 add Real estate new detail
    @Query(value = "SELECT MAX(id) FROM real_estate_news;", nativeQuery = true)
    String lastId();

    @Modifying
    @Transactional
    @Query(value = "insert into real_estate_news (address,approval,area,`description`,kind_of_news,price,`status`,title,customer_id,direction_id,real_estate_type_id) " +
            " values (:address,:approval,:area,:description,:kind_of_news,:price,:status,:title,:customer_id,:direction_id,:real_estate_type_id)", nativeQuery = true)
    Integer saveNews(@Param("address") String address, @Param("approval") Integer approval,
                     @Param("area") Double area, @Param("description") String description, @Param("kind_of_news") Integer kind_of_news,
                     @Param("price") Double price, @Param("status") Integer status, @Param("title") String title, @Param("customer_id") String customer_id,
                     @Param("direction_id") Long direction_id, @Param("real_estate_type_id") Long real_estate_type_id);

    Optional<RealEstateNews> findById(String id);
}