package com.example.demoo2;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyControler {
    private final ClientRepository clientRepository;

    public MyControler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping("get")
    public List<Task> doGet(@RequestParam (required = false,defaultValue ="0"  )Integer page){
        return clientRepository.findAll(PageRequest.of(page, 1)).getContent();
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onException(){
        return "Wrong page number";

    }
}
