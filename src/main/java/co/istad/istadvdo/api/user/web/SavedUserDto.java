package co.istad.istadvdo.api.user.web;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SavedUserDto(

        @NotBlank(message = "You have to fill username..!")
        String username,
        @NotBlank(message = "You have to fill familyName..!")
        String familyName,
        @NotBlank(message = "You have to fill givenName..!")
        String givenName,
        String gender,
        @NotBlank(message = "You have to fill phone number..!")
        String phone,
        String biography,
        Boolean status) {
}
