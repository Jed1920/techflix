package uk.co.techswitch.models;

import uk.co.techswitch.domain.FilmDetails;
import uk.co.techswitch.domain.ReviewDetails;

import java.util.List;
import java.util.stream.Collectors;

public class FilmDetailsModel extends FilmModel {
    private final List<PersonModel> cast;
    private final ReviewDetails reviewDetails;

    public FilmDetailsModel(FilmDetails film, ReviewDetails reviewDetails) {
        super(film);
        cast = film.getCast().stream().map(PersonModel::new).collect(Collectors.toList());
        this.reviewDetails = reviewDetails;
    }

    public List<PersonModel> getCast() {
        return cast;
    }

    public ReviewDetails getReviewDetails() {
        return reviewDetails;
    }
}
