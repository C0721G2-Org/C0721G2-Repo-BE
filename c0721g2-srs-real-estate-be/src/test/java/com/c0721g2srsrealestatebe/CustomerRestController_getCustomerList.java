//package com.c0721g2srsrealestatebe;
//
//import com.c0721g2srsrealestatebe.controller.CustomerController;
//import com.c0721g2srsrealestatebe.model.customer.Customer;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerRestController_getCustomerList {
//
//    @Autowired
//    private CustomerController customerController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    //ThienLB - Danh sach KH case 5 => case 6
//    //  Trường hợp Trả về list có size > 0
//    //  Trường hợp đúng
//    @Test
//    public void getCustomerList_1() {
//
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.showCustomer(PageRequest.of(0, 2));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//    }
//
//    //  Không có dữ liệu
//    @Test
//    public void getCustomerList_2() {
//
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.showCustomer(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//
//    //   Người cuối cùng trong list có size bằng 10, có tên là "Lê Quốc Tùng"
//    @Test
//    public void getListStudent_2() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.showCustomer(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Lê Quốc Tùng",
//                responseEntity.getBody().getContent().get(9).getName());
//    }
//
//    //  Test chức năng search case 1 => 4, get có tham số.
//    // Tham số search = "" => thì hiển thị ra list
//    @Test
//    public void getInfoCustomer_1() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/customers/customer-list", ""))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    //   Test chức năng search, tìm kiếm gần đúng case 1 => name="vo", phone="0907123", email="ngocnhat@gmail.com"
//    //    Link trả về thành công
//    @Test
//    public void getInfoCustomer_2() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/customers/customer-list?", "name=Võ Ngọc Nhật&phone=0907123123&email=ngocnhat@gmail.com"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    //  Test chức năng search, tìm kiếm gần đúng case 1 => Với 3 tham số đầu vào name="ngoc", phone="0907123123", email="nhat@gmail.com"
//    //Link trả về thành công, và mapping với expect mong muốn name = "Võ Ngọc Nhật" và email = "ngocnhat@gmail.com"
//    @Test
//    public void getSearchCustomer_3() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.
//                findCustomerByPhoneAndNameAndEmail(0, "ngoc","0907123123","nhat@gmail.com");
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Võ Ngọc Nhật",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("ngocnhat@gmail.com",
//                responseEntity.getBody().getContent().get(0).getEmail());
//    }
//
//    //  Test chức năng search, tìm kiếm gần đúng case 1 => Với 2 tham số đầu vào name="ngoc", phone="0907123123"
//    //Link trả về thành công, và mapping với expect mong muốn name = "Võ Ngọc Nhật" và email = "ngocnhat@gmail.com"
//
//    @Test
//    public void getSearchCustomer_4() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.
//                findCustomerByPhoneAndNameAndEmail(0, "ngoc","0907123123","");
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Võ Ngọc Nhật",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("ngocnhat@gmail.com",
//                responseEntity.getBody().getContent().get(0).getEmail());
//    }
//
//    //  Test chức năng search, tìm kiếm gần đúng case 1 => Với 1 tham số đầu vào name="ngoc"
//    //Link trả về thành công, và mapping với expect mong muốn name = "Võ Ngọc Nhật" và email = "ngocnhat@gmail.com"
//
//    @Test
//    public void getSearchCustomer_5() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.
//                findCustomerByPhoneAndNameAndEmail(0, "ngoc","0907123123","");
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Võ Ngọc Nhật",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("ngocnhat@gmail.com",
//                responseEntity.getBody().getContent().get(0).getEmail());
//    }
//
//    //  Test chức năng search, tìm kiếm gần đúng case 1 => Với tham số đầu null ở ba trường, đầu ra (no_content 204 error)
//    @Test
//    public void getSearchCustomer_6() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.
//                findCustomerByPhoneAndNameAndEmail(0, "null","null","null");
//
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//
//    }
//
//
//}
