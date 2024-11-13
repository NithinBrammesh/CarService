package com.example.car.CarService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDetailsDto {
    private int UserId;

    private String Name;

    private Long PhoneNo;

    private String Email;

    private String Password;
}
