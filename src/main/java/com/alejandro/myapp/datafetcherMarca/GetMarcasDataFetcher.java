package com.alejandro.myapp.datafetcherMarca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.service.MarcaService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetMarcasDataFetcher  implements DataFetcher<List<Marca>> {

	@Autowired
	private MarcaService marcaService;
	
	@Override
	public List<Marca> get(DataFetchingEnvironment env) {
		
		return marcaService.getAll();
		
	}

}
