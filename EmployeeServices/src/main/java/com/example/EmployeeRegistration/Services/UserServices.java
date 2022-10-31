package com.example.EmployeeRegistration.Services;

import com.example.EmployeeRegistration.Entity.User;
import com.example.EmployeeRegistration.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserServ {
    @Autowired
    UserRepo userRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
