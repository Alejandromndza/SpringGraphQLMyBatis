package com.alejandro.myapp.datafetcherPersona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Aficiones;
import com.alejandro.myapp.entity.Persona;
import com.alejandro.myapp.service.PersonaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ResolveTypeAficionesDataFetcher implements DataFetcher<List<Aficiones>>{

	@Autowired
	private PersonaService personaService;
	
	@Override
	public List<Aficiones> get(DataFetchingEnvironment env) {
		
		Persona persona = (Persona) env.getSource();

		return personaService.getAficiones(persona.getId());
	}

}
