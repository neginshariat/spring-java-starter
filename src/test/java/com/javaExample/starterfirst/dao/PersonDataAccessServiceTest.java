package com.javaExample.starterfirst.dao;

import com.javaExample.starterfirst.model.Person;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)

class PersonDataAccessServiceTest {

	@Mock
	private PersonDao personDao;
	
	@InjectMocks
	private PersonDataAccessService personDataAccessService;

	private UuidSource uuidSource = UuidSource.random();
	//MockedStatic<UUID> mocked = mockStatic(UUID.class);
	private UUID getUuid() {
		return uuidSource.newUuid();
	}

	private UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void insertPersonTest() {
		Person person = new Person(defaultUuid,"Test1");



			int result = personDataAccessService.insertPerson(null, person);

			assertEquals("8d8b30e3-de52-4f1c-a71c-9905a8043dac", person);


		/*when(personDataAccessService.insertPerson(person)).equals(person);
		int result =personDataAccessService.insertPerson( person);
		assertEquals(1,result);*/

	}
	
	@Test
	public void selectAllPeopleTest() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person(defaultUuid,"Test-1"));
		personList.add(new Person(defaultUuid,"Test-2"));
		personList.add(new Person(defaultUuid,"Test-3"));

		List<Person> result = personDataAccessService.selectAllPeople();
		assertEquals(3, result.size());
	}
	
	@Test
	public void selectPersonByIdTest() {
		Person person = new Person(getUuid(),"Test");
		when(personDao.selectPersonById(getUuid())).thenReturn(Optional.of(person));
		Optional<Person> personResult = personDataAccessService.selectPersonById(getUuid());
		assertEquals(getUuid(), person);
	}
	

	@Test
	public void deletePersonByIdTest() {
		Person person = new Person(getUuid(),"Test");
		when(personDao.deletePersonById(getUuid()));
		verify(personDataAccessService, times(1)).deletePersonById(getUuid());
	}
}
