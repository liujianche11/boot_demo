package com.ljc.spring.boot.demo.controller;

import com.ljc.spring.boot.demo.entity.User;
import com.ljc.spring.boot.demo.exception.GlobalException;
import com.ljc.spring.boot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id, ModelMap model){
        model.put("user",userService.getUser(id));
        return "user_info";
    }

    @PostMapping("/user/add")
    @ResponseBody
    public String addUser(String name,int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.addUser(user);
        return "ok";
    }

    @PostMapping("/user/add2")
    @ResponseBody
    public String addTow(){
        userService.addUserTwo();
        return "ok";
    }

    @PostMapping("/user/addUser")
    @ResponseBody
    public String addUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new GlobalException("1", bindingResult.getFieldError().getDefaultMessage());
        }

        userService.addUser(user);
        return "ok";
    }
}
