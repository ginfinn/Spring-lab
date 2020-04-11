package com.example.demoo2.service;

import com.example.demoo2.utils.DataTransferObject;
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

    public List<DataTransferObject> getAllStatus() {
        ResponseEntity<List<DataTransferObject>> response = restTemplate.exchange(
                "http://localhost:8081/getStatusHistory",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DataTransferObject>>() {
                }
        );
        return response.getBody();
    }

    public void changeStatus(Integer id, TaskStatus status) {
        restTemplate.exchange("http://localhost:8081/change?id={id}&status={status}",
                HttpMethod.PUT,
                null,
                String.class,
                id,
                status
        );

    }
}
