package com.directa24.main.challenge.director.service;

import com.directa24.main.challenge.movie.model.Movie;
import com.directa24.main.challenge.common.exception.ServiceException;
import com.directa24.main.challenge.director.model.Director;
import com.directa24.main.challenge.movie.service.MovieService;

import java.util.*;
import java.util.stream.Collectors;

public class DirectorServiceImpl implements DirectorService {

    private static final String SERVICE_EXCEPTION_MESSAGE = "Error retrieving director list.";
    private final MovieService movieService;

    public DirectorServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public List<Director> getDirectors(int threshold) {
        try {
            if (threshold < 1) {
                throw new ServiceException(
                        SERVICE_EXCEPTION_MESSAGE,
                        new IllegalAccessException("Threshold must be greater than 0.")
                );
            }

            List<Movie> movies = movieService.getAllMovies();

            return buildDirectorList(movies, threshold);
        } catch (Exception e) {
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }
    }

    private List<Director> buildDirectorList(List<Movie> movies, int threshold) {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > threshold)
                .map(e -> new Director(e.getKey(), e.getValue().intValue()))
                .sorted(Comparator.comparing(Director::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

}
