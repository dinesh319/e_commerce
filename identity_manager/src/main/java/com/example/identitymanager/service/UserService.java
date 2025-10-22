package com.example.identitymanager.service;

import com.example.identitymanager.dto.UserRequestDto;
import com.example.identitymanager.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    
    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();
    
    UserResponseDto createUser(UserRequestDto userRequestDto);

    void deleteUserById(Long id);
}
