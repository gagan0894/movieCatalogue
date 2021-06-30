package com.gagan.movieCatalogue.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="GENRES")
public class Genre {

    @Id
    private String name;
    private String description;

    @OneToMany(mappedBy="genre",targetEntity = Movie.class,cascade = CascadeType.ALL)
   // @JoinColumn(name="gm_fk", referencedColumnName = "name")
    @JsonManagedReference
    private List<Movie> movies;

}
