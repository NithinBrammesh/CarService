package com.example.car.CarService.service.Impl;

import com.example.car.CarService.ServiceRequestService;
import com.example.car.CarService.dto.SavedAddressDto;
import com.example.car.CarService.dto.ServiceRequestDto;

import com.example.car.CarService.mapper.ServiceRequestMapper;

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

    public ServiceRequestDto updateServiceRequest(int Id, ServiceRequestDto serviceRequestDto){
        return serviceRequestRepository.findById(Id).map(existingServiceReqest->{
            existingServiceReqest.setRequestId(serviceRequestDto.getRequestId());
            existingServiceReqest.setCar(serviceRequestDto.getCar());
            existingServiceReqest.setDate(serviceRequestDto.getDate());
            existingServiceReqest.setSavedAddress(serviceRequestDto.getSavedAddress());
            existingServiceReqest.setUserDetails(serviceRequestDto.getUserDetails());
            return ServiceRequestMapper.mapToServiceRequestDto(existingServiceReqest);
        })
                .orElse(null);
    }
    public ServiceRequestDto deleteServiceAdress(int id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("Service request does not exist"));
        ServiceRequestDto serviceRequestDto = ServiceRequestMapper.mapToServiceRequestDto(serviceRequest);
        serviceRequestRepository.deleteById(id);
        return serviceRequestDto;
    }


}

