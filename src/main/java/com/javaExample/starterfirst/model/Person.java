package com.javaExample.starterfirst.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private UUID id;
	
	/*
	 * public void setId(UUID id) { this.id = id; } public void setName(String name)
	 * { this.name = name; }
	 */
	private	String name;
	
	public Person(@JsonProperty("id") UUID id,
				  @JsonProperty("name") String name) {
		this.id =id;
		this.name = name;
	}
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	

}
