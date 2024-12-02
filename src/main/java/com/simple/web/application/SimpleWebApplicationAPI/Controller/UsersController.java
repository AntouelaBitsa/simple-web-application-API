package com.simple.web.application.SimpleWebApplicationAPI.Controller;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.HomeAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.WorkAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Service.UsersService;
import com.simple.web.application.SimpleWebApplicationAPI.Utils.HomeAddressDTO;
import com.simple.web.application.SimpleWebApplicationAPI.Utils.UsersDTO;
import com.simple.web.application.SimpleWebApplicationAPI.Utils.WorkAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService userService;
    
    @GetMapping("/getUsersList")
    public ResponseEntity<List<UsersDTO>> getUsersList(){
        String successMessage = null;
        String errorMessage = null;
        List<Users> usersList = new ArrayList<>();
        List<UsersDTO> usersDTOList= new ArrayList<>();
        UsersDTO usrDTO;

        try{
            System.out.println("[Controller - Debug01: getUsersList()]: " + userService.getAllUsers().toString());
            usersList.addAll(userService.getAllUsers());
            System.out.println("controller- users list print:" + usersList);

            for (Users usr: usersList){
                usrDTO = convertToDTO(usr);
                usersDTOList.add(usrDTO);
            }
            System.out.println("controller- users DTO list print:" + usersDTOList);

            successMessage = "User Registered successfully with ID: " + usersList.toString();
            return new ResponseEntity<>(usersDTOList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("[Controller - Debug03: getUsersList()]: " + e.getMessage());
            errorMessage = "Error occurred while registering user: " + e.getMessage();
            return new ResponseEntity<>(usersDTOList, HttpStatus.OK);
        }
    }

    @GetMapping("/getUserById/{uId}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Integer uId){
        String successMessage = null;
        String errorMessage = null;
        Users users = new Users();
        UsersDTO usersDTO = new UsersDTO();

        try{
            System.out.println("[Controller - Debug01: getUserById()]: " + userService.getAllUsers().toString());
            users = userService.getUserByID(uId);
            usersDTO = convertToDTO(users);
            successMessage = "User Registered successfully with ID: " + users.toString();
            return new ResponseEntity<>(usersDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("[Controller - Debug03: getUserById()]: " + e.getMessage());
            errorMessage = "Error occurred while registering user: " + e.getMessage();
            return new ResponseEntity<>(usersDTO, HttpStatus.OK);
        }
    }

    @PostMapping("/registerUser")
    public ResponseEntity<Users> registerUser(@RequestBody UsersDTO usersDTO){
        System.out.println("[Controller - Debug01: registerUser()]: " + usersDTO);
        if (usersDTO.getWorkAdd() != null) {
            System.out.println("[Controller - Debug02: Work Address]: " + usersDTO.getWorkAdd().getWorkAddress());
        } else {
            System.out.println("[Controller - Debug02: Work Address]: null");
        }
        if (usersDTO.getHomeAdd() != null) {
            System.out.println("[Controller - Debug03: Home Address]: " + usersDTO.getHomeAdd().getHomeAddress());
        } else {
            System.out.println("[Controller - Debug03: Home Address]: null");
        }
        Users user = convertToEntity(usersDTO);
        Users registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    private Users convertToEntity(UsersDTO userDTO) {
        Users user = new Users();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setGender(userDTO.getGender());
        user.setBirthDate(userDTO.getBirthDate());

        WorkAddress workAddress = new WorkAddress();
        workAddress.setWorkAddress(userDTO.getWorkAdd().getWorkAddress());
        user.setWorkAdd(workAddress);

        HomeAddress homeAddress = new HomeAddress();
        homeAddress.setHomeAddress(userDTO.getHomeAdd().getHomeAddress());
        user.setHomeAdd(homeAddress);

        return user;
    }

    private UsersDTO convertToDTO(Users user) {
        UsersDTO userDTO = new UsersDTO();
        userDTO.setUserID(user.getUserID());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setGender(user.getGender());
        userDTO.setBirthDate(user.getBirthDate());

        WorkAddressDTO workAddressDTO = new WorkAddressDTO();
        if (user.getWorkAdd() != null) {
            workAddressDTO.setWorkAddID(user.getWorkAdd().getWorkAddID());
            workAddressDTO.setWorkAddress(user.getWorkAdd().getWorkAddress());
        }
        userDTO.setWorkAdd(workAddressDTO);

        HomeAddressDTO homeAddressDTO = new HomeAddressDTO();
        if (user.getHomeAdd() != null) {
            homeAddressDTO.setHomeAddID(user.getHomeAdd().getHomeAddID());
            homeAddressDTO.setHomeAddress(user.getHomeAdd().getHomeAddress());
        }
        userDTO.setHomeAdd(homeAddressDTO);

        return userDTO;
    }
}
