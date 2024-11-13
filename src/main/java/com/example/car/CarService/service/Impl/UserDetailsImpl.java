package com.example.car.CarService.service.Impl;

import com.example.car.CarService.UserDetailsService;
import com.example.car.CarService.dto.CarDto;
import com.example.car.CarService.dto.UserDetailsDto;
import com.example.car.CarService.mapper.CarMapper;
import com.example.car.CarService.mapper.UserDetailsMapper;
import com.example.car.CarService.model.Car;
import com.example.car.CarService.model.UserDetails;
import com.example.car.CarService.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    public UserDetailsImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto){
        UserDetails userDetails = UserDetailsMapper.mapToUserDetails(userDetailsDto);
        UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
        return UserDetailsMapper.mapToUserDetailDto(savedUserDetails);
    }

    @Override
    public List<UserDetailsDto> getAllUserDetails() {
        List<UserDetails> userDetails = userDetailsRepository.findAll();
        return userDetails.stream()
                .map(UserDetailsMapper::mapToUserDetailDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailsDto getUserDetailsById(int Id){
        UserDetails userDetails = userDetailsRepository.findById(Id).orElseThrow(() -> new RuntimeException("UserDetails does not exist"));
        return UserDetailsMapper.mapToUserDetailDto(userDetails);
    }

    @Override
    public UserDetailsDto updateUserDetail(int Id, UserDetailsDto userDetailsDto){
        UserDetails existingUserDetails = userDetailsRepository.findById(Id).orElseThrow(()-> new RuntimeException("UserDetails does not existing"));

        if(userDetailsDto.getPhoneNo() !=null){
            existingUserDetails.setPhoneNo(userDetailsDto.getPhoneNo());
        }
        if(userDetailsDto.getEmail()!=null){
            existingUserDetails.setEmail(userDetailsDto.getEmail());
        }
        if(userDetailsDto.getPassword() !=null){
            existingUserDetails.setPassword(userDetailsDto.getPassword());
        }

        existingUserDetails.setName(userDetailsDto.getName());

        UserDetailsDto updateUserDetail = userDetailsRepository.save(existingUserDetails);

        return new UserDetailsDto(updateUserDetail.getUserId(), updateUserDetail.getName(), updateUserDetail.getPhoneNo(), updateUserDetail.getEmail(), updateUserDetail.getPassword());
    }

    @Override
    public UserDetailsDto deleteUserDetailsById(int userId) {

        UserDetails userDetails = userDetailsRepository.findById(userId).orElseThrow(() -> new RuntimeException("Car does not exist"));

        UserDetailsDto userDetailsDto = UserDetailsMapper.mapToUserDetailDto(userDetails);


       userDetailsRepository.deleteById(userId);

       return userDetailsDto;

    }
}
