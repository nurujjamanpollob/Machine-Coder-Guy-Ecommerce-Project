package com.nurujjamanpollob.machinecoderguystore.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// here we are configuring application controller
@Controller
public class MainController {
	
	// get root mapping
	@GetMapping("/")
	public String viewHomePage() {
		
		
		return "index";
	}

}
