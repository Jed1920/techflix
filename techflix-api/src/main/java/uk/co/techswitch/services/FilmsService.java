package uk.co.techswitch.services;

import uk.co.techswitch.domain.CacheReviews;
import uk.co.techswitch.domain.Film;
import uk.co.techswitch.domain.FilmDetails;
import uk.co.techswitch.domain.ReviewDetails;
import uk.co.techswitch.models.FilmDetailsModel;
import uk.co.techswitch.models.FilmModel;
import uk.co.techswitch.repos.LibraryApiClient;
import uk.co.techswitch.repos.ReviewsApiClient;

import java.util.List;
import java.util.stream.Collectors;

public class FilmsService {
    private static final int FILMS_PER_PAGE = 20;

    private final LibraryApiClient libraryApiClient;
    private final ReviewsApiClient reviewsApiClient;
    private final CacheReviews cacheReviews;

    public FilmsService(LibraryApiClient libraryApiClient, ReviewsApiClient reviewsApiClient, CacheReviews cacheReviews) {
        this.libraryApiClient = libraryApiClient;
        this.reviewsApiClient = reviewsApiClient;
        this.cacheReviews = cacheReviews;
    }

    public List<FilmModel> getFilms(int page) {
        int offset = FILMS_PER_PAGE * (page - 1);
        return libraryApiClient
                .getAllFilms(FILMS_PER_PAGE, offset)
                .stream()
                .map(FilmModel::new)
                .collect(Collectors.toList());
    }

    public FilmDetailsModel getFilm(String id) {
        FilmDetails film = libraryApiClient.getFilm(id);
        cacheReviews.updateCache();
        ReviewDetails review = new ReviewDetails();
        if(cacheReviews.checkCache(film.getTMDbId())){
            review = cacheReviews.getReviewFromCache(film.getTMDbId());
        } else {
            review = reviewsApiClient.getFilmReviews(film.getTMDbId());
        }

        return new FilmDetailsModel(film, review);
    }
}
