package com.simple.web.application.SimpleWebApplicationAPI.Service;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.HomeAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.WorkAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Repository.HomeAddressRepository;
import com.simple.web.application.SimpleWebApplicationAPI.Repository.UsersRepository;
import com.simple.web.application.SimpleWebApplicationAPI.Repository.WorkAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private WorkAddressRepository workAddressRepository;
    @Autowired
    private HomeAddressRepository homeAddressRepository;
    @Autowired
    private HomeAddressService homeAddressService;
    @Autowired
    private WorkAddressService workAddressService;

    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        try {
             usersList = usersRepository.findAll();
            System.out.println("[Debug - Service] " + usersList);
        }catch (Exception e){
            System.out.println("Exception Occurred on Get All Users: " + e);
        }
        System.out.println("users list print: " + usersList);
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

    public Users registerUser(Users user){
        System.out.println("[Debug01: registerUser()]: " + user.toString());
        Users regUser = new Users();

//        //Work Address
//        String workAddress = user.getWorkAdd().getWorkAddress();
//        System.out.println("** DBG 1.0 ** workAddress fromJSON =>>> " + workAddress);
//        WorkAddress workAddressObj = workAddressService.findWorkAddress(workAddress);
//        Integer workAddId = workAddressObj.getWorkAddID();
//        System.out.println("** DBG 1.1 ** workAddress ID workAddressService =>>> " + workAddId);
//
//        if (workAddId == null){
//            workAddressObj = workAddressService.registerWorkAddress(user.getWorkAdd().getWorkAddress());
//        }else {
//            workAddressObj = workAddressService.getWorkAddByID(workAddId);
//        }
//        regUser.setWorkAdd(workAddressObj);
//
//        //HomeAddress
//        String homeAddress = user.getHomeAdd().getHomeAddress();
//        System.out.println("** DBG 1.2 ** homeAddress fromJSON =>>> " + homeAddress);
//        HomeAddress homeAddressObj = homeAddressService.registerHomeAddress(homeAddress);
//        regUser.setHomeAdd(homeAddressObj);
//
//        System.out.println("Complete condition and RegUser: " + regUser);

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
