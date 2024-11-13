package com.example.car.CarService.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="car_category")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "Car_type" ,  unique = true ,nullable = false)
    private String CarType;

    @Column(name="Price", nullable = false)
    private int Price;
}
