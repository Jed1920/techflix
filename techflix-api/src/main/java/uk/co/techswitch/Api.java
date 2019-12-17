package uk.co.techswitch;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.client.JerseyClientBuilder;
import uk.co.techswitch.controllers.FilmsController;
import uk.co.techswitch.controllers.PeopleController;
import uk.co.techswitch.domain.CacheReviews;
import uk.co.techswitch.repos.LibraryApiClient;
import uk.co.techswitch.repos.ReviewsApiClient;
import uk.co.techswitch.services.FilmsService;
import uk.co.techswitch.services.PeopleService;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.client.Client;
import java.util.EnumSet;

public class Api extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new Api().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.getObjectMapper().registerModule(new JavaTimeModule());

        // Repos
        Client client = JerseyClientBuilder.newBuilder().build();
        LibraryApiClient libraryApiClient = new LibraryApiClient(client);
        ReviewsApiClient reviewApiClient = new ReviewsApiClient(client);
        CacheReviews cacheReviews = new CacheReviews();

        // Services
        FilmsService filmsService = new FilmsService(libraryApiClient,reviewApiClient, cacheReviews);
        PeopleService peopleService = new PeopleService(libraryApiClient);

        // Controllers
        FilmsController filmsController = new FilmsController(filmsService);
        PeopleController peopleController = new PeopleController(peopleService);


        environment.jersey().register(filmsController);
        environment.jersey().register(peopleController);


        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
