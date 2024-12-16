package com.example.car.CarService.service.Impl;

import com.example.car.CarService.ServiceRequestService;
import com.example.car.CarService.dto.SavedAddressDto;
import com.example.car.CarService.dto.ServiceRequestDto;

import com.example.car.CarService.mapper.ServiceRequestMapper;

import com.example.car.CarService.model.Car;
import com.example.car.CarService.model.ServiceRequest;

import com.example.car.CarService.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{

    @Autowired
    ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestServiceImpl(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

//    public List<ServiceRequest> getServiceRequestsByCar(Car car) {
//        return serviceRequestRepository.findByCar(car);
//    }

    public List<ServiceRequestDto> getAllServiceRequest() {
        return serviceRequestRepository.findAll()
                .stream()
                .map(ServiceRequestMapper::mapToServiceRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceRequestDto createServiceRequest(ServiceRequestDto serviceRequestDto){
        ServiceRequest serviceRequest = ServiceRequestMapper.mapToServiceRequest(serviceRequestDto);
        ServiceRequest savedServiceRequest = serviceRequestRepository.save(serviceRequest);
        return ServiceRequestMapper.mapToServiceRequestDto(serviceRequest);

    }

    @Override
    public ServiceRequestDto getServiceRequestById(int Id){
        ServiceRequest serviceRequest = serviceRequestRepository.findById(Id).orElseThrow(() -> new RuntimeException("ServiceRequest not found"));
     return ServiceRequestMapper.mapToServiceRequestDto(serviceRequest);
    }

    @Override
    public ServiceRequestDto updateServiceRequest(int id, ServiceRequestDto serviceRequestDto) {
        // Find the existing ServiceRequest or throw an exception if not found
        ServiceRequest existingServiceRequest = serviceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceRequest not found"));

        // Update the fields of the existing ServiceRequest with values from the DTO
        existingServiceRequest.setDate(serviceRequestDto.getDate());
        existingServiceRequest.setCar(serviceRequestDto.getCar());
        existingServiceRequest.setCaruserDetails(serviceRequestDto.getCaruserDetails());
        existingServiceRequest.setSavedAddress(serviceRequestDto.getSavedAddress());
        existingServiceRequest.setStatus(serviceRequestDto.getStatus()); // Update status
        existingServiceRequest.setPayment(serviceRequestDto.getPayment());

        // Save the updated ServiceRequest back to the database
        ServiceRequest updatedServiceRequest = serviceRequestRepository.save(existingServiceRequest);

        // Convert the updated entity back to a DTO and return it
        return ServiceRequestMapper.mapToServiceRequestDto(updatedServiceRequest);
    }

    @Override
    public ServiceRequestDto deleteServiceAddress(int id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("Service request does not exist"));
        ServiceRequestDto serviceRequestDto = ServiceRequestMapper.mapToServiceRequestDto(serviceRequest);
        serviceRequestRepository.deleteById(id);
        return serviceRequestDto;
    }


}

