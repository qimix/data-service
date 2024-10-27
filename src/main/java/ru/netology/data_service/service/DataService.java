package ru.netology.data_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.data_service.dto.Request;
import ru.netology.data_service.repository.DataRepository;

@Service
public class DataService {
    @Autowired
    DataRepository dataRepository;

    public DataService(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    public String getProductName(Request request){
        return dataRepository.getProductName(request);
    }
}
