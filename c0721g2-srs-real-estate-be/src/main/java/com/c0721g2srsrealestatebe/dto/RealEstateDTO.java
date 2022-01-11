package com.c0721g2srsrealestatebe.dto;

import com.c0721g2srsrealestatebe.dto.realstatenews.CusDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.DirectionDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.ImageDTO;
import com.c0721g2srsrealestatebe.dto.realstatenews.RealEstateTypeDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.model.image.Image;
import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateType;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class RealEstateDTO {
    @Pattern(regexp = "", message = "")
    private String id;
    @NotBlank(message = "")
    private String title;
    private String description;
    @NotBlank(message = "")
    private String address;
    @Min(value = 0,message = "")
    private Double area;
    @Min(value = 0,message = "")
    private Double price;
    private Integer approval;
    @Min(value = 0,message = "")
    @Max(value = 4,message = "")
    private Integer kindOfNews;
    @Min(value = 0,message = "")
    @Max(value = 2,message = "")
    private Integer status;
    private RealEstateTypeDTO realEstateType;
    private DirectionDTO direction;
    private CusDTO customer;
    private List<ImageDTO> imageList;

    public RealEstateDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
    }

    public Integer getKindOfNews() {
        return kindOfNews;
    }

    public void setKindOfNews(Integer kindOfNews) {
        this.kindOfNews = kindOfNews;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RealEstateTypeDTO getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateTypeDTO realEstateType) {
        this.realEstateType = realEstateType;
    }

    public DirectionDTO getDirection() {
        return direction;
    }

    public void setDirection(DirectionDTO direction) {
        this.direction = direction;
    }

    public CusDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CusDTO customer) {
        this.customer = customer;
    }

    public List<ImageDTO> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageDTO> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "RealEstateDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", approval=" + approval +
                ", kindOfNews=" + kindOfNews +
                ", status=" + status +
                ", realEstateType=" + realEstateType +
                ", direction=" + direction +
                ", customer=" + customer +
                ", imageList=" + imageList +
                '}';
    }
}
