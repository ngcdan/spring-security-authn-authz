package com.linuss.security.demo.springsecurityauthnauthn.controller;

import com.linuss.security.demo.springsecurityauthnauthn.entities.Authorities;
import com.linuss.security.demo.springsecurityauthnauthn.entities.User;
import com.linuss.security.demo.springsecurityauthnauthn.request.UserRegisterRequest;
import com.linuss.security.demo.springsecurityauthnauthn.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  UserServices userServices;
  
  @Autowired
  PasswordEncoder passwordEncoder;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/profile")
  public String userProfile() {
    return "profile";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/403")
  public String errorPage() {
    return "PageNotFound";
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }

  @GetMapping("/register")
  public String registry(Model model) {
   model.addAttribute("user", new UserRegisterRequest());
    return "register";
  }

  @PostMapping("/register")
  public String register(@Valid @ModelAttribute("user") UserRegisterRequest userReq, BindingResult result) {
    if(result.hasErrors()) {
      return "register";
    }
    User user = new User(userReq.getUsername(),
      passwordEncoder.encode(userReq.getPassword()),
      userReq.getEmail(), true);
    user.withRole(new Authorities().withUsername(userReq.getUsername()).withAuthority("ROLE_User"));

    userServices.saveUser(user);
    return "redirect:register?success";
  }
}