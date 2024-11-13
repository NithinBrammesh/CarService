package com.example.car.CarService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service_request")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_ID")
    private Integer requestId;

    @Column(name = "Date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "Id", referencedColumnName = "Id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "User_id", referencedColumnName = "User_id")
    private UserDetails userDetails;

    @ManyToOne
    @JoinColumn(name = "S_Id", referencedColumnName = "S_id")
    private SavedAddress savedAddress;
}
