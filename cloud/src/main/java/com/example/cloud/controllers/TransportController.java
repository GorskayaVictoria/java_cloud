package com.example.cloud.controllers;

import com.example.cloud.dto.TransportDto;
import com.example.cloud.dto.TransportResult;

import com.example.cloud.dto.UserDto;
import com.example.cloud.models.Transport;
import com.example.cloud.models.Type;
import com.example.cloud.service.TransportService;
import com.example.cloud.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
@Slf4j
public class TransportController {

    @Autowired
    private TransportService transportService;

    @Autowired
    private UsersService userService;

    @GetMapping("/transport")
    public List<TransportDto> getTransportsPage(@RequestParam(value = "id", required =false)Long id) {
        log.info("get request");
        if (id != null){
            return Arrays.asList(transportService.getConcreteTransport(id));
        }
        return transportService.getTransports();

    }

    @GetMapping("/user")
    public List<UserDto> getUsersPage(@RequestParam(value = "id", required =false)Long id) {
        log.info("get request");
        if (id != null){
            return Arrays.asList(userService.getConcreteUser(id));
        }
        return userService.getUsers();

    }


}
