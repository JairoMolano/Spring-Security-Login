package co.usco.users_roles.controllers;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home/user")
    public String homeUser(Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getUsername());
        return "usersViews/home";
    }

    @GetMapping("/home/admin")
    public String homeAdmin(Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getUsername());
        return "adminViews/home";
    }

}
