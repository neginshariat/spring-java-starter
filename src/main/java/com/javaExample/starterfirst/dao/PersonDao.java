package com.javaExample.starterfirst.dao;

import java.util.UUID;
import com.javaExample.starterfirst.model.Person;

public interface PersonDao {
	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id , person);
	}
	
}
