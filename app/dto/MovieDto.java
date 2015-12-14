package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import util.Global;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
    private String id;
    private String overview;
    private String title;
    private String poster_path;

    public MovieDto() {
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = Global.IMAGE_BASE_URL + poster_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
