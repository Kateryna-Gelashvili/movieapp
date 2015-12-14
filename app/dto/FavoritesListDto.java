package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Movie;
import models.User;

import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoritesListDto {
    private int id;
    private String name;
    private User user;
    private Set<Movie> movies;

    public FavoritesListDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
