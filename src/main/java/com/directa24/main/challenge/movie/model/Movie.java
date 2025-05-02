package com.directa24.main.challenge.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Movie {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Rated")
    private String rated;
    @JsonProperty("Released")
    private String released;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Director")
    private String director;
    @JsonProperty("Writer")
    private String writer;
    @JsonProperty("Actors")
    private String actors;

    public Movie(String title, String year, String rated, String released, String runtime, String genre,
                 String director, String writer, String actors) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rated='" + rated + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Movie movie = (Movie) o;

        return Objects.equals(title, movie.title)
                && Objects.equals(rated, movie.rated)
                && Objects.equals(released, movie.released)
                && Objects.equals(runtime, movie.runtime)
                && Objects.equals(genre, movie.genre)
                && Objects.equals(director, movie.director)
                && Objects.equals(writer, movie.writer)
                && Objects.equals(actors, movie.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, rated, released, runtime, genre, director, writer, actors);
    }
}
