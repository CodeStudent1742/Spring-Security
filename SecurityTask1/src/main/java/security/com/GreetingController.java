package security.com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GreetingController {

    @GetMapping("/admin-greeting")
    public String adminGreeting(Principal principal) {
        return "Cześć admin " + principal.getName();
    }

    @GetMapping("/user-greeting")
    public String userGreeting(Principal principal) {
        if (principal != null) {
            return "Cześć user " + principal.getName();
        }
        return "Cześć nieznajomy";
    }

    @GetMapping("/anonymous-greeting")
    public String anonymousGreeting(Principal principal) {
        if (principal != null) {
            return "Cześć " + principal.getName();
        }
        return "Cześć nieznajomy";
    }

    @GetMapping("/bye")
    public String goodbye() {
        return "Papa";
    }
}
