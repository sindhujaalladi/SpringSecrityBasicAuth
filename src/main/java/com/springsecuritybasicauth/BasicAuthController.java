package com.springsecuritybasicauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/secuirty/")
public class BasicAuthController {
	
	
	
	@GetMapping("/createsecurity")
	public String createBasiSecurity() {
		return "Hai !!!!welcome to spring security basicAuth implementation";
		
	}

}
