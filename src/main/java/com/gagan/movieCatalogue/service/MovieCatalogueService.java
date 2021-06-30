package com.gagan.movieCatalogue.service;

import com.gagan.movieCatalogue.model.Genre;
import com.gagan.movieCatalogue.repository.GenreRepository;
import com.gagan.movieCatalogue.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieCatalogueService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    private List<Genre> genreList=new ArrayList<Genre>();


    public void addMovie(Genre genre) {
        genreRepository.save(genre);
    }

    public List<Genre> getAllMovies() {
        genreRepository.findAll().forEach(genreList:: add);
        return genreList;
    }

    public List<Genre> getMoviesByGenreName(String genreName) {
        return genreRepository.findByName(genreName);


    }

    public void removeGenre(String genreName) {
        genreRepository.deleteByName(genreName);
    }

    public void removeMovie(String movieName) {
        movieRepository.deleteByName(movieName);
    }
}
