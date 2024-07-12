package com.visaprocessing.visaprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visaprocessing.visaprocessing.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByUsernameAndPassword(String username, String password);
    
    Login findRoleByUsername(String username);
}
