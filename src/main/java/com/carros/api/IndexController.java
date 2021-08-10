package com.carros.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // identifica o método rest
@RequestMapping("/") // mapeia o caminho
public class IndexController {

    @GetMapping
    public String hello(){
        return "Hello Spring Boot";
    }

}
