package com.javaExample.starterfirst.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.javaExample.starterfirst.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
	
	private static List<Person> DB = new ArrayList<>();
	@Override
	public int insertPerson(UUID id, Person person) {
				DB.add(new Person(id, person.getName()));
				return 1;
	}
	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMaybeOptional = selectPersonById(id);
		if (personMaybeOptional.isEmpty()) {
			return 0;
		}
		DB.remove(personMaybeOptional.get());
		return 1;
	}
	
	@Override
	public int updatePersonById(UUID id, Person person) {
		return selectPersonById(id)
				.map(Person ->{
					int indexOfPersonToUpdate = DB.indexOf(person);
					if (indexOfPersonToUpdate >= 0) {
						DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
		}
	
	
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(Person -> Person.getId().equals(id))
				.findFirst();
	}
	
}
