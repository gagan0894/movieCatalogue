package com.gagan.movieCatalogue.controller;

import com.gagan.movieCatalogue.model.AddMovieRequest;
import com.gagan.movieCatalogue.model.Genre;
import com.gagan.movieCatalogue.service.MovieCatalogueService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/movieCatalogue")
public class MovieCatalogueController {

    @Autowired
    private MovieCatalogueService movieCatalogueService;

    @PostMapping("/addMovie")
    @ApiOperation(value="Add a movie to the catalogue",
            notes="Contains the information for both movie and it genre, to maintain the relation ",
            response=ResponseEntity.class)
    public ResponseEntity addMovie(@ApiParam(value="contains the information for a genre and the list of movie to be added to that genre",required=true)
            @RequestBody AddMovieRequest addMovieRequest)
    {
        movieCatalogueService.addMovie(addMovieRequest.getGenre());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/retrieveAllMovies")
    @ApiOperation(value="Find all the movies in the catalogue",
            notes="finds all the movie with it genres, returns list of Genre")
    public List<Genre> getAllMovies()
    {
        return movieCatalogueService.getAllMovies();
    }

    @GetMapping("/retrieveByGenre/{genreName}")
    @ApiOperation(value="Find all the movies in the catalogue by a genre",
            notes="finds all the movie for a genre, returns list of Genre")
    public List<Genre> getMoviesByGenreName(@PathVariable String genreName)
    {
        return movieCatalogueService.getMoviesByGenreName(genreName);
    }

    @DeleteMapping("/removeGenre/{genreName}")
    @ApiOperation(value="Deletes the genre and the assoicated movies",
            notes="Deletes the genre and the assoicated movies, maintaining the relationship between movies and genre",
            response=ResponseEntity.class)
    public ResponseEntity removeGenre(@ApiParam(value="genre category to be removed",required=true)
            @PathVariable String genreName)
    {
         movieCatalogueService.removeGenre(genreName);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/removeMovie/{movieName}")
    @ApiOperation(value="Deletes a particular movie",
            notes="Deletes a specific movie from the catalogue",
            response=ResponseEntity.class)
    public ResponseEntity removeMovie(@ApiParam(value="movie to be removed",required=true)
            @PathVariable String movieName)
    {
        movieCatalogueService.removeMovie(movieName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
