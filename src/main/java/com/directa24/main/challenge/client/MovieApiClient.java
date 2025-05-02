package com.directa24.main.challenge.client;

import com.directa24.main.challenge.movie.model.Movie;
import com.directa24.main.challenge.client.model.PaginatedResponse;
import com.directa24.main.challenge.common.api.HttpService;
import com.directa24.main.challenge.common.api.HttpServiceImpl;
import com.directa24.main.challenge.config.ApplicationProperties;
import com.directa24.main.challenge.common.util.parser.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;

public class MovieApiClient {

    private final HttpService httpService;
    private final JsonParser parser;
    private final ApplicationProperties props;

    public MovieApiClient(HttpServiceImpl httpService, JsonParser parser, ApplicationProperties props) {
        this.httpService = httpService;
        this.parser = parser;
        this.props = props;
    }

    public PaginatedResponse<Movie> fetchMovies(int page) {
        String url = props.getApiUrl()+"/api/movies/search?page="+page;
        String response = httpService.get(url);

        return parser.parseObject(response, new TypeReference<>() {});
    }
}
