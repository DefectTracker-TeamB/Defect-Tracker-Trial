package com.example.EmployeeRegistration.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String role;
    @OneToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public User() {
    }

    public User(int id, String userName, String password, String role, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.employee = employee;
    }
}
