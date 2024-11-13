package com.example.car.CarService.model;

import com.example.car.CarService.dto.UserDetailsDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="User_details")
public class UserDetails extends UserDetailsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private int UserId;

    @Column(name = "Name" , nullable = false)
    private String Name;

    @Column(name = "Phone_no", unique = true)
    private Long PhoneNo;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Password")
    private String Password;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedAddress> savedAddresses;

    public UserDetails(int UserId) {
        this.UserId = UserId;
    }
}
