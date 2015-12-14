package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDBSearchDto {
    private ArrayList<MovieDto> results;

    public MovieDBSearchDto() {
    }

    public ArrayList<MovieDto> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieDto> results) {
        this.results = results;
    }
}
