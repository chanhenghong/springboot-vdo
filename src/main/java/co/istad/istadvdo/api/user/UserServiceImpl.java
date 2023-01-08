package co.istad.istadvdo.api.user;

import co.istad.istadvdo.api.user.web.SavedUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void saveUser(SavedUserDto savedUserDto) {
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setUsername(savedUserDto.username());
        user.setEmail(savedUserDto.email());
        user.setPassword(savedUserDto.password());
        userMapper.insert(user);
    }

}
