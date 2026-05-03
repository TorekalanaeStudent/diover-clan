package com.cardeno.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

@Entity
public class MovieReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Reviewer name is required")
    private String reviewerName;

    @NotBlank(message = "Content is required")
    private String content;

    @Min(1) @Max(5)
    private int score;

    private boolean recommended;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }
}
