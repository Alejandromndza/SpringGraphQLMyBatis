package com.alejandro.myapp.datafetcherPersona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Persona;
import com.alejandro.myapp.service.PersonaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetPersonasDataFetcher implements DataFetcher<List<Persona>> {

	@Autowired
	private PersonaService personaService;
	
	@Override
	public List<Persona> get(DataFetchingEnvironment env) {
		
		return personaService.getAll();
	}

}
