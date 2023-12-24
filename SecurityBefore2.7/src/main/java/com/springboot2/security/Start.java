package com.springboot2.security;

import com.springboot2.security.entity.AppUser;
import com.springboot2.security.repo.AppUserRepo;
import com.springboot2.security.service.MailSenderService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class Start {

    private PasswordEncoder passwordEncoder;
    private AppUserRepo appUserRepo;

    private MailSenderService mailSenderService;


    public Start(PasswordEncoder passwordEncoder, AppUserRepo appUserRepo, MailSenderService mailSenderService) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepo = appUserRepo;
        this.mailSenderService = mailSenderService;

        this.passwordEncoder = passwordEncoder;
        this.appUserRepo = appUserRepo;

        AppUser appUser = new AppUser();
        appUser.setUsername("Przemek");
        appUser.setEnabled(true);
        appUser.setPassword(passwordEncoder.encode("Przemek123"));
        appUserRepo.save(appUser);

    }
}
