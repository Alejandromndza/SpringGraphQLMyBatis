package com.alejandro.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.myapp.dao.PersonaMapper;
import com.alejandro.myapp.entity.Aficiones;
import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.entity.Persona;

@Service
public class PersonaService {
	
	@Autowired 
	PersonaMapper mapper;
	
	public Marca getMarca(int id) {
		
		return mapper.getMarca(id);
	}
	
	public List<Persona> getAll(){
		
		return mapper.getAll();
	}
	
	public Persona getPersona(int id) {
		
		return mapper.getPersona(id);
	}
	
	public Persona getPersonaString(String nombre) {
		
		return mapper.getPersonaString(nombre);
	}
	
	public Persona insertPersona(Persona persona) {
		
		mapper.insert(persona);
		return persona;
	
	}
	
	public List<Aficiones> getAficiones(int id){
		
		return mapper.getAficiones(id);
	}

	
	public void updatePersona(Persona persona) {
		
		mapper.updatePersona(persona);
	}
	
	public void deletePersona(int id) {
		
		mapper.delete(id);
	}
}
