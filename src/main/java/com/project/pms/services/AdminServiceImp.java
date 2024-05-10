package com.project.pms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pms.dao.AdminDao;
import com.project.pms.model.Admin;

@Service
public class AdminServiceImp implements AdminService {
    
    @Autowired
    private AdminDao admin_dao;
    @Override
    public Admin login(String admID){
        return admin_dao.findByAdmID(admID);
    }
    
}
