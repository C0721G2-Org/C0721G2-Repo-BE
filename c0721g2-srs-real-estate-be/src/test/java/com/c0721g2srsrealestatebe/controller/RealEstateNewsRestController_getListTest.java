package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest
class RealEstateNewsRestController_getListTest {
    @Autowired
    private RealEstateNewsController realEstateNewsController;

    //Test dữ liệu null(xoá db)
    @Test
    void getListRealEstateNew_5() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("", "", "", "", "", "", 0);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Test dữ liệu đổ về mặc định (dữ liệu realestate: page 0; element 1)
    @Test
    void getListRealEstateNew_6() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("", "", "", "", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(6, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1002",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Nguyễn Hữu Thọ, Thanh Khê, Đà Nẵng",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(1).getArea());
        Assertions.assertEquals("Bán đất nền trung tâm thành phố, " +
                        "Đường rộng, mặt tiền gần sân bay gần trung tâm",
                responseEntity.getBody().getContent().get(1).getDescription());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getKindOfNews());
        Assertions.assertEquals(15000000000.0,
                responseEntity.getBody().getContent().get(1).getPrice());
        Assertions.assertEquals("Bán đất mặt tiền Nguyễn Hữu Thọ",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("KH-0002",
                responseEntity.getBody().getContent().get(1).getCustomer().getId());
        Assertions.assertEquals(4,
                responseEntity.getBody().getContent().get(1).getDirection().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getRealEstateType().getId());
    }

