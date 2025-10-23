package com.dinesh.identitymanager.service;

import com.dinesh.identitymanager.dto.UserRequestDto;
import com.dinesh.identitymanager.dto.UserResponseDto;
import com.dinesh.identitymanager.entity.Users;
import com.dinesh.identitymanager.exceptions.UserNotFoundException;
import com.dinesh.identitymanager.mapper.Mapper;
import com.dinesh.identitymanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public UserResponseDto updateUser(Map<String, Object> data, Long id) {
        Users userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));

        data.forEach((key, value) -> {
            switch (key) {
                case "firstName" -> userEntity.setFirstName((String) value);
                case "lastName" -> userEntity.setLastName((String) value);
                case "middleName" -> userEntity.setMiddleName((String) value);
                case "age" -> userEntity.setAge((Integer) value);
                case "dob" -> userEntity.setDob((Date) value);
                case "gender" -> userEntity.setGender((String) value);
                case "email" -> userEntity.setEmail((String) value);
                default -> throw new IllegalArgumentException("Unknown field: " + key);
            }
        });

        Users updatedUser = userRepository.save(userEntity);
        return mapper.toUserResponseDto(updatedUser);
    }
}
