package com.directa24.main.challenge.movie.service;

import com.directa24.main.challenge.movie.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();
    List<String> getTitlesWithMaxRuntime(int maxRuntime);
    List<String> getTitlesFromYear(int minYear);
    List<String> getTitlesWithActors(List<String> actors);
    List<String> getTitlesWithGenres(List<String> genres);
}
