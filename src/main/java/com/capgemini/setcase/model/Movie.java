package com.capgemini.setcase.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    @Length(max = 25, min = 1, message = "Surname must be between 1 and 25 characters.")
    private String title;
    @Length(max = 25, min = 1, message = "Name must be between 1 and 25 characters.")
    private String name;


    public Movie() {
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie[id=%d, title='%s']",
                movieId, title);
    }
}
