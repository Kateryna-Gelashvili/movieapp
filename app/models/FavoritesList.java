package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "favorites_list")
public class FavoritesList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_favorites_list",
            joinColumns = @JoinColumn(name = "favorites_list", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie", referencedColumnName = "id"))
    private Set<Movie> movies;

    public FavoritesList() {
    }

    public FavoritesList(Integer id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
