package com.gagan.movieCatalogue.repository;

import com.gagan.movieCatalogue.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {


    @Transactional
    @Modifying
    @Query("update Movie u set u.movieName = :newname where u.movieName = :name")
    void updateByName(@Param(value = "name")String name, @Param(value = "newname")String new_name);

    @Transactional
    @Modifying
    @Query("delete Movie u where u.movieName = :name")
    void deleteByName(@Param(value = "name")String name);
}
