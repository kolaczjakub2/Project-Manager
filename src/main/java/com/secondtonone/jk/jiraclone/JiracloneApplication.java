package com.secondtonone.jk.jiraclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.secondtonone.jk.jiraclone.domain.*"})
@EnableJpaAuditing
public class JiracloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiracloneApplication.class, args);
    }

}
