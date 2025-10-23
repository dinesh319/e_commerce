package com.dinesh.identitymanager.controller;

import com.dinesh.identitymanager.dto.UserRequestDto;
import com.dinesh.identitymanager.dto.UserResponseDto;
import com.dinesh.identitymanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable(name = "id") Long id){
        UserResponseDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto createdUser = userService.createUser(userRequestDto);
        return new ResponseEntity<>(createdUser , HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable(name = "id") Long id ,@RequestBody Map<String , Object> data){
        UserResponseDto updatedUser = userService.updateUser(data ,id);
        return new ResponseEntity<>(updatedUser , HttpStatus.OK);
    }



}
//Go to File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors