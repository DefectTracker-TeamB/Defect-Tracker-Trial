package com.example.EmployeeRegistration.Controller;

import com.example.EmployeeRegistration.Dto.EmployeeDto;
import com.example.EmployeeRegistration.Dto.UserDto;
import com.example.EmployeeRegistration.Entity.Employee;
import com.example.EmployeeRegistration.Entity.User;
import com.example.EmployeeRegistration.Repo.EmployeeRepo;
import com.example.EmployeeRegistration.Repo.UserRepo;
import com.example.EmployeeRegistration.Services.EmailService;
import com.example.EmployeeRegistration.Services.EmpService;
import com.example.EmployeeRegistration.Services.EmployeeServices;
import com.example.EmployeeRegistration.Services.UserServ;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmpService empService;
    @Autowired
    UserServ userServ;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private EmailService emailService;
    List<String> designations= Arrays.asList("QA","SoftwareEngineer","HR");
    List<String> roles= Arrays.asList("QA","Developer","ProjectManager");

    @PostMapping("/employee")
    public ResponseEntity<Object> saveEmp(@RequestBody EmployeeDto employeeDto){
        if(empService.isAlreadyExists(employeeDto.getEmail())){
            return ResponseEntity.ok("User Already exists");
        }
        else {
            Employee employee=modelMapper.map(employeeDto,Employee.class);
            empService.SaveEmp(employee);
            for(String i:designations){
                if(employeeDto.getDesignation().contains(i)){
                    UserDto userDto=new UserDto();
                    userDto.setUserName(employeeDto.getEmail());
                    userDto.setPassword(employeeDto.getPassword());
                    userDto.setRole(roles.get(designations.indexOf(i)));
                    User user=modelMapper.map(userDto,User.class);

                    userServ.saveUser(user);
                    String body="Hi"+", "+employeeDto.getName()+"\n"+"You can LogIn Use the Provided Password\n"+"Password : -"+employeeDto.getPassword()+
                    "\nTo confirm your account, please click here : " +"http://localhost:8080/confirm-account?;";
                    emailService.SendVerificationMail(employeeDto.getEmail(),body);
                    break;
                }
            }
            return ResponseEntity.ok("Created");
        }
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmp(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(empService.getEmpById(id));
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmp(@PathVariable("id") int id){
        empService.deleteEmpById(id);
        return ResponseEntity.ok("Deleted");
    }


    }


