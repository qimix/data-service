package ru.netology.data_service.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataConfig {
    String username = "postgres";
    String password = "password";
    String url = "jdbc:postgresql://localhost:5432/netology";
    String driverClassName;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        dataSourceBuilder.url(url);
        return dataSourceBuilder.build();
    }
}
