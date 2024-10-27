package ru.netology.data_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.data_service.dto.Request;
import ru.netology.data_service.service.DataService;

@RestController
public class DataController {
    @Autowired
    DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/products/fetch-product")
    public String dataService(@RequestParam("name") String name) {
        return dataService.getProductName(new Request(name));
    }
}