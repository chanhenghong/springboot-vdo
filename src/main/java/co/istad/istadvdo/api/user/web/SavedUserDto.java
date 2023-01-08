package co.istad.istadvdo.api.user.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SavedUserDto(
        String username,
        String familyName,
        String givenName,
        String gender,
        String phone,
        String biography,
        Boolean status) {
}
