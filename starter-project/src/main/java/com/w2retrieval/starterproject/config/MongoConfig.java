package com.w2retrieval.starterproject.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.w2retrieval.starterproject.converter.EETaxDataConverter;
import com.w2retrieval.starterproject.model.EETaxData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.w2retrieval.starterproject.model.EEFormData;

import com.w2retrieval.starterproject.converter.EEFormDataConverter;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
//@EnableMongoRepositories
//@EnableMongoRepositories(basePackages = "com.baeldung.repository")
//public class MongoConfig extends AbstractMongoClientConfiguration {
public class MongoConfig {
    @Bean
    public MongoCustomConversions customConversions()
    {
        List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
        converterList.add(new EEFormDataConverter());
        converterList.add(new EETaxDataConverter());
        return new MongoCustomConversions(converterList);
    }

}




/*
@Configuration
@EnableMongoRepositories(basePackages = "com.baeldung.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.baeldung");
    }

    @Bean
    public UserCascadeSaveMongoEventListener userCascadingMongoEventListener() {
        return new UserCascadeSaveMongoEventListener();
    }

    @Bean
    public CascadeSaveMongoEventListener cascadingMongoEventListener() {
        return new CascadeSaveMongoEventListener();
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new UserWriterConverter());
        return new MongoCustomConversions(converters);
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
*/
