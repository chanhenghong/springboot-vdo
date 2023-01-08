package co.istad.istadvdo.api.user;

import co.istad.istadvdo.api.user.web.SavedUserDto;
import co.istad.istadvdo.api.user.web.UpdateUserDto;
import co.istad.istadvdo.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserMap userMap;

    @Override
    public UserDto saveUser(SavedUserDto savedUserDto) {
        User user = userMap.fromSavedUserDto(savedUserDto);

        log.info("User = {}", user);

        //userMapper.insert(user);
        return null;
    }

    @Override
    public List<UserDto> findUsers() {
        return null;
    }

    @Override
    public UserDto findUserByUuid(String uuid) {
        return null;
    }

    @Override
    public void deleteByUuid(String uuid) {

    }

    @Override
    public UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto) {
        return null;
    }

}
