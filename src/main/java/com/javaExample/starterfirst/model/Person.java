package com.javaExample.starterfirst.model;

import java.util.UUID;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	@NonNull
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
	public void setId(UUID id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	

}
