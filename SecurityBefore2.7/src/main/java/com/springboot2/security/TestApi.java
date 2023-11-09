package com.springboot2.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestApi {

    @GetMapping("/forAll")
    public String forAll() {
        return "You has been logout";
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal) {
        return "Hello user: " + principal.getName();
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal) {
        return "Hello admin: " + principal.getName();
    }

}
