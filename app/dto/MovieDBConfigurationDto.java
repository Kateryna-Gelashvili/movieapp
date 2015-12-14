package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDBConfigurationDto {
    private MovieDBImagesDto images;

    public MovieDBConfigurationDto() {
    }

    public MovieDBImagesDto getImages() {
        return images;
    }

    public void setImages(MovieDBImagesDto images) {
        this.images = images;
    }
}
