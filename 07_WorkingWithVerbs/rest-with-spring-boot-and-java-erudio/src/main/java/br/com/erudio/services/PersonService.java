package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service // Annotation for Dependency Injection
public class PersonService {
	
	AtomicLong counter = new AtomicLong();
	
	Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll() {
		
		List<Person> people = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			people.add(person);
		}
		
		return people;
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person " + i);
		person.setLastName("Someone's last name" + i);
		person.setAddress("Some address in Brazil" + i);
		person.setGender("Male" + i);
		
		return person;
	}

	public Person findById(String id) {
		
		logger.info("Finding one person...");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Lucas");
		person.setLastName("Eduardo");
		person.setAddress("Blumenau - SC");
		person.setGender("Male");
		
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person...");
		person.setFirstName("Person name created");
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person...");
		person.setFirstName("Person name updated");
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("Deleting one person...");
	
	}
		
}
