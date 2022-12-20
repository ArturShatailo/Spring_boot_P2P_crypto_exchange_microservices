package com.exchange.clients_management.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterDTO {

    @NotNull(message = "Name may not be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    public String name;

    @NotNull(message = "Surname may not be null")
    @Size(min = 2, max = 32, message = "Surname must be between 2 and 32 characters long")
    public String surname;

    @NotNull(message = "Middle name (patronymic) may not be null")
    @Size(min = 2, max = 32, message = "Middle name must be between 2 and 32 characters long")
    public String middle_name;

    @NotNull(message = "Nickname name (patronymic) may not be null")
    @Size(min = 2, max = 32, message = "Nickname must be between 2 and 32 characters long")
    public String nickname;

    @Email
    @NotNull(message = "Email may not be null")
    public String email;

    @NotNull(message = "Phone number may not be null")
    @Size(min = 11, max = 16, message = "Phone number must be from 11 to 16 characters long")
    public String phone_number;

    @NotNull(message = "Password may not be null")
    @Size(min = 8, message = "Password must be from 8 characters long")
    public String password;

    public Date registration_date = new Date();

}
