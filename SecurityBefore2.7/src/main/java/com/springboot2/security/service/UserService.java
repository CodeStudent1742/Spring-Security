package com.springboot2.security.service;

import com.springboot2.security.entity.AppUser;
import com.springboot2.security.entity.VerificationToken;
import com.springboot2.security.repo.AppUserRepo;
import com.springboot2.security.repo.VerificationTokenRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class UserService {

    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;
    private VerificationTokenRepo verificationTokenRepo;
    private MailSenderService mailSenderService;

    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder, VerificationTokenRepo verificationTokenRepo, MailSenderService mailSenderService) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenRepo = verificationTokenRepo;
        this.mailSenderService = mailSenderService;
    }

    public void addNewUser(AppUser user, HttpServletRequest request) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        appUserRepo.save(user);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepo.save(verificationToken);

        String url = "http://" + request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath() +
                "/verify-token?token="+token;

        try {
            mailSenderService.sendMail(user.getUsername(), "Verification Token", url, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyToken(String token) {
        AppUser appUser = verificationTokenRepo.findByValue(token).getAppUser();
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
    }
}
