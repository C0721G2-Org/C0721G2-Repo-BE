package com.c0721g2srsrealestatebe.dto;

import com.c0721g2srsrealestatebe.customid.CustomIdGenerator;
import com.c0721g2srsrealestatebe.model.account.Role;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Age
public class CustomerDTO implements Validator {


    private String id;
    @NotBlank(message = "you have to input your name")
    @Size(min = 2, message = "Tên ít nhất phải 2 ký tự")
    @Pattern(regexp = "^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼ" +
            "ÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợở" +
            "ỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$",
            message = "Không được chứa ký tự đặc biệt")
    private String name;


    //    @NotBlank(message = "you have to input your birthday")
//    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
//            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;



    @NotBlank(message = "Số CMND không được để trống.")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Số CMND phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private String idCard;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Số điện thoại phải đúng định dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email phải đúng định dạng.")
    private String email;

    @NotNull
    private Integer gender;

    private AppUserDTO appUserDTO;

    private ImageDTO image;

    private Long role;

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public AppUserDTO getAppUserDTO() {
        return appUserDTO;
    }

    public void setAppUserDTO(AppUserDTO appUserDTO) {
        this.appUserDTO = appUserDTO;
    }

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }

    private Boolean deleted = Boolean.FALSE;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //    public int getAge() {
//        return Age;
//    }
//
//    public void setAge(int age) {
//        Age = age;
//    }
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    private boolean checkIdCard;
    private boolean checkPhone;




    public boolean isCheckIdCard() {
        return checkIdCard;
    }

    public void setCheckIdCard(boolean checkIdCard) {
        this.checkIdCard = checkIdCard;
    }

    public boolean isCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(boolean checkPhone) {
        this.checkPhone = checkPhone;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", appUser=" + appUserDTO +
                ", image=" + image +
                ", deleted=" + deleted +
                ", checkIdCard=" + checkIdCard +
                '}';
    }
}