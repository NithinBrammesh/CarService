package com.example.car.CarService.mapper;

import com.example.car.CarService.dto.UserDetailsDto;
import com.example.car.CarService.model.UserDetails;

public class UserDetailsMapper {

    public static UserDetails mapToUserDetails(UserDetailsDto userDetailsDto){
        UserDetails userDetails = new UserDetails(
                userDetailsDto.getUserId()
        );
        return userDetails;
    }

    public static UserDetailsDto mapToUserDetailDto(UserDetails userDetails){
        UserDetailsDto userDetailsDto  = new UserDetailsDto(
                userDetails.getUserId(),
                userDetails.getName(),
                userDetails.getPhoneNo(),
                userDetails.getEmail(),
                userDetails.getPassword()
        );
        return userDetailsDto;
    }
}
