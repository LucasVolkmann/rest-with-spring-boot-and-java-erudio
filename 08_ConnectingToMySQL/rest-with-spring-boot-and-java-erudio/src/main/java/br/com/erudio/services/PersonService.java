package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service // Annotation for Dependency Injection
public class PersonService {
	
	Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding all persons...");
		
		return repository.findAll();
	}

	public Person findById(Long id) {	
		logger.info("Finding one person...");
		
		return repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {		
		logger.info("Creating one person...");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person...");
		
		var entity = this.findById(person.getId());

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person...");
		
		repository.delete(this.findById(id));
	}
		
}
