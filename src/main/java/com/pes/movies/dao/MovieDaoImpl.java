package com.pes.movies.dao;

import com.pes.movies.model.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao{

    private EntityManager entityManager;

    @Autowired
    public MovieDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Movie movie) {
        entityManager.persist(movie);
    }

    public List<Movie> getAllMovies() {
        TypedQuery<Movie> query = entityManager.createQuery("Select m from Movie m", Movie.class);
        return query.getResultList();
    }

    @Override
    public List<Movie> findMovieByTitle(String title) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m from Movie m where m.title =: theTitle", Movie.class);
        query.setParameter("theTitle", title);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void rateMovie(String title, Double rating) {
        // Retrieve the movie entity by its title
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class);
        query.setParameter("title", title);
        List<Movie> movies = query.getResultList();

        if (!movies.isEmpty()) {
            // Update the rating of the first movie found with the given title
            Movie movie = movies.get(0);
            movie.setAverageRating(rating);
            // Persist the updated movie entity
            entityManager.merge(movie);
            System.out.println("Rating updated successfully for movie: " + title);
        } else {
            System.out.println("Movie not found with title: " + title);
        }
    }

}


