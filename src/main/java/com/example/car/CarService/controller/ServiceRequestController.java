package com.example.car.CarService.controller;

import com.example.car.CarService.ServiceRequestService;
import com.example.car.CarService.dto.ServiceRequestDto;
import com.example.car.CarService.dto.UserDetailsDto;
import com.example.car.CarService.service.Impl.ServiceRequestServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service_request")
public class ServiceRequestController {

    private ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequestDto>> getAllServicerequest(){
        List<ServiceRequestDto> serviceRequestDto = serviceRequestService.getAllServiceRequest();
        return ResponseEntity.ok(serviceRequestDto);
    }

    @PostMapping
    ResponseEntity<ServiceRequestDto> AddServiceRequest(@RequestBody ServiceRequestDto serviceRequestDto){
        return new ResponseEntity<>(serviceRequestService.createServiceRequest(serviceRequestDto),HttpStatus.CREATED);
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<ServiceRequestDto> updateServiceRequest(@PathVariable int requestId, @RequestBody ServiceRequestDto serviceRequestDto) {
        ServiceRequestDto updatedRequest = serviceRequestService.updateServiceRequest(requestId, serviceRequestDto);
        return ResponseEntity.ok(updatedRequest);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<ServiceRequestDto> getServiceRequestById(@PathVariable("requestId") int requestId){
        ServiceRequestDto serviceRequestDto = serviceRequestService.getServiceRequestById(requestId);
        return ResponseEntity.ok(serviceRequestDto);
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<ServiceRequestDto> deleteServiceRequestById(@PathVariable ("requestId") int requestId){
        ServiceRequestDto deleteServiceRequestDto = serviceRequestService.deleteServiceAddress(requestId);
       return ResponseEntity.ok(deleteServiceRequestDto);
    }

}
