package com.example.micasa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.print.attribute.standard.Media;

@Data
@NoArgsConstructor
@Entity(name = "users")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email","phoneNumber"})
})
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @NotBlank
    @Column(name = "user_name")
    private String name;

    @NotBlank(message = "Email is already registered")
    private String email;

    @NotBlank(message = "Phone number is already registered")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "flat_number")
    private String flatNumber;

    public User(String userId, String name, String email, String phoneNumber)
    {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}