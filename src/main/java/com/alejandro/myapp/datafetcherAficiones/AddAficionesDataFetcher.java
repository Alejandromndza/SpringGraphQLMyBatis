package com.alejandro.myapp.datafetcherAficiones;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Aficiones;
import com.alejandro.myapp.service.AficionesService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AddAficionesDataFetcher implements DataFetcher<Aficiones>{

	
	@Autowired
	private AficionesService aficionesService;
	
	@Override
	public Aficiones get(DataFetchingEnvironment env) {
		
		Map arguments = env.getArguments();	
		String nombre = (String)arguments.get("nombre");

		Aficiones m = new Aficiones();
			
		m.setNombre(nombre);

		aficionesService.insertAficion(m);

		return aficionesService.getAficionString(nombre);
	}

}




