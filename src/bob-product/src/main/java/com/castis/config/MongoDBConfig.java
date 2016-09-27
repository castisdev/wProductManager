package com.castis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan
@EnableMongoRepositories
public class MongoDBConfig extends AbstractMongoConfiguration{
	
	 @Override
	 protected String getDatabaseName() {
	  return "products";
	 }

	 @Override
	 public Mongo mongo() throws Exception {
	  return new MongoClient("bobmann.asuscomm.com", 27017);
	 }
	 
	 @Override
	 public String getMappingBasePackage() {
	  return "com.castis";
	 }
}
