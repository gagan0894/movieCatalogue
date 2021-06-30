package com.gagan.movieCatalogue.controller;

import com.gagan.movieCatalogue.model.AddMovieRequest;
import com.gagan.movieCatalogue.model.Genre;
import com.gagan.movieCatalogue.service.MovieCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class MovieCatalogueController {

    @Autowired
    private MovieCatalogueService movieCatalogueService;

    @PostMapping("/addMovie")
    public HttpEntity addMovie(@RequestBody AddMovieRequest addMovieRequest)
    {
        movieCatalogueService.addMovie(addMovieRequest.getGenre());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/retrieveAllMovies")
    public List<Genre> getAllMovies()
    {
        return movieCatalogueService.getAllMovies();
    }

    @GetMapping("/retrieveByGenre/{genreName}")
    public List<Genre> getMoviesByGenreName(@PathVariable String genreName)
    {
        return movieCatalogueService.getMoviesByGenreName(genreName);
    }

    @DeleteMapping("/removeGenre/{genreName}")
    public HttpEntity removeGenre(@PathVariable String genreName)
    {
         movieCatalogueService.removeGenre(genreName);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/removeMovie/{movieName}")
    public HttpEntity removeMovie(@PathVariable String movieName)
    {
        movieCatalogueService.removeMovie(movieName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
