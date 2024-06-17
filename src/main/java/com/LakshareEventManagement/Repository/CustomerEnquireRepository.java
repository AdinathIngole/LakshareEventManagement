package com.LakshareEventManagement.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LakshareEventManagement.Model.CustomerEnquireList;

@Repository
public interface CustomerEnquireRepository extends JpaRepository<CustomerEnquireList , Long> {
	
}
