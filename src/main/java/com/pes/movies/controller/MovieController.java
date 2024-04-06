package com.pes.movies.controller;
import java.util.*;
import com.pes.movies.dao.MovieDao;
import com.pes.movies.model.Movie;
import com.pes.movies.model.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private MovieDao movieDao;

    @Autowired
    public MovieController(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @GetMapping("/display")
    public List<Movie> getAllMovies(){
        return  movieDao.getAllMovies();
    }

    @GetMapping("/{title}")
    public List<Movie> findMovie(@PathVariable("title") String title){
        System.out.println("Searching for movie " + title);
        return movieDao.findMovieByTitle(title);

    }

    @PostMapping("/rate")
    public String rateMovie(@RequestParam("title") String title, @RequestParam("rating") double rating) {
        movieDao.rateMovie(title, rating);
        return "Movie rating updated successfully";
    }

    @PostMapping("/save")
    public String saveMovie(@RequestBody Movie movie){
        System.out.println(movie.toString());
        movieDao.save(movie);
        return "Movie persisted to database";
    }
}
