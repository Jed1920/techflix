package uk.co.techswitch.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheReviews {
    private class CacheObject {
        private Long timestamp;
        private ReviewDetails reviewDetails;

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public ReviewDetails getReviewDetails() {
            return reviewDetails;
        }

        public void setReviewDetails(ReviewDetails reviewDetails) {
            this.reviewDetails = reviewDetails;
        }
    }


    private Map<Long, CacheObject> cachedReviews;

    public CacheReviews(){
        this.cachedReviews = new HashMap<>();
    }

    public void updateCache(){
        for(Map.Entry<Long, CacheObject> cache : cachedReviews.entrySet()){
            long currentTime = System.currentTimeMillis();
            if(currentTime > cache.getValue().timestamp+300000){
                cachedReviews.remove(cache.getKey());
            }
        }
    }

    private void addToCache(ReviewDetails reviewDetails){
        CacheObject cacheObject = new CacheObject();
        cacheObject.setReviewDetails(reviewDetails);
        cacheObject.setTimestamp(System.currentTimeMillis());
        cachedReviews.put(reviewDetails.getId(),cacheObject);
    }

    public boolean checkCache(Long reviewId){
        return cachedReviews.containsKey(reviewId);
    }

    public ReviewDetails getReviewFromCache(Long reviewId) {
        return cachedReviews.get(reviewId).getReviewDetails();
    }

    public Map<Long, CacheObject> getCachedReviews() {
        return cachedReviews;
    }

    public void setCachedReviews(Map<Long, CacheObject> cachedReviews) {
        this.cachedReviews = cachedReviews;
    }
}
