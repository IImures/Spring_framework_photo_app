package com.imures.ws.photo_app.ui.controller;

import com.imures.ws.photo_app.service.imp.UserServiceImpl;
import com.imures.ws.photo_app.shared.dto.UserDto;
import com.imures.ws.photo_app.ui.controller.model.request.UserDetailsModel;
import com.imures.ws.photo_app.ui.controller.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users") //http://localhost:8080/users
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId)
    {
        return "get called " + userId;
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsModel userDetails)
    {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, returnValue);
        return returnValue;
    }

    @PutMapping
    public String changeUser()
    {
        return "put called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete called";
    }
}
