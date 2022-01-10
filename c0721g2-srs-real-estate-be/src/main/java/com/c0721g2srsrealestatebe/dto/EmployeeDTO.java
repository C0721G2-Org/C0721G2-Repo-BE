package com.c0721g2srsrealestatebe.dto;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.employee.Degree;
import com.c0721g2srsrealestatebe.model.employee.Employee;
import com.c0721g2srsrealestatebe.model.employee.Position;
import com.c0721g2srsrealestatebe.model.image.Image;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EmployeeDTO implements Validator {
    private String id;
    @NotBlank(message = "Không được bỏ trống tên")
    @Pattern(regexp = "[A-Z][a-z]*([ ][A-Z][a-z]*)*", message = "Không được nhập số")
    private String name;
    @NotBlank(message = "Không được bỏ trống email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$")
    private String email;

    @Pattern(regexp = "^(09|\\(84\\)\\+9)[01]\\d{7}$")
    @NotBlank(message = "Không được bỏ trống số điện thoại")
    private String phoneNumber;
    @NotBlank(message = "Không được bỏ trống địa chỉ")
    private String address;

    @NotNull(message = "Không được để trống ngày sinh")

    private LocalDate dateOfBirth;
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}")
    @NotBlank(message = "Không được để trống CMND")
    private String idCard;

    private Integer gender;

    private DegreeDTO degree;

    private PositionDTO position;

    private AppUser appUser;

    private Image image;

    private Boolean deleted = Boolean.FALSE;

    public EmployeeDTO() {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public DegreeDTO getDegree() {
        return degree;
    }

    public void setDegree(DegreeDTO degree) {
        this.degree = degree;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
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


    }
}
