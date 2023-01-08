package co.istad.istadvdo.api.auth.web;

import co.istad.istadvdo.api.auth.AuthServiceImpl;
import co.istad.istadvdo.api.base.Rest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthServiceImpl authService;

    @PostMapping("register")
    Rest<AuthDto> register(@RequestBody RegisterDto registerDto) {

        log.info("Register DTO = {}", registerDto);

        var authDto = authService.register(registerDto);

        var rest = new Rest<>(
                "Registered succesfully",
                true,
                200,
                new Timestamp(System.currentTimeMillis()),
                authDto
        );

        return rest;
    }

}
