package com.c0721g2srsrealestatebe.dto;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.model.image.Image;
import com.c0721g2srsrealestatebe.model.realestatenews.RealEstateNews;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CustomerDTO implements Validator {


    private String id;


    @NotBlank(message = "không được bỏ trống")
    private String name;

    @Email(message = "email chưa đúng định dạng")
    @NotBlank(message = "không được bỏ trống")
    private String email;

//    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
//            message = "Email phải đúng định dạng.")

    @NotBlank(message = "không được bỏ trống")
    private String phoneNumber;

    @NotBlank(message = "không được bỏ trống")
    private String address;

    @NotBlank(message = "không được bỏ trống")
    private String idCard;

    @NotBlank(message = "không được bỏ trống")
    private String dateOfBirth;

    private Integer gender;

    private AppUser appUser;

    private Image image;

    private List<RealEstateNews> realEstateNewsList;

    private Boolean deleted;

    public CustomerDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<RealEstateNews> getRealEstateNewsList() {
        return realEstateNewsList;
    }

    public void setRealEstateNewsList(List<RealEstateNews> realEstateNewsList) {
        this.realEstateNewsList = realEstateNewsList;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customer = (CustomerDTO) target;
        try {
            LocalDate date = LocalDate.parse(customer.dateOfBirth);
            LocalDate today = LocalDate.now();
            if(Period.between(date,today).getYears()<18){
                errors.rejectValue("dateOfBirth","dateOfBirth");
            }
        }
        catch (Exception e){
            errors.rejectValue("dateOfBirth","dateOfBirth.empty");
        }
    }
}
