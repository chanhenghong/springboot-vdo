package co.istad.istadvdo.api.auth.web;

public record RegisterDto(String email,
                          String familyName,
                          String givenName,
                          String gender,
                          String password,
                          String confirmedPassword) {
}
