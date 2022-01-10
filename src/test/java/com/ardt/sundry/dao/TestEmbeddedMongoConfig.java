package com.ardt.sundry.dao;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@TestConfiguration
@EnableMongoRepositories(basePackages = "com.ardt.sundry.repository", mongoTemplateRef = "userTestMongoTemplate")
public class TestEmbeddedMongoConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public MongodExecutable mongodExecutable() throws IOException {
        MongodStarter starter = MongodStarter.getDefaultInstance();

        IMongodConfig mongoDConfig = new MongodConfigBuilder()
                .version(Version.Main.V3_4)
                .net(new Net("127.0.0.1", 27017, false))
                .build();

        return starter.prepare(mongoDConfig);
    }

    @Bean("userTestMongoTemplate")
    public MongoTemplate mongoTemplate() throws IOException {
        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        return new MongoTemplate(mongo, "USER_TEST_DB");
    }
}