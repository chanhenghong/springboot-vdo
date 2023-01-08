package co.istad.istadvdo.api.auth;

import co.istad.istadvdo.api.auth.web.AuthDto;
import co.istad.istadvdo.api.auth.web.RegisterDto;

public interface AuthService {

    AuthDto register(RegisterDto registerDto);

}
