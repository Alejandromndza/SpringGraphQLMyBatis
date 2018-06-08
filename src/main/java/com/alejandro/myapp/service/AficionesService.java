package com.alejandro.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.myapp.dao.AficionesMapper;
import com.alejandro.myapp.entity.Aficiones;


@Service
public class AficionesService {
	
	@Autowired 
	AficionesMapper mapper;
	
	public List<Aficiones> getAll(){
		
		return mapper.getAll();
	}
	
	public Aficiones getAficion(int id) {
		
		return mapper.getAficion(id);
	}
	
	public Aficiones getAficionString(String nombre) {
		
		return mapper.getAficionString(nombre);
	}
	
	public Aficiones insertAficion(Aficiones aficiones) {
		
		mapper.insert(aficiones);
		return aficiones;
		
	}

}
