package co.istad.istadvdo.api.user.web;

import co.istad.istadvdo.api.base.Rest;
import co.istad.istadvdo.api.user.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;

    @PostMapping
    Rest<?> saveUser(@Valid @RequestBody SavedUserDto savedUserDto){

        var userDto = userService.saveUser(savedUserDto);

        return Rest.builder()
                .status(true)
                .message("You have created an user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDto)
                .build();
    }
    @GetMapping
    Rest<?> findUsers(@RequestParam(required = false, defaultValue = "1") int pageNum,
                      @RequestParam(required = false, defaultValue = "20") int pageSize){
        PageInfo<UserDto> userDtoPageInfo = userService.findUsers(pageNum, pageSize);

        return  Rest.builder()
                .status(true)
                .message("You have retrieved users successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDtoPageInfo)
                .build();

    }
    @GetMapping("/{uuid}")
    Rest<?> findUserByUuid(@PathVariable("uuid") String uuid){
        UserDto userDto = userService.findUserByUuid(uuid);

        return Rest.builder()
                .status(true)
                .message("You have retrieved an user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDto)
                .build();
    }

    @DeleteMapping("/{uuid}")
    Rest<?> deleteUserByUuid(@PathVariable("uuid") String uuid){
        userService.deleteByUuid(uuid);

        return Rest.builder()
                .status(true)
                .message("You have deleted an user successfully")
                .code(HttpStatus.NO_CONTENT.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

    }

}
