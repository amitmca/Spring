package com.ns.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {this.fruitRepository = fruitRepository;}

    public void saveFruit(FruitModel fruitModel) {
        fruitRepository.save(fruitModel);
    }

    public List<FruitModel> findAll() {
        return fruitRepository.findAll();
    }
}
