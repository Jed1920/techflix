package uk.co.techswitch.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

public class Film {
    private String id;
    private String title;
    private String summary;
    private String releaseDate;
    private String bannerImage;
    private String posterImage;
    private String video;
    private String imdbLink;
    private Long tMDbId;

    public Film() { }

    public Film(String id,
                String title,
                String summary,
                String releaseDate,
                String bannerImage,
                String posterImage,
                String video,
                String imdbLink,
                Long tMDbId) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.bannerImage = bannerImage;
        this.posterImage = posterImage;
        this.video = video;
        this.imdbLink = imdbLink;
        this.tMDbId = tMDbId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public String getVideo() {
        return video;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public Long getTMDbId() {
        return tMDbId;
    }
}
