package co.istad.istadvdo.api.user;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String uuid;
    private String username;
    private String email;
    private String familyName;
    private String givenName;
    private LocalDate dob;
    private String gender;
    private String phone;
    private String profile;
    private String biography;
    private String password;
    private String verifiedToken;
    private LocalDateTime tokenExpiry;
    private LocalDateTime createdAt;
    private Boolean status;
}
