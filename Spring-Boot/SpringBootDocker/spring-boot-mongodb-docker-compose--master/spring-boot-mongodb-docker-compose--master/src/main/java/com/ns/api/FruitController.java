package com.ns.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FruitController {
	
	public static final Logger log = LoggerFactory.getLogger(FruitController.class);
	
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {this.fruitService = fruitService;}

    @PostMapping("/fruits")
    public void addFruit(@RequestBody FruitModel fruitRequest) {
        log.info("Request : {}", fruitRequest);
        fruitService.saveFruit(fruitRequest);
    }

    @GetMapping("/fruits")
    public List<FruitModel> getAllFruit() {
        return fruitService.findAll();
    }
}
