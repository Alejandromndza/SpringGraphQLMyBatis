package com.alejandro.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.myapp.dao.MarcaMapper;
import com.alejandro.myapp.entity.Marca;

@Service
public class MarcaService {
	
	@Autowired 
	MarcaMapper mapper;
	
	public List<Marca> getAll(){
		
		return mapper.getAll();
	}
	
	public Marca getMarca(int id) {
		
		return mapper.getMarca(id);
	}
	
	public Marca getMarcaString(String nombre) {
		
		return mapper.getMarcaString(nombre);
	}
	
	public Marca insertMarca(Marca marca) {
		
		mapper.insert(marca);
		return marca;
		
	}

}
