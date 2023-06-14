package com.example.service.impl;

import com.example.model.University;
import com.example.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    public static final String URL = "http://universities.hipolabs.com/search";

    private final RestTemplate restTemplate;

    @Autowired
    public UniversityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<University> searchByName(String name) {
        String api = URL + String.format("?name=%s", name);
        List<University> universityList = restTemplate.getForObject(api, List.class);
        return universityList;
    }

    @Override
    public List<University> searchByCountry(String country) {
        String api = URL + String.format("?country=%s", country);
        List<University> universityList = restTemplate.getForObject(api, List.class);
        return universityList;
    }
}
