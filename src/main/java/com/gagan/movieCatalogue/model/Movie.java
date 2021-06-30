package com.gagan.movieCatalogue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="MOVIES")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name="ID_MOVIE")
    private int id;
    @Column(name="MOVIE_NAME")
    private String movieName;

    @ManyToOne
    @JoinColumn(name="name")
    @JsonBackReference
    private Genre genre;


}
