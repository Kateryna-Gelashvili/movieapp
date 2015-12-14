package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDBImagesDto {
    private String base_url;
    private ArrayList<String> poster_sizes;

    public MovieDBImagesDto() {
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public ArrayList<String> getPoster_sizes() {
        return poster_sizes;
    }

    public void setPoster_sizes(ArrayList<String> poster_sizes) {
        this.poster_sizes = poster_sizes;
    }
}
