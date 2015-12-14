package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "overview")
    private String overview;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_favorites_list",
            joinColumns = @JoinColumn(name = "movie", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "favorites_list", referencedColumnName = "id"))
    private Set<FavoritesList> lists;

    public Movie() {
    }

    public Movie(String id, String name, String posterPath, String overview) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Set<FavoritesList> getLists() {
        return lists;
    }

    public void setLists(Set<FavoritesList> lists) {
        this.lists = lists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
