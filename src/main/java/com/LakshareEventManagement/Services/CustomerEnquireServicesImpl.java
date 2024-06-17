package com.LakshareEventManagement.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LakshareEventManagement.Model.CustomerEnquireList;
import com.LakshareEventManagement.Repository.CustomerEnquireRepository;

@Service
public class CustomerEnquireServicesImpl implements CustomerEnquireServices {
	
	@Autowired
	private CustomerEnquireRepository enqRepo;

	@Override
	public void saveEnquireList(CustomerEnquireList contactEnq) {
		enqRepo.save(contactEnq);
		
	
	}
	@Override
	public List<CustomerEnquireList> getAllList(){
		System.out.println("get List " +enqRepo.findAll());
		return enqRepo.findAll();
	}
	@Override
	public void deleteEnquire(long id) {
		enqRepo.deleteById(id);
		
	}

	

}
