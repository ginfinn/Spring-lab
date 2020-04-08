package com.example.demoo2.service;
import com.example.demoo2.utils.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;
    public List<TaskStatus> getForObject() {
        ResponseEntity<List<TaskStatus>> respons = restTemplate.exchange(
                "http://localhost:8081/getStatusHistory",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TaskStatus>>() {
                }
        );
   return respons.getBody();
    }
}
