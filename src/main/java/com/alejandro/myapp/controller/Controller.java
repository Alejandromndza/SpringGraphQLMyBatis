package com.alejandro.myapp.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.alejandro.myapp.datafetcherPersona.GetPersonasDataFetcher;
import com.alejandro.myapp.datafetcherPersona.ResolveTypeAficionesDataFetcher;
import com.alejandro.myapp.datafetcherPersona.ResolveTypeMarcaDataFetcher;
import com.alejandro.myapp.datafetcherAficiones.AddAficionesDataFetcher;
import com.alejandro.myapp.datafetcherAficiones.GetAficionDataFetcher;
import com.alejandro.myapp.datafetcherAficiones.GetAficionesDataFetcher;
import com.alejandro.myapp.datafetcherMarca.AddMarcaDataFetcher;
import com.alejandro.myapp.datafetcherMarca.GetMarcaDataFetcher;
import com.alejandro.myapp.datafetcherMarca.GetMarcasDataFetcher;
import com.alejandro.myapp.datafetcherPersona.AddPersonDataFetcher;
import com.alejandro.myapp.datafetcherPersona.GetPersonDataFetcher;
import com.alejandro.myapp.service.PersonaService;

import graphql.ExecutionResult;
import graphql.GraphQL;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;


@RestController
public class Controller {
	
	private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private PersonaService personaService;
	
	@Value("classpath:person.graphqls")
	private Resource schemaResource;
	
	private GraphQL graphql;
	
	/* Definición datafetcher que resuelven consultas y mutaciones clase Persona */
	
	@Autowired
	private GetPersonasDataFetcher getPersonasDataFetcher;
	
	@Autowired
	private GetPersonDataFetcher getPersonDataFetcher;
	
	@Autowired
	private ResolveTypeMarcaDataFetcher resolveTypeMarcaDataFetcher;
	
	@Autowired
	private ResolveTypeAficionesDataFetcher resolveTypeAficionesDataFetcher;
	
	@Autowired 
	private AddPersonDataFetcher addPersonDataFetcher;
	
	/* Definición datafetcher que resuelven consultas y mutaciones clase Marca */
	
	@Autowired
	private GetMarcaDataFetcher getMarcaDataFetcher;
	
	@Autowired
	private GetMarcasDataFetcher getMarcasDataFetcher;
	
	@Autowired
	private AddMarcaDataFetcher addMarcaDataFetcher;
	
	/* Definición datafetcher que resuelven consultas y mutaciones clase Aficiones */
	
	@Autowired
	private GetAficionDataFetcher getAficionDataFetcher;
	
	@Autowired
	private GetAficionesDataFetcher getAficionesDataFetcher;
	
	@Autowired
	private AddAficionesDataFetcher addAficionesDataFetcher;
	
	@PostConstruct
	public void loadSchema() throws IOException {
		
		File schemaFile = schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRunTimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphql = GraphQL.newGraphQL(schema).build();
	}
	
	
	private RuntimeWiring buildRunTimeWiring() {
	
		return RuntimeWiring.newRuntimeWiring()
				
				.type("Query", typeWiring->typeWiring
						.dataFetcher("personas", getPersonasDataFetcher)
						.dataFetcher("person", getPersonDataFetcher)
						.dataFetcher("marca", getMarcaDataFetcher)
						.dataFetcher("marcas", getMarcasDataFetcher)
						.dataFetcher("aficiones", getAficionesDataFetcher)
						.dataFetcher("aficion", getAficionDataFetcher))
						
			
				.type("Mutation", typeWiring->typeWiring
						.dataFetcher("agregarPersona", addPersonDataFetcher)
						.dataFetcher("agregarMarca", addMarcaDataFetcher)
						.dataFetcher("agregarAficion", addAficionesDataFetcher))
						
				
				
				.type("Persona", typeWiring->typeWiring
						.dataFetcher("marca", resolveTypeMarcaDataFetcher)
						.dataFetcher("aficiones", resolveTypeAficionesDataFetcher))
				
				.build();
				
	}


	@RequestMapping(value  = "/query", method = RequestMethod.POST)
	public ResponseEntity query(@RequestBody String query) {
	
		ExecutionResult result = graphql.execute(query);
		LOGGER.info(String.valueOf(result.getErrors()));
		return ResponseEntity.ok(result.getData());
		
	}
	

}
