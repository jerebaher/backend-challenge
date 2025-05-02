package com.directa24.main.challenge;

import com.directa24.main.challenge.client.MovieApiClient;
import com.directa24.main.challenge.common.api.HttpServiceImpl;
import com.directa24.main.challenge.config.ApplicationProperties;
import com.directa24.main.challenge.common.util.parser.JsonParserImpl;
import com.directa24.main.challenge.director.model.Director;
import com.directa24.main.challenge.director.service.DirectorServiceImpl;
import com.directa24.main.challenge.movie.service.MovieServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

   public static void main(String[] args) {
      List<String> directors = getDirectors(3);
      //List<String> moviesWithMaxRuntime = getMoviesWithMaxRuntime(85);
      //List<String> moviesFromYear = getMoviesFromYear(2015);
      //List<String> moviesWithActors = getMoviesByActors(List.of("Emma Stone", "Joaquin Phoenix"));
      //List<String> moviesByGenres = getMoviesByGenres(List.of("Comedy", "Crime"));

      System.out.println(directors);
      //System.out.println(moviesFromYear);
      //System.out.println(moviesWithMaxRuntime);
      //System.out.println(moviesWithActors);
      //System.out.println(moviesByGenres);
   }

   /*
    * Complete the 'getDirectors' function below.
    *
    * The function is expected to return a List<String>.
    * The function accepts int threshold as parameter.
    *
    * URL
    * https://directa24-movies.mocklab.io/api/movies/search?page=<pageNumber>
    */
   public static List<String> getDirectors(int threshold) {
      DirectorServiceImpl service = new DirectorServiceImpl(
              new MovieServiceImpl(
                      new MovieApiClient(
                              new HttpServiceImpl(),
                              new JsonParserImpl(),
                              new ApplicationProperties()
                      )
              )
      );

      return service.getDirectors(threshold).stream().map(Director::getName).collect(Collectors.toList());
   }

   public static List<String> getMoviesWithMaxRuntime(int maxRuntime) {
      MovieServiceImpl service = new MovieServiceImpl(
              new MovieApiClient(
                      new HttpServiceImpl(),
                      new JsonParserImpl(),
                      new ApplicationProperties()
              )
      );

      return service.getTitlesWithMaxRuntime(maxRuntime);
   }

   public static List<String> getMoviesFromYear(int year) {
      MovieServiceImpl service = new MovieServiceImpl(
              new MovieApiClient(
                      new HttpServiceImpl(),
                      new JsonParserImpl(),
                      new ApplicationProperties()
              )
      );

      return service.getTitlesFromYear(year);
   }

   public static List<String> getMoviesByActors(List<String> actors) {
      MovieServiceImpl service = new MovieServiceImpl(
              new MovieApiClient(
                      new HttpServiceImpl(),
                      new JsonParserImpl(),
                      new ApplicationProperties()
              )
      );

      return service.getTitlesWithActors(actors);
   }

   public static List<String> getMoviesByGenres(List<String> genres) {
      MovieServiceImpl service = new MovieServiceImpl(
              new MovieApiClient(
                      new HttpServiceImpl(),
                      new JsonParserImpl(),
                      new ApplicationProperties()
              )
      );

      return service.getTitlesWithGenres(genres);
   }

}
