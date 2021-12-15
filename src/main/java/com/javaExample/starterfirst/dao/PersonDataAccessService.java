package com.javaExample.starterfirst.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaExample.starterfirst.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
	
	//private final JdbcTemplate jdbcTemplate;
	
	/*
	 * @Autowired public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
	 * this.jdbcTemplate = jdbcTemplate; }
	 */

	@Override
	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return null;
	}

	@Override
	public int deletePersonById(UUID id) {
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return 0;
	}

}
