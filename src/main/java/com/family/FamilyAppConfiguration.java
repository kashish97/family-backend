package com.family;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Configuration
@ComponentScan({"com.family"})
//@PropertySource("classpath:zelish.properties")
public class FamilyAppConfiguration {

    @Value("${testCluster.host:13.235.51.142}")
    public String host;
    @Value("${testCluster.port:9300}")
    public int port;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }


    @Bean
    public RestHighLevelClient restClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, 9200, "http"),
                        new HttpHost(host, 9201, "http")));
        return client;
    }

    @Value("${zelish.service.connectivity.details}")
    private String mongoURI;

    @Value("${zelish.service.collection.name}")
    private String collectionName;

    @Bean(name = "mongoTemplate")
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(new MongoClient(new MongoClientURI(mongoURI)), collectionName);
    }

    @Bean
    public Docket zelishServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.family")).paths(PathSelectors.regex("/family.*"))
                .build();
    }
}