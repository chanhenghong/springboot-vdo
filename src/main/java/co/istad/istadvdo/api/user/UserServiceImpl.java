package co.istad.istadvdo.api.user;

import co.istad.istadvdo.api.user.web.SavedUserDto;
import co.istad.istadvdo.api.user.web.UpdateUserDto;
import co.istad.istadvdo.api.user.web.UserDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
        user.setUuid(UUID.randomUUID().toString());

        userMapper.insert(user);

        log.info("User = {}", user);


        Optional<User> userOp = userMapper.selectById(user.getId());

        User latestUser = userOp.orElseThrow(()->
                new RuntimeException("User is not found"));
        return userMap.toUserDto(latestUser);
    }

    @Override
    public PageInfo<UserDto> findUsers(int pageNum, int pageSize){
        PageInfo<User> userPageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(()-> userMapper.select(true));

                return userMap.toUserDtoPageInfo(userPageInfo);

    }

    @Override
    public UserDto findUserByUuid(String uuid) {

        User user = userMapper.selectByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with this UUID is not exist in the db..!",
                        new Throwable("Something went wrong!")));

        return userMap.toUserDto(user);
    }

    @Override
    public void deleteByUuid(String uuid) {

        userMapper.selectByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with this UUID is not exist in the db..!",
                        new Throwable("Something went wrong!")));
        userMapper.deleteByUuid(uuid);
    }

    @Override
    public UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto) {
        return null;
    }

}
