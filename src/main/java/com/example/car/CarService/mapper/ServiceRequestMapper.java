package com.example.car.CarService.mapper;

import com.example.car.CarService.dto.ServiceRequestDto;
import com.example.car.CarService.model.ServiceRequest;

public class ServiceRequestMapper {

    public static ServiceRequest mapToServiceRequest(ServiceRequestDto serviceRequestDto) {
        ServiceRequest serviceRequest = new ServiceRequest(
                serviceRequestDto.getRequestId(),
                serviceRequestDto.getDate(),
                serviceRequestDto.getCar(),
                serviceRequestDto.getUserDetails(),
                serviceRequestDto.getSavedAddress()
        );
        return serviceRequest;
    }

    public static ServiceRequestDto mapToServiceRequestDto(ServiceRequest serviceRequest) {
        ServiceRequestDto serviceRequestDto = new ServiceRequestDto(
                serviceRequest.getRequestId(),
                serviceRequest.getDate(),
                serviceRequest.getCar(),
                serviceRequest.getUserDetails(),
                serviceRequest.getSavedAddress()
        );
        return serviceRequestDto;
    }
}
