package com.javaExample.starterfirst.api;

import java.net.URI;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.javaExample.starterfirst.model.Person;



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
