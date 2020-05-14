package com.example.cloud.dto;

import com.example.cloud.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
//    private Integer age;
    private String name;
    private String email;
    private String state;


    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
//                .age(user.getAge())
                .name(user.getName())
                .email(user.getEmail())
                .state(user.getState().name())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }


}
