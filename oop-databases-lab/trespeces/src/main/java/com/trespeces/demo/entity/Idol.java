package com.trespeces.demo.entity;

// user
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "idols")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Group is required")
    @Column(name = "idol_group")
    private String group;

    @NotBlank(message = "Position is required")
    private String position;

    private boolean senior;

    @NotBlank(message = "Company name is required")
    private String company;
}
