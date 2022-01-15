package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.dto.RealEstateDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.CusDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.DirectionDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.ImageDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.RealEstateTypeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class RealEstateRestController_createRealEstate {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createRealEstate() throws Exception {
//        RealEstateDTO realEstateDTO = new RealEstateDTO();
//        realEstateDTO.setAddress("Address");
//        realEstateDTO.setApproval(1);
//        realEstateDTO.setArea(10000.0);
//        realEstateDTO.setDescription("description");
//        realEstateDTO.setKindOfNews(1);
//        realEstateDTO.setPrice(120000000.0);
//        realEstateDTO.setTitle("title");
//        realEstateDTO.setStatus(1);
//        DirectionDTO directionDTO = new DirectionDTO((long) 1);
//        RealEstateTypeDTO realEstateTypeDTO = new RealEstateTypeDTO((long) 2);
//        CusDTO cusDTO = new CusDTO("KH-0001");
//        realEstateDTO.setDirection(directionDTO);
//        realEstateDTO.setRealEstateType(realEstateTypeDTO);
//        realEstateDTO.setCustomer(cusDTO);
//        ImageDTO imageDTO1 = new ImageDTO("img1");
//        ImageDTO imageDTO2 = new ImageDTO("img2");
//        ImageDTO imageDTO3 = new ImageDTO("img3");
//        List<ImageDTO> imageDTOList = new ArrayList<>();
//        imageDTOList.add(imageDTO1);
//        imageDTOList.add(imageDTO2);
//        imageDTOList.add(imageDTO3);
//        realEstateDTO.setImageList(imageDTOList);
//
//        this.mockMvc.perform((MockMvcRequestBuilders
//                .post("/real-estate-new/post"))
//                .content(this.objectMapper.writeValueAsString(realEstateDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//        )
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//        ;
//    }
//
//    @Test
//    public void createRealEstate1() throws Exception {
//        RealEstateDTO realEstateDTO = new RealEstateDTO();
//        realEstateDTO.setAddress(null);
//        realEstateDTO.setApproval(1);
//        realEstateDTO.setArea(10000.0);
//        realEstateDTO.setDescription("description");
//        realEstateDTO.setKindOfNews(1);
//        realEstateDTO.setPrice(120000000.0);
//        realEstateDTO.setTitle("title");
//        realEstateDTO.setStatus(1);
//        DirectionDTO directionDTO = new DirectionDTO((long) 1);
//        RealEstateTypeDTO realEstateTypeDTO = new RealEstateTypeDTO((long) 2);
//        CusDTO cusDTO = new CusDTO("KH-0001");
//        realEstateDTO.setDirection(directionDTO);
//        realEstateDTO.setRealEstateType(realEstateTypeDTO);
//        realEstateDTO.setCustomer(cusDTO);
//        ImageDTO imageDTO1 = new ImageDTO("img1");
//        ImageDTO imageDTO2 = new ImageDTO("img2");
//        ImageDTO imageDTO3 = new ImageDTO("img3");
//        List<ImageDTO> imageDTOList = new ArrayList<>();
//        imageDTOList.add(imageDTO1);
//        imageDTOList.add(imageDTO2);
//        imageDTOList.add(imageDTO3);
//        realEstateDTO.setImageList(imageDTOList);
//
//        this.mockMvc.perform((MockMvcRequestBuilders
//                .post("/real-estate-new/post"))
//                .content(this.objectMapper.writeValueAsString(realEstateDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//        )
//                .andDo(print())
//                .andExpect(status().is4xxClientError())
//        ;
//    }
//
//    @Test
//    public void createRealEstate2() throws Exception {
//        RealEstateDTO realEstateDTO = new RealEstateDTO();
//        realEstateDTO.setAddress("address");
//        realEstateDTO.setApproval(1);
//        realEstateDTO.setArea(null);
//        realEstateDTO.setDescription("description");
//        realEstateDTO.setKindOfNews(1);
//        realEstateDTO.setPrice(120000000.0);
//        realEstateDTO.setTitle("title");
//        realEstateDTO.setStatus(1);
//        DirectionDTO directionDTO = new DirectionDTO((long) 1);
//        RealEstateTypeDTO realEstateTypeDTO = new RealEstateTypeDTO((long) 2);
//        CusDTO cusDTO = new CusDTO("KH-0001");
//        realEstateDTO.setDirection(directionDTO);
//        realEstateDTO.setRealEstateType(realEstateTypeDTO);
//        realEstateDTO.setCustomer(cusDTO);
//        ImageDTO imageDTO1 = new ImageDTO("img1");
//        ImageDTO imageDTO2 = new ImageDTO("img2");
//        ImageDTO imageDTO3 = new ImageDTO("img3");
//        List<ImageDTO> imageDTOList = new ArrayList<>();
//        imageDTOList.add(imageDTO1);
//        imageDTOList.add(imageDTO2);
//        imageDTOList.add(imageDTO3);
//        realEstateDTO.setImageList(imageDTOList);
//
//        this.mockMvc.perform((MockMvcRequestBuilders
//                .post("/real-estate-new/post"))
//                .content(this.objectMapper.writeValueAsString(realEstateDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//        )
//                .andDo(print())
//                .andExpect(status().is4xxClientError())
//        ;
//    }
}
