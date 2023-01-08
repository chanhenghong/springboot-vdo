package co.istad.istadvdo.api.auth.web;

public record AuthDto(String email,
                      String familyName,
                      String givenName,
                      String gender) {
}
