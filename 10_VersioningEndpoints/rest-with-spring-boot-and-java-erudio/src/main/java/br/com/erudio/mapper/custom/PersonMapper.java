package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVOV2(Person entity) {
		
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(entity.getId());
		vo.setFirstName(entity.getFirstName());
		vo.setLastName(entity.getLastName());
		vo.setBirthDay(new Date());
		vo.setAddress(entity.getAddress());
		vo.setGender(entity.getGender());
		
		return vo;
	}
	
	public Person convertVOV2ToEntity(PersonVOV2 vo) {
		
		Person entity = new Person();
		entity.setId(vo.getId());
		entity.setFirstName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
//		entity.setBirthDay(new Date());
		entity.setAddress(vo.getAddress());
		entity.setGender(vo.getGender());
		
		return entity;
	}
	
}
