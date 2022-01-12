package com.c0721g2srsrealestatebe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class RealEstateRestController_detailRealEstateNewTaiVD {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoRealEstateNew() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/real-estate-new/{id}", "null"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void getInfoRealEstateNew_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/real-estate-new/{id}", "BD-1001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("BD-1001"))
                .andExpect(jsonPath("$.address").value("Đường 2/9, Phường Hòa Cường Bắc, Hải Châu, Đà Nẵng"))
                .andExpect(jsonPath("$.approval").value("2"))
                .andExpect(jsonPath("$.area").value(100.0))
                .andExpect(jsonPath("$.description").value("Chính chủ cần bán cặp đất mặt tiền đường 2/9, trục đường chính của thành phố Đà Nẵng,\n" +
                        "  Nằm trong cụm khai thác tổ hợp khách sạn, du lịch, văn phòng cho thuê...\n" +
                        "  Đối diện khu thương mại tổ hợp dịch vụ du lịch bậc nhất Đà Nẵng."))
                .andExpect(jsonPath("$.kindOfNews").value(1))
                .andExpect(jsonPath("$.price").value(15000000000.0))
                .andExpect(jsonPath("$.status").value(1))
                .andExpect(jsonPath("$.title").value("BÁN GẤP CẶP ĐẤT ĐƯỜNG 2/9"))
                .andExpect(jsonPath("$.customer.id").value("KH-0002"))
                .andExpect(jsonPath("$.direction.id").value(1))
                .andExpect(jsonPath("$.realEstateType.id").value(1));
    }

}
