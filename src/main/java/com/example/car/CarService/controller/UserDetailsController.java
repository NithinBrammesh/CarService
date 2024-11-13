package com.example.car.CarService.controller;

import com.example.car.CarService.SavedAddressService;
import com.example.car.CarService.UserDetailsService;
import com.example.car.CarService.dto.UserDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {
    private UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    ResponseEntity<UserDetailsDto> AddUserDetails(@RequestBody UserDetailsDto userDetailsDto) {
        return new ResponseEntity<>(userDetailsService.createUserDetails(userDetailsDto), HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity<List<UserDetailsDto>> getAllUserDetails() {
        return ResponseEntity.ok(userDetailsService.getAllUserDetails());
    }

    @GetMapping("/{User_id}")
    public ResponseEntity<UserDetailsDto> getUserDetailsById(@PathVariable("User_id") int Id) {
        UserDetailsDto userDetailsDto = userDetailsService.getUserDetailsById(Id);
        return ResponseEntity.ok(userDetailsDto);
    }

    @PutMapping("/{User_id}")
    public ResponseEntity<UserDetailsDto> updateUserDetails(@PathVariable int Id, @RequestBody UserDetailsDto userDetailsDto) {
        UserDetailsDto updateDetailsDto = userDetailsService.updateUserDetail(Id, userDetailsDto);
        return ResponseEntity.ok(updateDetailsDto);
    }

    @DeleteMapping("/{User_id}")
    public ResponseEntity<UserDetailsDto> deleteUserDetailsById(@PathVariable("User_id") int userId) {
        UserDetailsDto deleteUserDetailsById = userDetailsService.deleteUserDetailsById(userId);
        return ResponseEntity.ok(deleteUserDetailsById);
    }
}

