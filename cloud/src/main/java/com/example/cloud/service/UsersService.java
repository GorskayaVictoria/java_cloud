package com.example.cloud.service;



import com.example.cloud.dto.UserDto;
import com.example.cloud.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);

    List<User> searchUsers(String name);

}
