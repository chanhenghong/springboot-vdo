package co.istad.istadvdo.api.user;

import co.istad.istadvdo.api.user.web.SavedUserDto;
import co.istad.istadvdo.api.user.web.UpdateUserDto;
import co.istad.istadvdo.api.user.web.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(SavedUserDto savedUserDto);

    List<UserDto> findUsers();

    UserDto findUserByUuid(String uuid);

    void deleteByUuid(String uuid);

    UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto);

}
