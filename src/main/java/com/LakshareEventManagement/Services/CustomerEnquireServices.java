package com.LakshareEventManagement.Services;


import java.util.List;

import com.LakshareEventManagement.Model.CustomerEnquireList;

public interface CustomerEnquireServices {
	 public void saveEnquireList(CustomerEnquireList contactEnq);
	 public List<CustomerEnquireList> getAllList();
	
	public void deleteEnquire(long id);
}
