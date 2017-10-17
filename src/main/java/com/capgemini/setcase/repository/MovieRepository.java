package com.capgemini.setcase.repository;

import com.capgemini.setcase.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    // additional function to count the totals of movies, based on their watched status.
    int countByWatched(int watched);
}

