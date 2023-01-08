package co.istad.istadvdo.api.user;

import co.istad.istadvdo.api.user.web.SavedUserDto;
import co.istad.istadvdo.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMap {

    User fromSavedUserDto(SavedUserDto savedUserDto);

    UserDto toUserDto(User user);

}
