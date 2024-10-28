package ru.netology.data_service.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    private final String username = "postgres";
    private final String password = "password";
    private final String url = "jdbc:postgresql://localhost:5432/netology";
    private final String driverClassName = "org.postgresql.Driver";

    @Bean
    @Qualifier("dataSource")
    public DataSource dataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.url(url);
        dataSource.password(password);
        dataSource.username(username);
        return dataSource.build();
    }

    @Bean
    @Qualifier("jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
