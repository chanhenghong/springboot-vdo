package co.istad.istadvdo.api.user.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDto(Integer id,
        String uuid,
        String username,
        String email,
        String familyName,
        String givenName,
        LocalDate dob,
        String gender,
        String phone,
        String profile,
        String biography,
        String password,
        String verifiedToken,
        LocalDateTime tokenExpiry,
        LocalDateTime createdAt,
        Boolean status) {
}
