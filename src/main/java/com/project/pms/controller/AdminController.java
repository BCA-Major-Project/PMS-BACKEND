package com.project.pms.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.pms.services.AdminService;
import com.project.pms.model.Admin;


@RestController
@CrossOrigin
@RequestMapping("/pms/admin")
public class AdminController {
    @Autowired
    AdminService admin_service;

    @GetMapping("/login/{admID}")
    public Admin login(@PathVariable String admID) {
        return admin_service.login(admID);
    }
    
}
