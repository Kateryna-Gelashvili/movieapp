package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.FavoritesList;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private String username;
    private int id;
    private Set<FavoritesList> lists;

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<FavoritesList> getLists() {
        return lists;
    }

    public void setLists(Set<FavoritesList> lists) {
        this.lists = lists;
    }
}
