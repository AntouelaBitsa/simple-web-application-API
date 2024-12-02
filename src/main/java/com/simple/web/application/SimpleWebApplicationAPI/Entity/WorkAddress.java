package com.simple.web.application.SimpleWebApplicationAPI.Entity;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "workaddress")
public class WorkAddress {
    //TODO: add nullable = false
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_addid")
    private Integer workAddID;
    @Column(name = "work_address")
    private String workAddress;
    @OneToOne(mappedBy = "workAdd",cascade = CascadeType.ALL)
    private Users users; //Foreign key

    public WorkAddress() {
    }

    public WorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Integer getWorkAddID() {
        return workAddID;
    }

    public void setWorkAddID(Integer workAddID) {
        this.workAddID = workAddID;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
