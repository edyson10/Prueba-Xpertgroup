package com.xpertgroup.catapi.service;

import java.util.List;

import com.xpertgroup.catapi.model.Breed;

public interface CatService {

	List<Breed> getAllBreeds();

    Breed getBreedById(String breedId);

    List<Breed> searchBreeds(String query);

}
