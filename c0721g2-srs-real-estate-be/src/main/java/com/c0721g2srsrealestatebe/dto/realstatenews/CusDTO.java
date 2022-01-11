package com.c0721g2srsrealestatebe.dto.realstatenews;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.image.Image;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class CusDTO {
    @Pattern(regexp = "KH-\\d{4}",message = "wrong format")
    private String id;

    public CusDTO() {
    }

    public CusDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CusDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
