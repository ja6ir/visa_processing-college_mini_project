package com.visaprocessing.visaprocessing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visaprocessing.visaprocessing.entity.Apply;

@Repository
public interface ApplyRepository extends JpaRepository<Apply,String>{

	Apply findByUsername(String username);

	List<Apply> findByVisastatus(String visastatus);
	

	}
	

   