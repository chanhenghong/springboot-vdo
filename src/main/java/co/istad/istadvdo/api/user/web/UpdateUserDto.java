package co.istad.istadvdo.api.user.web;

import java.time.LocalDate;

public record UpdateUserDto(String familyName,
                            String givenName,
                            LocalDate dob,
                            String gender,
                            String phone,
                            String biography) {
}
