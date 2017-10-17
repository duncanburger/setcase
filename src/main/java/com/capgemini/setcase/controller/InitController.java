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

// Controller only for populating the repositories for demo purposes.

@RestController
public class InitController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/api/init" , method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Movie> movieList() {
        Movie movie = new Movie("Movie title 1");
        movieRepository.save(movie);
        movie = new Movie("Movie title 2");
        movieRepository.save(movie);
        return movieRepository.findAll();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> processValidationError(MethodArgumentNotValidException ex) {
        return mapErrorFields(ex);
    }
}