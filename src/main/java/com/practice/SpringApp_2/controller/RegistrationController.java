package com.practice.SpringApp_2.controller;


import com.practice.SpringApp_2.domain.Role;
import com.practice.SpringApp_2.domain.User;
import com.practice.SpringApp_2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public  String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public  String addUser(User user, Map<String, Object> model){
        User userFromDb  = userRepo.findByUsername(user.getUsername());
        if(userFromDb!= null){
            model.put("message", "Пользователь с таким именем уже существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}






