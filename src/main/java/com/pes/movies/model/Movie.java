package com.pes.movies.model;

import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Movie() {
    }

    public Movie(String title, int releaseYear, String genre, String director, double averageRating) {

        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.director = director;
        this.averageRating = averageRating;
    }

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Column(name = "release_year")
    private int releaseYear;
    private String genre;

    private String director;

    @Column(name = "average_rating")
    private double averageRating;

    @Override
    public String toString() {
        return "Movie{" +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", averageRating=" + averageRating +
                '}';
    }


}