    //Test search địa chỉ(key search: "Đà Nẵng", dữ liệu trả về: page 0; element: 4)
    @Test
    void getListRealEstateNew_6_search_by_address() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("Đà Nẵng", "", "", "", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1005",
                responseEntity.getBody().getContent().get(4).getId());
        Assertions.assertEquals("Đường Bạch Đằng, Phường Hòa Thuận Đông, Hải Châu, Đà Nẵng",
                responseEntity.getBody().getContent().get(4).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(4).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(4).getArea());
        Assertions.assertEquals("Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.\n" +
                        "Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
                responseEntity.getBody().getContent().get(4).getDescription());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(4).getKindOfNews());
        Assertions.assertEquals(8000000000.0,
                responseEntity.getBody().getContent().get(4).getPrice());
        Assertions.assertEquals("CẦN BÁN LÔ ĐẤT MẶT TIỀN ĐƯỜNG BẠCH ĐẰNG",
                responseEntity.getBody().getContent().get(4).getTitle());
        Assertions.assertEquals("KH-0004",
                responseEntity.getBody().getContent().get(4).getCustomer().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(4).getDirection().getId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(4).getRealEstateType().getId());
    }


    //Test search địa chỉ kết hợp kindOfNews
    // (key search: ("Đà Nẵng", filter chọn loại "tin cho thuê"), dữ liệu trả về: page 0; element: 2)
    @Test
    void getListRealEstateNew_6_search_by_address_and_KindOfNews() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("Đà Nẵng", "2", "", "", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1005",
                responseEntity.getBody().getContent().get(2).getId());
        Assertions.assertEquals("Đường Bạch Đằng, Phường Hòa Thuận Đông, Hải Châu, Đà Nẵng",
                responseEntity.getBody().getContent().get(2).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(2).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(2).getArea());
        Assertions.assertEquals("Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.\n" +
                        "Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
                responseEntity.getBody().getContent().get(2).getDescription());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(2).getKindOfNews());
        Assertions.assertEquals(8000000000.0,
                responseEntity.getBody().getContent().get(2).getPrice());
        Assertions.assertEquals("CẦN BÁN LÔ ĐẤT MẶT TIỀN ĐƯỜNG BẠCH ĐẰNG",
                responseEntity.getBody().getContent().get(2).getTitle());
        Assertions.assertEquals("KH-0004",
                responseEntity.getBody().getContent().get(2).getCustomer().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(2).getDirection().getId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(2).getRealEstateType().getId());
    }


    //Test search địa chỉ kết hợp kindOfNews và realEstateType
    // (key search: ("Đà Nẵng", filter chọn loại "tin cho thuê", filter chọn "nhà ở"), dữ liệu trả về: page 0; element: 2)
    @Test
    void getListRealEstateNew_6_search_by_address_and_KindOfNews_and_realEstateType() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("Đà Nẵng", "2", "2","", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1005",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Đường Bạch Đằng, Phường Hòa Thuận Đông, Hải Châu, Đà Nẵng",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(1).getArea());
        Assertions.assertEquals("Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.\n" +
                        "Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
                responseEntity.getBody().getContent().get(1).getDescription());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getKindOfNews());
        Assertions.assertEquals(8000000000.0,
                responseEntity.getBody().getContent().get(1).getPrice());
        Assertions.assertEquals("CẦN BÁN LÔ ĐẤT MẶT TIỀN ĐƯỜNG BẠCH ĐẰNG",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("KH-0004",
                responseEntity.getBody().getContent().get(1).getCustomer().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getDirection().getId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getRealEstateType().getId());
    }

    //Test search kindOfNews
    // (key search: (filter chọn loại "tin cho thuê"), dữ liệu trả về: page 0; element: 3)
    @Test
    void getListRealEstateNew_6_search_by_KindOfNews() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("", "2", "", "", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1010",
                responseEntity.getBody().getContent().get(3).getId());
        Assertions.assertEquals("Quận 2, Thành phố Thủ Đức - Hồ Chí Minh",
                responseEntity.getBody().getContent().get(3).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(3).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(3).getArea());
        Assertions.assertEquals("Nguồn khách có nhu cầu bán đất nhà phố biệt thự ở kinh doanh và đầu tư khu vực quận 2,\n" +
                        "tp Thủ Đức. Các phường Bình An, An Phú An Khánh, Thảo điền. Diện tích 5x20m, 8x20m, 10x20m,\n" +
                        " 20x20m hoặc lớn hơn hoặc đất biệt thự 500 đến 600m2 hoặc nhà mới đẹp...",
                responseEntity.getBody().getContent().get(3).getDescription());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(3).getKindOfNews());
        Assertions.assertEquals(1300000000.0,
                responseEntity.getBody().getContent().get(3).getPrice());
        Assertions.assertEquals("Cần mua đất nhà phố biệt thự quận 2, tp Thủ Đức",
                responseEntity.getBody().getContent().get(3).getTitle());
        Assertions.assertEquals("KH-0009",
                responseEntity.getBody().getContent().get(3).getCustomer().getId());
        Assertions.assertEquals(6,
                responseEntity.getBody().getContent().get(3).getDirection().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(3).getRealEstateType().getId());
    }

    //Test search kết hợp kindOfNews và realEstateType
    // (key search: (filter chọn loại "tin cho thuê", filter chọn "nhà ở"), dữ liệu trả về: page 0; element: 2)
    @Test
    void getListRealEstateNew_6_search_by_KindOfNews_and_realEstateType() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("", "2", "2", "", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1005",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Đường Bạch Đằng, Phường Hòa Thuận Đông, Hải Châu, Đà Nẵng",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(1).getArea());
        Assertions.assertEquals("Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.\n" +
                        "Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
                responseEntity.getBody().getContent().get(1).getDescription());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getKindOfNews());
        Assertions.assertEquals(8000000000.0,
                responseEntity.getBody().getContent().get(1).getPrice());
        Assertions.assertEquals("CẦN BÁN LÔ ĐẤT MẶT TIỀN ĐƯỜNG BẠCH ĐẰNG",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("KH-0004",
                responseEntity.getBody().getContent().get(1).getCustomer().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getDirection().getId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getRealEstateType().getId());
    }

    //Test search realEstateType
    // (key search: (filter chọn "nhà ở"), dữ liệu trả về: page 0; element: 2)
    @Test
    void getListRealEstateNew_6_search_by_realEstateType() {
        ResponseEntity<Page<RealEstateNews>> responseEntity
                = this.realEstateNewsController.getListRealEstateNews("", "", "2", "", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("BD-1005",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Đường Bạch Đằng, Phường Hòa Thuận Đông, Hải Châu, Đà Nẵng",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getApproval());
        Assertions.assertEquals(100,
                responseEntity.getBody().getContent().get(1).getArea());
        Assertions.assertEquals("Chính chủ cần bán gấp căn nhà phố ngay trung tâm Đà Nẵng - Cạnh siêu thị Lotte mart.\n" +
                        "Nhà phố thương mại, đồng bộ mặt ngoài giúp cho dãy phố sang trọng, khác biệt với các khu phố hiện trạng tại Đà Nẵng.",
                responseEntity.getBody().getContent().get(1).getDescription());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getKindOfNews());
        Assertions.assertEquals(8000000000.0,
                responseEntity.getBody().getContent().get(1).getPrice());
        Assertions.assertEquals("CẦN BÁN LÔ ĐẤT MẶT TIỀN ĐƯỜNG BẠCH ĐẰNG",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("KH-0004",
                responseEntity.getBody().getContent().get(1).getCustomer().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getDirection().getId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getRealEstateType().getId());
    }
}
