package uk.co.techswitch.domain;

import java.util.List;

public class ReviewDetails {
    private Long id;
    private Float rating;
    private Integer ratingsCount;
    private List<Review> reviews;

    public ReviewDetails(){}

    public ReviewDetails(Long id, Float rating, Integer ratingsCount, List<Review> reviews) {
        this.id = id;
        this.rating = rating;
        this.ratingsCount = ratingsCount;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public Float getRating() {
        return rating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
