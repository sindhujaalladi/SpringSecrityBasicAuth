package com.springsecuritybasicauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class NoAuthController {
	

	@RestController
	@RequestMapping("/noauth/security")
	public class BasicAuthController {
		
		
		
		@GetMapping("/createwithoutsecurity")
		public String createBasiSecurity() {
			return "Hai !!!!welcome to spring security NoAuth implementation";
			
		}

	}


}
