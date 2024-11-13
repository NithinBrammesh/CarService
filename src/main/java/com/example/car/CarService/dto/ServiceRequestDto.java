package com.example.car.CarService.dto;

import com.example.car.CarService.model.Car;
import com.example.car.CarService.model.SavedAddress;
import com.example.car.CarService.model.UserDetails;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestDto {

    private Integer requestId;

    private String date;

    private Car car;

    private UserDetails userDetails;

    private SavedAddress savedAddress;
}
