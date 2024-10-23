package ru.netology.data_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.data_service.dto.Data;
import ru.netology.data_service.repository.DataRepository;

@Service
public class DataService {
    @Autowired
    DataRepository dataRepository;

    public DataService(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    public String getProductName(Data data){
        return dataRepository.getProductName(data);
    }
}
