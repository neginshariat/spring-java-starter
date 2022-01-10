package com.javaExample.starterfirst.api;


import org.apache.tomcat.util.json.JSONParser;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;






@RestController
public class RedirectController {
	
	@GetMapping(value = "/redirect")
	public ModelAndView getAll(){
		String externalUrl = "http://127.0.0.1:4000/persons";
		return new ModelAndView("redirect:"+ externalUrl);
	}
	
	
	
	  @GetMapping(value = "/redirect/{id}") public String
	  getById(@RequestParam("id") String name){ 
		  String externalUrl =
	  "http://127.0.0.1:4000/persons"; 
	  JSONParser jsonParser = new
	  JSONParser(externalUrl); 
	  String resultString = jsonParser.toString(); return
	  resultString; }
	 
	 
}
