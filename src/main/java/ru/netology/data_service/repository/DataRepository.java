package ru.netology.data_service.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.data_service.dto.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class DataRepository {
    public static String getProductName(Data data){
        //data.productName
        //"data.sql"
        //return read();
        return new String();
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
