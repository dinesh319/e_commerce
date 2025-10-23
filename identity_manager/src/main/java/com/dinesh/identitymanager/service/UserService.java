package com.dinesh.identitymanager.service;

import com.dinesh.identitymanager.dto.UserRequestDto;
import com.dinesh.identitymanager.dto.UserResponseDto;

import java.util.List;
import java.util.Map;

public interface UserService {
    
    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();
    
    UserResponseDto createUser(UserRequestDto userRequestDto);

    void deleteUserById(Long id);

    UserResponseDto updateUser(Map<String, Object> data, Long id);
}
