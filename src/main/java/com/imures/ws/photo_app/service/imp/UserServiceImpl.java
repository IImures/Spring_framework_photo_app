package com.imures.ws.photo_app.service.imp;

import com.imures.ws.photo_app.io.entity.UserEntity;
import com.imures.ws.photo_app.io.repository.UserRepository;
import com.imures.ws.photo_app.service.UserService;
import com.imures.ws.photo_app.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setEncryptPassword("test");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return null;
    }
}
