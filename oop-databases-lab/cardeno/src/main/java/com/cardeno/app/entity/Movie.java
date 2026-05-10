package com.cardeno.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String director;
    private Integer durationMinutes;
    private Double rating;
    private boolean isReleased;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieReview> reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setReleased(boolean released) {
        isReleased = released;
    }
}
