package com.alejandro.myapp.datafetcherPersona;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Persona;
import com.alejandro.myapp.service.PersonaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetPersonDataFetcher implements DataFetcher<Persona>{

	@Autowired
	private PersonaService personaService;
	
	@Override
	public Persona get(DataFetchingEnvironment env) {
		
		Map arguments = env.getArguments();
		
		return personaService.getPersona((int) arguments.get("id"));
	}

}
