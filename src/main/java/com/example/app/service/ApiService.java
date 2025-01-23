package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    @Value("${external.api.products}")
    private String productsUrl;

    @Value("${external.api.users}")
    private String usersUrl;

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts() {
        Product[] products = restTemplate.getForObject(productsUrl, Product[].class);
        return Arrays.asList(products != null ? products : new Product[0]);
    }

    public List<User> getUsers() {
        User[] users = restTemplate.getForObject(usersUrl, User[].class);
        return Arrays.asList(users != null ? users : new User[0]);
    }
}