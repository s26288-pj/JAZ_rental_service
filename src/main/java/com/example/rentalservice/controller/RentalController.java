package com.example.rentalservice.controller;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentalService")
public class RentalController {

    RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rentalService.getMovieById(id));
    }

    @PutMapping("returnMovie/{id}")
    public void returnMovie(@PathVariable("id") Long id) {
        rentalService.returnMovie(id);
    }

    @PutMapping("rentMovie/{id}")
    public void rentMovie(@PathVariable("id") Long id) {
        rentalService.rentMovie(id);
    }
}
