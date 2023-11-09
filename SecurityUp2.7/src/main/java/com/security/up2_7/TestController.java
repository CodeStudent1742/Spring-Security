package com.security.up2_7;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/for-all")
    public String getForAll() {
        return "hello you!";
    }

    @GetMapping("/bye")
    public String getBye() {
        return "papatki!!!!";
    }
    @GetMapping("/for-user")
    public String getFroUser(Principal principal) {
        return "hello " + ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("name");
    }

    @GetMapping("/for-admin")
    public String getForAdmin() {
        return "Hello Admin!";
    }
}