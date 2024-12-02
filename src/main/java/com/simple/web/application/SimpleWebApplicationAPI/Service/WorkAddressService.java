package com.simple.web.application.SimpleWebApplicationAPI.Service;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.WorkAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Repository.WorkAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkAddressService {
    @Autowired
    private WorkAddressRepository workAddressRepository;

    public List<WorkAddress> getAllWorkAddresses() {
        List<WorkAddress> workAddList = new ArrayList<>();
        try {
            workAddList = workAddressRepository.findAll();
        }catch (Exception e){
            System.out.println("Exception Occurred on getAllWorkAddresses(): " + e);
        }
        return workAddList;
    }

    public WorkAddress getWorkAddByID(Integer id){
        WorkAddress workAddress = new WorkAddress();
        try {
            workAddress = workAddressRepository.findById(id).orElse(null);
        }catch (Exception e){
            System.out.println("Exception Occurred on getWorkAddByID(): " + e);
        }
        return workAddress;
    }

    public WorkAddress registerWorkAddress(String workAddress){
        System.out.println("[Debug01: registerWorkAddress()]: " + workAddress.toString());
        WorkAddress regWorkAdd = new WorkAddress();

        try {
            regWorkAdd = workAddressRepository.save(regWorkAdd);
            System.out.println("[Debug02: WorkAddress saved]: " + regWorkAdd);
        }catch (Exception e){
            System.out.println("[Debug03: catch() exception]: " + regWorkAdd);
            System.out.println("Exception Occurred on registerWorkAddress(): " + e.getMessage());
        }

        return regWorkAdd;
    }
}
