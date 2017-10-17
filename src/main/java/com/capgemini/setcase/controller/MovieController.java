package com.capgemini.setcase.controller;

import com.capgemini.setcase.model.Movie;
import com.capgemini.setcase.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static com.capgemini.setcase.utils.ErrorMapping.mapErrorFields;


@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/api/movies/" , method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Movie> movieList() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/api/movies/", method = RequestMethod.POST)
    public Movie addMovie(@Valid @RequestBody Movie movie) {

        movieRepository.save(movie);
        return movie;
    }

    @RequestMapping(value = "/api/movies/", method = RequestMethod.PUT)
    public Movie modifyMovie(@Valid @RequestBody Movie movie) {

        movieRepository.save(movie);
        return movie;
    }
    @RequestMapping(value = "/api/movies/", method = RequestMethod.DELETE)
    public Movie deleteMovie(@Valid @RequestBody Movie movie) {

        movieRepository.delete(movie);
        return movie;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> processValidationError(MethodArgumentNotValidException ex) {
        return mapErrorFields(ex);
    }
}