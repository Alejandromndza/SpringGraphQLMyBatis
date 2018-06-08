package com.alejandro.myapp.datafetcherMarca;

import java.util.Collection;
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
public class AddMarcaDataFetcher implements DataFetcher<Marca>{

	
	@Autowired
	private MarcaService marcaService;
	
	@Override
	public Marca get(DataFetchingEnvironment env) {
		
		Map arguments = env.getArguments();	
		String nombre = (String)arguments.get("nombre");
		
		Marca m = new Marca();
			
		m.setNombre(nombre);

		marcaService.insertMarca(m);

		return marcaService.getMarcaString(nombre);
	
	}

}


