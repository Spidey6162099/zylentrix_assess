package com.example.zylentrix_assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

public class ZylentrixAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZylentrixAssessmentApplication.class, args);
    }

}
