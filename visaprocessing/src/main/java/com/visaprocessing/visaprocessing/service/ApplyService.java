package com.visaprocessing.visaprocessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visaprocessing.visaprocessing.entity.Apply;
import com.visaprocessing.visaprocessing.repository.ApplyRepository;

import jakarta.transaction.Transactional;
@Service
public class ApplyService {
	@Autowired
	private ApplyRepository applyrepo;
	
	public void applyvisa(Apply v)
	{
     applyrepo.save(v);

}

	 @Autowired
	    private ApplyRepository applyRepository;

	    @Transactional
	    public void setVisaStatusForUser(String username, String newVisaStatus) {
	        Apply user = applyRepository.findByUsername(username);

	        if (user != null) {
	            user.setVisastatus(newVisaStatus);
	            applyRepository.save(user);
	        }
	        else
	        {
	        	System.out.println("user ");
	        }
	        
	    }
}