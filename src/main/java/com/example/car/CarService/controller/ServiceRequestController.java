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

    @PostMapping
    ResponseEntity<ServiceRequestDto> AddServiceRequest(@RequestBody ServiceRequestDto serviceRequestDto){
        return new ResponseEntity<>(serviceRequestService.createServiceRequest(serviceRequestDto),HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ServiceRequestDto>> getAllServicerequest(){
        List<ServiceRequestDto> serviceRequestDto = serviceRequestService.getAllServiceRequest();
        return ResponseEntity.ok(serviceRequestDto);
    }

    @GetMapping("/{Request_ID}")
    public ResponseEntity<ServiceRequestDto> getServiceRequestById(@PathVariable("{Request_ID}") int Request_Id){
        ServiceRequestDto serviceRequestDto = serviceRequestService.getServiceRequestById(Request_Id);
        return ResponseEntity.ok(serviceRequestDto);
    }

    @DeleteMapping("/{Request_ID}")
    public ResponseEntity<ServiceRequestDto> deleteServiceRequestById(@PathVariable ("{Request_ID}") int Request_Id){
        ServiceRequestDto deleteServiceRequestDto = serviceRequestService.getServiceRequestById(Request_Id);
       return ResponseEntity.ok(deleteServiceRequestDto);
    }

}
