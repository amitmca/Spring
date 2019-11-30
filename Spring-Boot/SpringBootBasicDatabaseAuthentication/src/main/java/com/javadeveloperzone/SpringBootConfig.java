package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan({"com.javadeveloperzone"})

// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }

    @Bean(value = "datasource")
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
