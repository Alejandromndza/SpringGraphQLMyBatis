package com.alejandro.myapp.datafetcherAficiones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Aficiones;
import com.alejandro.myapp.service.AficionesService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAficionesDataFetcher  implements DataFetcher<List<Aficiones>>{


	@Autowired
	private AficionesService aficionesService;
	
	@Override
	public List<Aficiones> get(DataFetchingEnvironment environment) {
		
		return aficionesService.getAll();
		
	}

}
