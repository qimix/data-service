package ru.netology.data_service.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.data_service.dto.Data;
import ru.netology.data_service.dto.Order;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class DataRepository {
    private final String selectProducts = read("products.sql");
    private final String username = "postgres";
    private final String password = "password";
    private final String url = "jdbc:postgresql://localhost:5432/netology";
    private final String driverClassName = "org.postgresql.Driver";
    private final DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create()
    .username(username)
    .password(password)
    .url(url)
    .driverClassName(driverClassName);
    private final DataSource dataSource = dataSourceBuilder.build();
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public String getProductName(String name){
        String query = "SELECT DISTINCT product_name from orders JOIN customers ON orders.customer_id = customers.id where lower(customers.name) like '" + name + "'";
        Order order = jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                    return new Order(
                            rs.getString("product_name"));
        });
        return order.getProduct_name();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
