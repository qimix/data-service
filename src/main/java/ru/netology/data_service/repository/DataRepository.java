package ru.netology.data_service.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.netology.data_service.dto.Data;
import ru.netology.data_service.dto.Order;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
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

    public String getProductName(Data data){
        Order order = jdbcTemplate.queryForObject("select * from orders where id = 1", (ResultSet, rowNum) -> {
                    Order newOrder = new Order();
                    newOrder.setId(ResultSet.getLong("id"));
                    newOrder.setDate(ResultSet.getDate("date").toLocalDate());
                    newOrder.setCustomer_id(ResultSet.getLong("customer_id"));
                    newOrder.setAmount(ResultSet.getInt("amount"));
                    return newOrder;
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
