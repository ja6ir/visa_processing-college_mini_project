package com.visaprocessing.visaprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visaprocessing.visaprocessing.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,String>{

	Registration findByUsername(String username);

}
