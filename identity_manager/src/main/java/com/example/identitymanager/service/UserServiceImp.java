package com.example.identitymanager.service;

import com.example.identitymanager.dto.UserRequestDto;
import com.example.identitymanager.dto.UserResponseDto;
import com.example.identitymanager.entity.Users;
import com.example.identitymanager.exceptions.UserNotFoundException;
import com.example.identitymanager.mapper.Mapper;
import com.example.identitymanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public UserResponseDto getUserById(Long id) {
        Users userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id "+ id + " does not exists"));
        return mapper.toUserResponseDto(userEntity);

    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<Users> userEntities = userRepository.findAll();
        return userEntities.stream().map(mapper::toUserResponseDto).toList();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        Users entity = mapper.toUserEntity(userRequestDto);
        return mapper.toUserResponseDto(userRepository.save(entity));
    }

    @Override
    public void deleteUserById(Long id) {
        Users userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id "+ id + " does not exists"));
        userRepository.delete(userEntity);
    }
}
