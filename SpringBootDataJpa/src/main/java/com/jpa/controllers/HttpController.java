package com.jpa.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	
	@RequestMapping(path = "gethtml")
	public String getHttpPage() {
		return "<html>" +
				"<body>" + 
				"<h1>Welcome to Http Application</h1>" + 
				"</body>" + 
				"</html>";
	}
}
