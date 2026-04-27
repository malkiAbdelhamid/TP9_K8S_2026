package com.esi.mspatient.Proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQlClientConfig {

    @Value("${ordonnance.service.url}")
    private String ordonnanceUrl;

    @Value("${remboursement.service.url}")
    private String remboursementUrl;

    @Bean
    @Qualifier("OrdonnanceGraphQlClient")
    HttpGraphQlClient ordonnanceGraphQlClient() {

        WebClient webClient = WebClient.builder()
                .baseUrl(ordonnanceUrl + "/graphql")
                .build();

        return HttpGraphQlClient.builder(webClient).build();
    }

    @Bean
    @Qualifier("RemboursementGraphQlClient")
    HttpGraphQlClient remboursementGraphQlClient() {

        WebClient webClient = WebClient.builder()
                .baseUrl(remboursementUrl + "/graphql")
                .build();

        return HttpGraphQlClient.builder(webClient).build();
    }
}