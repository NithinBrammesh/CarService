package com.example.car.CarService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service_request")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_ID")
    private int requestId;

    @Column(name = "Date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id", referencedColumnName = "Id")
    private Car car;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "User_id", referencedColumnName = "User_id", nullable = false)
    private carUserDetails caruserDetails;

    @ManyToOne
    @JoinColumn(name = "S_Id", referencedColumnName = "S_id")
    private SavedAddress savedAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "payment", nullable = false)
    private int Payment;
}
