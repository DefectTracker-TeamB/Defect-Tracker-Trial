package com.example.DefectService.ServiceImpl;

import com.example.DefectService.Dto.UserDto;
import com.example.DefectService.Entity.User;
import com.example.DefectService.Repository.ProjectTeamMemberRepo;
import com.example.DefectService.Repository.UserRepo;
import com.example.DefectService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProjectTeamMemberRepo projectTeamMemberRepo;
    @Override
    public void saveUser(UserDto userDto) {
        User user=new User();
        user.setUserName(userDto.getUserName());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAvailability(100);
        user.setEmp_id(userDto.getEmp_id());
        user.setDesignation(userDto.getDesignation());
        userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    @Override
    public List<User> filterByAvailability() {
        return userRepo.filterByAvailability();
    }
    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(new User());
    }

    @Override
    public void deleteUserById(int id) {
        projectTeamMemberRepo.deleteMembersByUserId(id);
        userRepo.deleteById(id);

    }

}
