package com.alejandro.myapp.datafetcherMarca;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.service.MarcaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetMarcaDataFetcher implements DataFetcher<Marca>{

	@Autowired
	private MarcaService marcaService;
	
	@SuppressWarnings("rawtypes")
	@Override
	public Marca get(DataFetchingEnvironment env) {
		
		Map arguments = env.getArguments();
		
		return marcaService.getMarca((int) arguments.get("id"));
	}

}





