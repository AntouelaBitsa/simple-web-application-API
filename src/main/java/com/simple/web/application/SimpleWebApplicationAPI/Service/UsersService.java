package com.simple.web.application.SimpleWebApplicationAPI.Service;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import com.simple.web.application.SimpleWebApplicationAPI.Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        List<Users> usersList = null;
        try {
             usersList = usersRepository.findAll();
        }catch (Exception e){
            System.out.println("Exception Occurred on Get All Users: " + e);
        }
        return usersList;
    }

    public Users getUserByID(Integer id){
        Users user = new Users();
        try {
            user = usersRepository.findById(id).orElse(null);
        }catch (Exception e){
            System.out.println("Exception Occurred on Get User by ID: " + e);
        }
       return user;
    }

    //TODO: condition id there is same work address and get that id
    public Users registerUser(Users user){
        System.out.println("[Debug01: registerUser()]: " + user.toString());
        Users regUser = new Users();
        try {
            System.out.println("[Debug02: try{}]: " + usersRepository.save(user));
            regUser = usersRepository.save(user);
        }catch (Exception e){
            System.out.println("[Debug03: catch() exception]: " + regUser);
            System.out.println("Exception Occurred on User Registration: " + e);
        }

        return regUser;
    }

}
