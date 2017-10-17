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
    private Integer movieId; // Integer, so a null check can be made.
    @Length(max = 50, min = 1, message = "Title must be between 1 and 50 characters.")
    private String title;
    private int watched; // no boolean to have more statusses in future.
        // 0 --> unwatched (default)
        // 1 --> watched


    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
        this.watched = 0;
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

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie[id=%d, title='%s']",
                movieId, title);
    }
}
