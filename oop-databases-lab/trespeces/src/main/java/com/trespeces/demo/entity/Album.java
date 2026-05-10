package com.trespeces.demo.entity;

// product
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Artist name is required")
    private String artist;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Label is required")
    private String label;


    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;
}
