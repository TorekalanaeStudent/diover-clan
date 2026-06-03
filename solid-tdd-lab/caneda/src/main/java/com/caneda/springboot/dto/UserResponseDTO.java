package com.caneda.springboot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// SOLID: SRP - only holds response data, no logic
// OOP: Immutability - fields are final, no setters
// YAGNI: only contains what the client actually needs
public final class UserResponseDTO {

    // OOP: Immutability - all fields are final, state cannot change
    private final Long id;
    private final String userName;
    private final String userEmail;
    private final int userAge;
    private final float userWalletAmount;

    // @JsonCreator allows Jackson to deserialize this immutable class
    @JsonCreator
    public UserResponseDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("userName") String userName,
            @JsonProperty("userEmail") String userEmail,
            @JsonProperty("userAge") int userAge,
            @JsonProperty("userWalletAmount") float userWalletAmount) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAge = userAge;
        this.userWalletAmount = userWalletAmount;
    }

    // OOP: Immutability - only getters, no setters
    public Long getId() { return id; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public int getUserAge() { return userAge; }
    public float getUserWalletAmount() { return userWalletAmount; }
}