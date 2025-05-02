## Implemented features

### Main feature: Directors threshold
The primary feature is to find all directors who have directed more than a specified number of movies, returning their names in alphabetical order.

```java
List<String> getDirectors(int threshold)
```

### Additional features
Beyond the main requirement, the following additional features have been implemented:

1. **Movies by Maximum Runtime**: Find all movies with runtime less than or equal to a specified value in minutes.
   ```java
   List<String> getTitlesWithMaxRuntime(int maxRuntime)
   ```

2. **Movies by Minimum Year**: Find all movies released in or after a specified year.
   ```java
   List<String> getTitlesFromYear(int minYear)
   ```

3. **Movies by Actors**: Find all movies featuring a specified list of actors (movies that contain ALL the actors in the list).
   ```java
   List<String> getTitlesWithActors(List<String> actors)
   ```

4. **Movies by Genres**: Find all movies matching a specified list of genres (movies that contain ALL the genres in the list).
   ```java
   List<String> getTitlesWithGenres(List<String> genres)
   ```

All search results are returned as alphabetically sorted lists of movie titles.

### Why these additional features?
These additional features were implemented to enhance the application's utility beyond the core requirement. They provide more flexible ways to explore and filter the movie dataset:

- The runtime filter allows users to find shorter or longer movies based on their time constraints
- The year filter enables focusing on more recent releases
- The actors filter helps users find movies featuring their favorite performers
- The genre filter supports discovery of movies matching specific interests

By implementing these additional features, the application delivers a more comprehensive movie search experience while demonstrating clean, maintainable code architecture that can be easily extended with new functionality.