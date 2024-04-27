package com.example.UsersProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "data_of_birth")
    private String dataOfBirth;


    public UserEntity(){}

    public UserEntity(String email, String firstName, String lastName, String dataOfBirth) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataOfBirth = dataOfBirth;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + null +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dataOfBirth='" + dataOfBirth + '\'' +
                '}';
    }
}
