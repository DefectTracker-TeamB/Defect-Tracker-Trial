package com.example.DefectService.Service;

import com.example.DefectService.Dto.UserDto;
import com.example.DefectService.Entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    List<User>getAllUsers();
    List<User>filterByAvailability();
    User getUserById(int id);
    void deleteUserById(int id);

}
