package com.directa24.main.challenge.movie.service;

import com.directa24.main.challenge.client.MovieApiClient;
import com.directa24.main.challenge.client.model.PaginatedResponse;
import com.directa24.main.challenge.common.exception.ServiceException;
import com.directa24.main.challenge.movie.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {

    private final MovieApiClient client;

    public MovieServiceImpl(MovieApiClient client) {
        this.client = client;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        int page = 1;
        PaginatedResponse<Movie> response;

        do {
            response = client.fetchMovies(page);
            movies.addAll(response.getData());
            page++;
        } while (page <= response.getTotal_pages());

        return movies;
    }

    @Override
    public List<String> getTitlesWithMaxRuntime(int maxRuntime) {
        try {
            List<Movie> movies = getAllMovies();

            return movies.stream()
                    .filter(movie -> parseRuntimeMinutes(movie.getRuntime()) <= maxRuntime)
                    .map(Movie::getTitle)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(String.format("Error filtering movies by runtime: %s", maxRuntime), e);
        }
    }

    @Override
    public List<String> getTitlesFromYear(int minYear) {
        try {
            List<Movie> movies = getAllMovies();

            return movies.stream()
                    .filter(movie -> parseYear(movie.getYear()) >= minYear)
                    .map(Movie::getTitle)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(String.format("Error filtering movies by year: %s", minYear), e);
        }
    }

    @Override
    public List<String> getTitlesWithActors(List<String> actors) {
        try {
            List<Movie> movies = getAllMovies();

            return movies.stream()
                    .filter(movie -> containsAll(movie.getActors(), actors))
                    .map(Movie::getTitle)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(String.format("Error filtering movies by actors: %s", actors), e);
        }
    }

    @Override
    public List<String> getTitlesWithGenres(List<String> genres) {
        try {
            List<Movie> movies = getAllMovies();

            return movies.stream()
                    .filter(movie -> containsAll(movie.getGenre(), genres))
                    .map(Movie::getTitle)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new ServiceException(String.format("Error filtering movies by genres: %s", genres), e);
        }
    }

    private int parseRuntimeMinutes(String runtime) {
        try {
            String digits = runtime.replaceAll("\\D+", "");
            return Integer.parseInt(digits);
        } catch (Exception e) {
            return 0;
        }
    }

    private int parseYear(String year) {
        try {
            return Integer.parseInt(year.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean containsAll(String values, List<String> filterValue) {
        Set<String> present = Arrays.stream(values.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        return filterValue.stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .allMatch(present::contains);
    }
}
