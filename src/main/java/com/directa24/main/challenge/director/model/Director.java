package com.directa24.main.challenge.director.model;

import java.util.Objects;

public class Director {
    private String name;
    private int movies;

    public Director(String name, int movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public int getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return movies == director.movies && Objects.equals(name, director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movies);
    }
}
