package com.visaprocessing.visaprocessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visaprocessing.visaprocessing.entity.Login;
import com.visaprocessing.visaprocessing.repository.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository repo;
  
    public Login login(String username, String password) {
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }

    public Login getRoleByUsername(String username) {
        return repo.findRoleByUsername(username);
    }
}
