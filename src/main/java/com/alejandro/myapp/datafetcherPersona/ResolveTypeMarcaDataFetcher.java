package com.alejandro.myapp.datafetcherPersona;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.entity.Persona;
import com.alejandro.myapp.service.PersonaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ResolveTypeMarcaDataFetcher implements DataFetcher<Marca>{

	@Autowired
	private PersonaService personaService;
	
	@Override
	public Marca get(DataFetchingEnvironment env) {
		
		Persona persona = (Persona) env.getSource();

		return personaService.getMarca(persona.getId());
	}

}
