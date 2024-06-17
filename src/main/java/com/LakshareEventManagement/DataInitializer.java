package com.LakshareEventManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.LakshareEventManagement.Model.Admin;
import com.LakshareEventManagement.Repository.AdminRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
	@Autowired
	private AdminRepository adminRepo;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(adminRepo.count() == 0) {
			
			Admin admin1 = new Admin();
			admin1.setUsername("AdiIngole");
			admin1.setPassword("Adi@1006");
			admin1.setEmail("adiingole1006@gmail.com");
			adminRepo.save(admin1);
			
			Admin admin2 = new Admin();
			admin2.setUsername("Adinath");
			admin2.setPassword("Adi@1432");
			admin2.setEmail("adiingole1432@gmail.com");
			adminRepo.save(admin2);
            
		}
		
	}

}
