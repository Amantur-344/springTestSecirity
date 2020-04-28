package com.example24.demo.controller;

import com.example24.demo.entity.Check;
import com.example24.demo.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-v2")
public class CheckController {
    @Autowired
    private CheckService checkService;
    @GetMapping("/check-user")
    public Check getStringUser(Long id){
        return checkService.getString((long) 1);
    }

    @GetMapping("/check-moderator")
    public Check getStringModerator(){
        return checkService.getString((long)2);
    }

    @GetMapping("/check-admin")
    public Check getStringAdmin(){
        return checkService.getString((long)2);
    }
    @PostMapping
    public Check create (Check check){
        return checkService.create(check);
    }
}
