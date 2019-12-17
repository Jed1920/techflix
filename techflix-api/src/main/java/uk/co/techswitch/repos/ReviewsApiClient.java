package uk.co.techswitch.repos;

import uk.co.techswitch.domain.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ReviewsApiClient {
    private final Client client;

    public ReviewsApiClient(Client client) {
        this.client = client;
    }

    public ReviewDetails getFilmReviews(Long imdbId) {
        return client
                .target("http://localhost:3002/reviews/" + imdbId)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<>() {});
    }
}
