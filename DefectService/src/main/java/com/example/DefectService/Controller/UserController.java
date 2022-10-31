package com.example.DefectService.Controller;

import com.example.DefectService.Dto.UserDto;
import com.example.DefectService.Repository.ProjectTeamMemberRepo;
import com.example.DefectService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return  ResponseEntity.ok("Employee Added to Defect Tracker");
    }

    @GetMapping("/availableUsers")
    public ResponseEntity<Object>getUserByAvailability(){
        return ResponseEntity.ok(userService.filterByAvailability());
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<Object>deleteUser(@PathVariable("id")int id){

        userService.deleteUserById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

}
