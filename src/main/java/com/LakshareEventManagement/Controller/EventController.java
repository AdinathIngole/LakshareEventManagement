package com.LakshareEventManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

    @RequestMapping("/")
	public String HomePage() {
		
		return "index";
	}
	@RequestMapping("/contact")
	public String COntactPage() {
		
		return "ContactUs";
	}
	
    
}
