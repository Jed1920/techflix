const fetch = require("node-fetch");

const apiKey = process.env.API_KEY.trim();

async function getReviewsForFilm(filmId) {
    const url = `https://api.themoviedb.org/3/movie/${filmId}/reviews?api_key=${apiKey}&language=en-US`
    const response = await fetch(url);
    const json = await response.json();
    return {id: json.id, reviews: json.results};
}

async function getRatingsForFilm(filmId) {
    const response = await fetch(`https://api.themoviedb.org/3/movie/${filmId}?api_key=${apiKey}&language=en-US`);
    const json = await response.json();
    return { voteCount: json.vote_count, voteAverage: json.vote_average };
}

async function getReviewSummary(filmId) {
    const [reviews, ratings] = await Promise.all([ getReviewsForFilm(filmId), getRatingsForFilm(filmId) ]);
    return {
        id: reviews.id,
        rating: ratings.voteAverage,
        ratingsCount: ratings.voteCount,
        reviews: reviews.reviews,
    }
}

module.exports = {
    'getReviewSummary': getReviewSummary,
};