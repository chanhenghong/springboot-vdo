package co.istad.istadvdo.api.user;

import co.istad.istadvdo.api.user.web.RoleDto;
import co.istad.istadvdo.api.user.web.SavedUserDto;
import co.istad.istadvdo.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMap {

    User fromSavedUserDto(SavedUserDto savedUserDto);

    UserDto toUserDto(User user);

    PageInfo<UserDto> toUserDtoPageInfo(PageInfo<User> userPageInfo);

    RoleDto toRoleDto(Role role);

}
