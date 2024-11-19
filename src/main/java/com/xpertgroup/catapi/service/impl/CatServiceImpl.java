package com.xpertgroup.catapi.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xpertgroup.catapi.model.Breed;
import com.xpertgroup.catapi.service.CatService;

@Service
public class CatServiceImpl implements CatService {

	private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.thecatapi.com/v1";
    private static final String API_KEY = "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP";

    public CatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Breed> getAllBreeds() {
        String url = BASE_URL + "/breeds";
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Breed[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Breed[].class);
        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }
        return Collections.emptyList();
    }


	@Override
	public Breed getBreedById(String breedId) {
		String url = BASE_URL + "/breeds/" + breedId;
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Breed> response = restTemplate.exchange(url, HttpMethod.GET, entity, Breed.class);
        Breed breed = response.getBody();
        return breed;
	}

	@Override
	public List<Breed> searchBreeds(String query) {
		String url = BASE_URL + "/breeds/search?q=" + query;
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Breed[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Breed[].class);
        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }
        return Collections.emptyList();
	}

	private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", API_KEY);
        return headers;
    }
	

}
