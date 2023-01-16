package co.istad.istadvdo.api.user.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record UserDto(
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
        LocalDateTime createdAt,
        Boolean status,
        List<RoleDto> roles) {
}
