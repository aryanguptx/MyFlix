package com.pes.movies.dao;

import com.pes.movies.model.Movie;
import com.pes.movies.model.Title;

import java.util.List;

public interface MovieDao {
    void save(Movie movie);

    List<Movie> getAllMovies();

    List<Movie> findMovieByTitle(String title);

    void rateMovie(String title, Double rating);

}
