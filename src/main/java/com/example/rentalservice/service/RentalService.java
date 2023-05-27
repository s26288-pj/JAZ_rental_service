package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Movie getMovieById(Long id) {
//        ResponseEntity<Movie> exchange = restTemplate.exchange("http://localhost:8080/movies/{id}", HttpMethod.GET, null, Movie.class, id);
        Movie movie = restTemplate.getForObject("http://localhost:8080/movieService/movies/{id}", Movie.class, id);
        return movie;
    }

    public void returnMovie(Long id) {
        restTemplate.put("http://localhost:8080/movieService/movies/{id}/return", Movie.class, id);
    }

    public void rentMovie(Long id) {
        restTemplate.put("http://localhost:8080/movieService/movies/{id}/rent", Movie.class, id);
    }
}
