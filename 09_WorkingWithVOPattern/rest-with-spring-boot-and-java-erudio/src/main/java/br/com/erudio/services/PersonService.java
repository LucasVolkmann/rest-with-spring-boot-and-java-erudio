package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service 
public class PersonService {
	
	Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all persons...");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
	}

	public PersonVO findById(Long id) {	
		logger.info("Finding one person...");
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO personVO) {		
		logger.info("Creating one person...");
		var entity = repository.save(
				DozerMapper.parseObject(personVO, Person.class));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO personVO) {
		logger.info("Updating one person...");
		
		var entity = repository.findById(personVO.getId())
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());

		return DozerMapper.parseObject(repository.save(entity), PersonVO.class) ;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person...");

		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
		
}
