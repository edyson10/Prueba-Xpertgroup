package com.xpertgroup.catapi.controller;

import java.util.List;

import com.xpertgroup.catapi.model.Breed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xpertgroup.catapi.service.CatService;

@RestController
@RequestMapping("/api/v1/cats")
public class CatController {
	
	private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/breeds")
    public ResponseEntity<List<Breed>> getAllBreeds() {
        List<Breed> breeds = catService.getAllBreeds();
        return ResponseEntity.ok(breeds);
    }

    @GetMapping("/breeds/{breedId}")
    public ResponseEntity<Breed> getBreedById(@PathVariable String breedId) {
        Breed breed = catService.getBreedById(breedId);
        return ResponseEntity.ok(breed);
    }

    @GetMapping("/breeds/search")
    public ResponseEntity<List<Breed>> searchBreeds(@RequestParam(value = "q") String query) {
        List<Breed> results = catService.searchBreeds(query);
        return ResponseEntity.ok(results);
    }

}
