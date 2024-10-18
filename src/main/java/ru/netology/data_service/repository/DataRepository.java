package ru.netology.data_service.repository;

import org.springframework.stereotype.Repository;
import ru.netology.data_service.dto.Data;

@Repository
public class DataRepository {
    public String getProductName(Data data){
        data.getName();
    }
}
