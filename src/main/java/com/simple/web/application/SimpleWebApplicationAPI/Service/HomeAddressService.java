package com.simple.web.application.SimpleWebApplicationAPI.Service;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.HomeAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.WorkAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Repository.HomeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeAddressService {
    @Autowired
    private HomeAddressRepository homeAddressRepository;

    public HomeAddress getHomeAddByID(Integer id){
        HomeAddress homeAddress = new HomeAddress();
        try {
            homeAddress = homeAddressRepository.findById(id).orElse(null);
        }catch (Exception e){
            System.out.println("Exception Occurred on getWorkAddByID(): " + e);
        }
        return homeAddress;
    }

    public HomeAddress registerHomeAddress(String homeAddress){
        System.out.println("[Debug01: registerWorkAddress()]: " + homeAddress.toString());
        HomeAddress regHomeAdd = new HomeAddress();
        regHomeAdd.setHomeAddress(homeAddress);

        try {
            regHomeAdd = homeAddressRepository.save(regHomeAdd);
            System.out.println("[Debug02: WorkAddress saved]: " + regHomeAdd);
        }catch (Exception e){
            System.out.println("[Debug03: catch() exception]: " + regHomeAdd);
            System.out.println("Exception Occurred on registerWorkAddress(): " + e.getMessage());
        }

        return regHomeAdd;
    }
}
