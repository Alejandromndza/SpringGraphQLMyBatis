package com.alejandro.myapp.datafetcherAficiones;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.myapp.entity.Aficiones;
import com.alejandro.myapp.service.AficionesService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAficionDataFetcher implements DataFetcher<Aficiones>{
	
	@Autowired
	private AficionesService aficionesService;
	
	@Override
	public Aficiones get(DataFetchingEnvironment env) {
		
		Map arguments = env.getArguments();
		
		return aficionesService.getAficion((int) arguments.get("id"));
		
	}

}
