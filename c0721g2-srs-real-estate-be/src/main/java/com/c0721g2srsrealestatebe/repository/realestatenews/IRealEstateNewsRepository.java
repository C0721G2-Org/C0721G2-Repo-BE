package com.c0721g2srsrealestatebe.repository.realestatenews;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRealEstateNewsRepository extends JpaRepository< RealEstateNews, String > {
    // TaiVD get history post - please dont delete my task
    // 5.5.4  List history post
    @Query(value = "  select * \n" +
            "  from real_estate_news\n" +
            "  where customer_id = :customerId ", nativeQuery = true)
    Page< RealEstateNews > findAllNewsByCustomerId(@Param("customerId") String customerId, Pageable pageable);

    // 5.5.4 Search title and customerId
    @Query(value = "    select * \n" +
            "  from real_estate_news\n" +
            "  where customer_id = :customerId and kind_of_news = :kindOfNew \n" +
            "  and title like concat('%',trim(:title),'%') ", nativeQuery = true)
    Page< RealEstateNews > findAllNewsByCustomerIdAndTitleAndType(@Param("customerId") String customerId,
                                                                  @Param("title") String title,
                                                                  @Param("kindOfNew") Integer typeOfNew,
                                                                  Pageable pageable);

    // 5.5.4 List search title
    @Query(value = "    select * \n" +
            "  from real_estate_news\n" +
            "  where customer_id = :customerId \n" +
            "  and title like concat('%',trim(:title),'%') ", nativeQuery = true)
    Page< RealEstateNews > findAllNewsByCustomerIdAndTitle(@Param("customerId") String customerId,
                                                           @Param("title") String title,
                                                           Pageable pageable);

    // 5.5.4 List search kindOfNew
    @Query(value = "    select * \n" +
            "  from real_estate_news\n" +
            "  where customer_id = :customerId and kind_of_news = :kindOfNew ", nativeQuery = true)
    Page< RealEstateNews > findAllNewsByCustomerIdAndType(@Param("customerId") String customerId,
                                                          @Param("kindOfNew") Integer typeOfNew,
                                                          Pageable pageable);

    // 5.6.3 show Real estate new detail
    @Query(value = " select * from real_estate_news where id =:id ", nativeQuery = true)
    Optional<RealEstateNews> findNewsById(@Param("id") String id);

}
