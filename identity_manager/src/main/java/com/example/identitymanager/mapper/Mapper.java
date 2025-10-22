package com.example.identitymanager.mapper;

import com.example.identitymanager.dto.UserRequestDto;
import com.example.identitymanager.dto.UserResponseDto;
import com.example.identitymanager.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserResponseDto toUserResponseDto(Users userEntity) {
       return UserResponseDto.builder()
               .firstName(userEntity.getFirstName())
               .lastName(userEntity.getLastName())
               .middleName(userEntity.getMiddleName())
               .age(userEntity.getAge())
               .dob(userEntity.getDob())
               .gender(userEntity.getGender())
               .email(userEntity.getEmail())
               .build();
    }


    public Users toUserEntity(UserRequestDto userRequestDto) {
        return Users.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .middleName(userRequestDto.getMiddleName())
                .age(userRequestDto.getAge())
                .dob(userRequestDto.getDob())
                .gender(userRequestDto.getGender())
                .email(userRequestDto.getEmail())
                .build();
    }
}
