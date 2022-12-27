package com.exchange.clients_management.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotNull(message = "Country cannot not be null")
    @Size(min = 2, max = 32, message = "Country must be between 2 and 32 characters long")
    private String country;

    @NotNull(message = "State cannot not be null")
    @Size(min = 2, max = 32, message = "State must be between 2 and 32 characters long")
    private String state;

    @NotNull(message = "City cannot not be null")
    @Size(min = 2, max = 32, message = "City must be between 2 and 32 characters long")
    private String city;

    @NotNull(message = "Details cannot not be null")
    @Size(min = 8, max = 80, message = "Details must be between 8 and 80 characters long")
    private String details;

    @NotNull(message = "Postal code cannot not be null")
    @Size(min = 4, max = 8, message = "Postal code must be between 4 and 8 characters long")
    private String postal_code;

}
