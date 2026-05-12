package com.dejuras.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "music")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Artist is required")
    @Column(nullable = false)
    private String artist;

    private String album;

    private String genre;

    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be positive")
    private Integer duration; // in seconds
}
