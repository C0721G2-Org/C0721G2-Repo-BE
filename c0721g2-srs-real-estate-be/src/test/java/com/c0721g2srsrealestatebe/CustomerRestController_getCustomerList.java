package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.controller.CustomerController;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CustomerRestController_getCustomerList {

    @Autowired
    private CustomerController customerController;

    //ThienLB - Danh sach KH
//    Trường hợp Trả về list có size > 0
//    Trường hợp đúng
    @Test
    public void getCustomerList_1() {

        ResponseEntity<Page<Customer>> responseEntity
                = this.customerController.showCustomer(PageRequest.of(0, 2));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

//  Không có dữ liệu
    @Test
    public void getCustomerList_2() {

        ResponseEntity<Page<Customer>> responseEntity
                = this.customerController.showCustomer(PageRequest.of(0, 10));

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }


//   Người cuối cùng trong list có size bằng 10, có tên là "Lê Quốc Tùng"
    @Test
    public void getListStudent_2() {
        ResponseEntity<Page<Customer>> responseEntity
                = this.customerController.showCustomer(PageRequest.of(0, 10));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Lê Quốc Tùng",
                responseEntity.getBody().getContent().get(9).getName());
    }

}
