package ua.com.abakumov.doit;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Central configuration class
 * (c) 2016
 * Created by air on 01.11.16.
 */
@SuppressWarnings(value = "unused")
@Configuration
public class Environment {

    @Bean
    public DataSource getDataSource() {

        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("1");

        return dataSource;
    }

}
