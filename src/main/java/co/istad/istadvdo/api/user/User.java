package co.istad.istadvdo.api.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    // a user has many roles
    List<Role> roles;
}
