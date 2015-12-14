package util;

import com.fasterxml.jackson.databind.JsonNode;
import dto.MovieDBConfigurationDto;
import dto.MovieDBImagesDto;
import play.Application;
import play.GlobalSettings;
import play.libs.F;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;

public class Global extends GlobalSettings {
    public static String IMAGE_BASE_URL;
    public static final String CONFIGURATION_QUERY = "/configuration";
    public static final String API_KEY = "api_key";

    @Override
    public void onStart(Application application) {
        WSRequestHolder holder =
                WS.url("http://api.themoviedb.org/3" + CONFIGURATION_QUERY)
                        .setQueryParameter(API_KEY,"7a4de0fe5da237bdb52d1168dae8cd14")
                        .setContentType("application/json");
        F.Promise<WSResponse> responsePromise = holder.get();
        F.Promise<MovieDBConfigurationDto> confPromise = responsePromise.map(response -> {
            MovieDBConfigurationDto conf = Json.fromJson(response.asJson(), MovieDBConfigurationDto.class);
            return conf;
        });
        MovieDBImagesDto images = confPromise.get(5000).getImages();
        IMAGE_BASE_URL = images.getBase_url() + images.getPoster_sizes().get(0);
    }
}
