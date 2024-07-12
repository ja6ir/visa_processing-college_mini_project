package com.visaprocessing.visaprocessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visaprocessing.visaprocessing.entity.Registration;
import com.visaprocessing.visaprocessing.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository saveuser;
	
	public void saveuser(Registration user)
	{
     saveuser.save(user);

}
}