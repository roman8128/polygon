package com.example.polygon;

import com.example.polygon.entity.GroupedDaily;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class PolygonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolygonApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RestClient.Builder builder) {
        return args -> {
            var client = builder
                    .baseUrl("http://localhost:8080")
                    .defaultHeader(HttpHeaders.ACCEPT, String.valueOf(MediaType.APPLICATION_JSON))
                    .build();

            ResponseEntity<GroupedDaily> entity =
                    client.get()
                            .uri("/api/polygon")
                            .retrieve()
                            .toEntity(GroupedDaily.class);

            System.out.println(entity);
        };
    }

}
