package com.dejuras.app.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "playlist")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Artist name is required")
    private String artist;

    @NotBlank(message = "Song is required")
    private String song;

    @Positive(message = "Duration must be greater than 0")
    private int duration;
}