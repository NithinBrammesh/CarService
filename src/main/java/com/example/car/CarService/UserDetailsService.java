package com.example.car.CarService;

import com.example.car.CarService.dto.UserDetailsDto;
import com.example.car.CarService.model.UserDetails;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserDetailsService {
    UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto);

    List<UserDetailsDto> getAllUserDetails();

    UserDetailsDto getUserDetailsById(int Id);

    UserDetailsDto updateUserDetail(int Id, UserDetailsDto userDetailsDto);

    UserDetailsDto deleteUserDetailsById(int userId);
}
