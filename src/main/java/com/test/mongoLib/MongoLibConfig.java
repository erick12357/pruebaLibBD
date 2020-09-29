package com.test.mongoLib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.test.mongoLib.crudBeans.MongoCrud;

@Configuration
public class MongoLibConfig{
	
	@Bean
	public MongoClient mongoClient(){
		return MongoClients.create("mongodb://172.17.0.3:27017");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "MetrobusDb");
	}
	
	@Bean
	public MongoCrud mongoCrud(){
		return new MongoCrud(mongoTemplate());
	}
	
}
