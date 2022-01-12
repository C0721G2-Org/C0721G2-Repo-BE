package com.c0721g2srsrealestatebe.service.account.impl;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.repository.account.IAppUserRepository;
import com.c0721g2srsrealestatebe.service.account.IAppUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public AppUser getAppUserByEmail(String email) {
        return appUserRepository.getAppUserByEmailCustomer(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return appUserRepository.existsUserByEmail(email) != null;
    }

    @Override
    public void addVerificationCode(String email) throws MessagingException, UnsupportedEncodingException {
        String username = appUserRepository.existsUserByEmail(email);
        String code = RandomString.make(64);
        appUserRepository.addVerificationCode(code, username);
        this.sendVerificationEmailForResetPassWord(username, code, email);
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Chờ xác nhận email");
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            appUserRepository.deleteVerificationCode(username);
            System.out.println("Xóa verification code " + appUserRepository.findUserByVerificationCode(code));
        });

    }

    @Override
    public void saveNewPassword(String passwordEncode, String code) {
        appUserRepository.saveNewPassword(passwordEncode, code);
        appUserRepository.deleteVerificationCode(code);
    }

    @Override
    public Boolean findUserByVerificationCode(String code) {
        return appUserRepository.findUserByVerificationCode(code) != null;
    }

    public void sendVerificationEmailForResetPassWord(String userName, String randomCode, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email xác thực!";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password?code=" + randomCode;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("plthienbkdn@gmail.com", "Bất động sản Hưng Thịnh Group");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để thay đổi mật khẩu của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>-----------------------------------------------------------</p>" +
                "<p>Bất động sản Hưng Thịnh Group</p>" +
                "<p>Địa chỉ: Tòa nhà Hưng Thịnh Group, số 99 đường Lê Duẩn</p>" +
                "<p>Email: plthienbkdn@gmail.com</p>" +
                "<p>Số điện thoại: 0905686868</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);

    }


}