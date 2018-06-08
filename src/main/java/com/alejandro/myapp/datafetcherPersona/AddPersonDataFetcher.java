package com.alejandro.myapp.datafetcherPersona;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.entity.Persona;
import com.alejandro.myapp.service.MarcaService;
import com.alejandro.myapp.service.PersonaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AddPersonDataFetcher implements DataFetcher<Persona>{

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Override
	public Persona get(DataFetchingEnvironment env) {

		Map arguments = env.getArguments();
		boolean exito = false;
		Persona p = new Persona();
		String nombre = (String) arguments.get("nombre");

		p.setNombre(nombre);
		p.setSalario((Integer) arguments.get("salario"));
		Map marcaMap = (Map) arguments.get("marca");
		String busqMarca = (String) marcaMap.get("nombre");

		Marca m = marcaService.getMarcaString(busqMarca);

		if (m != null) {
			exito = true;
			p.setMarca(m);
			personaService.insertPersona(p);
		}
		
		if(exito) return personaService.getPersonaString(nombre);
		else return null;

	}
	
}
