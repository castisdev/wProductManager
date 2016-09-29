package com.castis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan
@EnableMongoRepositories
@PropertySource(value = {"classpath:bob-product.properties"})
public class MongoDBConfig extends AbstractMongoConfiguration{
	
	@Autowired
	private Environment env;
	
	@Override
	protected String getDatabaseName() {
		String dbName = env.getRequiredProperty("db.database");
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		String host = env.getRequiredProperty("db.host");
		int port = Integer.parseInt(env.getRequiredProperty("db.port"));
		return new MongoClient(host, port);
	}
	 
	@Override
	public String getMappingBasePackage() {
		return "com.castis";
	}
}
