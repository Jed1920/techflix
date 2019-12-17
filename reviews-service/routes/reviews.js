const express = require('express');
const reviewsService = require('../services/reviewsService');
const router = express.Router();

router.get('/reviews/:id', function(req, res, next) {
    setTimeout(() => {
        reviewsService.getReviewSummary(req.params.id)
            .then(summary => res.json(summary));
    }, 8000);
});

module.exports = router;