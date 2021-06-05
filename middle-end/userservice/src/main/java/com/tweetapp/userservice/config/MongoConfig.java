package com.tweetapp.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @author Nithya T
 *  To avoid inserting _class column in mongodb
 */
@Configuration
public class MongoConfig {

	@Autowired
	MongoDatabaseFactory mongoDatabaseFactory;
	@Autowired
	MongoMappingContext mongoMappingContext;

	@Bean
	public MappingMongoConverter mappingMongoConverter() {

		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		return converter;
	}
	
}