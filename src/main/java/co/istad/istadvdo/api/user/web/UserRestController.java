package co.istad.istadvdo.api.user.web;

import co.istad.istadvdo.api.base.Rest;
import co.istad.istadvdo.api.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;

    @PostMapping
    Rest<UserDto> saveUser(@RequestBody SavedUserDto savedUserDto) {
        UserDto userDto = userService.saveUser(savedUserDto);
        return null;
    }

}
