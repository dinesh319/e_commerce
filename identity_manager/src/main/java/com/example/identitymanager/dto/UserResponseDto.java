package com.example.identitymanager.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto {

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer age;

    private Date dob;

    private String gender;

    private String email;
}
