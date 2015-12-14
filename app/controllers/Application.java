package controllers;

import dto.MovieDBSearchDto;
import dto.MovieDto;
import models.Movie;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class Application extends Controller {
    public static final String SEARCH_MOVIE = "/search/movie";
    public static final String MOVIE_BY_ID = "/movie/%d";
    public static final String API_KEY = "api_key";
    public static final String SEARCH_MOVIE_QUERY = "query";

    public static Result index() {
        String name = request().cookies().get("username").value();
        return ok("hello " + name);
    }

    public static Promise<Result> search(String name) {
        WSRequestHolder holder =
                WS.url("http://api.themoviedb.org/3" + SEARCH_MOVIE)
                        .setQueryParameter(API_KEY, System.getProperty("moviedb.api.key"))
                        .setQueryParameter(SEARCH_MOVIE_QUERY, name)
                        .setContentType("application/json");
        Promise<WSResponse> responsePromise = holder.get();
        Promise<Result> resultPromise = responsePromise.map(response -> {
            MovieDBSearchDto movies = Json.fromJson(response.asJson(), MovieDBSearchDto.class);
            return ok(Json.toJson(movies.getResults()));
        });

        return resultPromise;
    }

    public static Result getMovie(Integer id) {
        Promise<MovieDto> movie = getMovieById(id);
        return ok(Json.toJson(movie));
    }

    public static Promise<Result> addMovie() {
        Http.RequestBody body = request().body();
        int id = Integer.parseInt(body.asText());
        Promise<MovieDto> movieDtoPromise = getMovieById(id);
        return movieDtoPromise.map(movieDto -> {
            Movie movie = new Movie(movieDto.getId(), movieDto.getTitle(),
                    movieDto.getPoster_path(), movieDto.getOverview());
            JPA.withTransaction(() -> JPA.em().persist(movie));
            return ok();
        });
    }

    private static Promise<MovieDto> getMovieById(int id) {
        WSRequestHolder holder =
                WS.url("http://api.themoviedb.org/3" + String.format(MOVIE_BY_ID, id))
                        .setQueryParameter(API_KEY, System.getProperty("moviedb.api.key"))
                        .setContentType("application/json");
        Promise<WSResponse> responsePromise = holder.get();
        return responsePromise.map(response -> Json.fromJson(response.asJson(), MovieDto.class));
    }
}
