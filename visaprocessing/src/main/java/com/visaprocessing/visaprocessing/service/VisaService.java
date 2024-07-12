package com.visaprocessing.visaprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.visaprocessing.visaprocessing.entity.Visa;
import com.visaprocessing.visaprocessing.repository.VisaRepository;



public class VisaService {
	  @Autowired
	    private VisaRepository vrepo;
	  
	  public String visa(String visastatus) {
	   List<Visa> visa = vrepo.findByVisastatus(visastatus);
	      return visastatus;
	  }
	    
}
