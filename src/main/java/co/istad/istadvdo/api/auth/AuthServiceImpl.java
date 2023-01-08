package co.istad.istadvdo.api.auth;

import co.istad.istadvdo.api.auth.web.AuthDto;
import co.istad.istadvdo.api.auth.web.RegisterDto;
import co.istad.istadvdo.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;

    @Override
    public AuthDto register(RegisterDto registerDto) {

        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setEmail(registerDto.email());
        user.setFamilyName(registerDto.familyName());
        user.setGivenName(registerDto.givenName());
        user.setGender(registerDto.gender());
        user.setPassword(registerDto.password());

        authMapper.register(user);

        AuthDto authDto = new AuthDto(
                user.getEmail(),
                user.getFamilyName(),
                user.getGivenName(),
                user.getGender()
        );

        return authDto;
    }

}
