package com.gagan.movieCatalogue.repository;

import com.gagan.movieCatalogue.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,String> {
    List<Genre> findByName(String name);
    @Transactional
    void deleteByName(String name);
}
