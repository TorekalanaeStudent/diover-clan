package com.cardeno.app.service;

import com.cardeno.app.entity.MovieReview;
import com.cardeno.app.exception.ResourceNotFoundException;
import com.cardeno.app.repository.MovieReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Cardeño, Faye L.
 * @flcardeno
 *
 * - Reflection -
 * 1. What changed from previous lab?
 *  - The biggest change was moving from a temporary database (H2) to a permanent one (PostgreSQL).
 *  In the previous lab, the data disappeared every time I restart the h2 console; now, it is saved permanently
 *  on your computer.
 *
 * 2. Why database is better?
 *  - A database like PostgreSQL is better because it saves data permanently even after the app is closed.
 * It also allows me to use tools like pgAdmin 4 to manage and see my data outside of IntelliJ.
 *
 * 3. How JPA helped?
 *  - JPA made it easier by handling database operations for me, so I didn’t need to write SQL manually.
 *
 * 4. What changed when switching DB?
 *  - I changed the config (H2 to PostgreSQL), while the code stayed the same because JPA handled it.
 *  - I also had to update the database URL and login in application.properties. Then, add the PostgreSQL driver
 *  to my build.gradle so the app could connect to the new database.
 **/

@Service
public class MovieReviewService {

    @Autowired
    private MovieReviewRepository reviewRepository;

    public List<MovieReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    public MovieReview saveReview(MovieReview review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
    public MovieReview updateReview(Long id, MovieReview reviewDetails) {
        MovieReview review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));

        review.setReviewerName(reviewDetails.getReviewerName());
        review.setContent(reviewDetails.getContent());
        review.setScore(reviewDetails.getScore());
        review.setRecommended(reviewDetails.isRecommended());

        return reviewRepository.save(review);
    }
}