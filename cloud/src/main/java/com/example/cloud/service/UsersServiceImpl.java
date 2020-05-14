package com.example.cloud.service;

import com.example.cloud.dto.UserDto;
import com.example.cloud.models.User;
import com.example.cloud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.example.cloud.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;



    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }



    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByNameContainsIgnoreCase(name));
    }


    @Override
    public List<User> searchUsers(String name) {
        return usersRepository.searchUsers(name);
    }
}
