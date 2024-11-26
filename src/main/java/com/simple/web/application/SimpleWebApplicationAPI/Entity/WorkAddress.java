package com.simple.web.application.SimpleWebApplicationAPI.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "workaddress")
public class WorkAddress {
    //TODO: add nullable = false
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workAddID;
    private String workAddress;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    @OneToMany(mappedBy = "workAdd", cascade = CascadeType.ALL)
    private List<Users> users; //Foreign key

    public WorkAddress(String workAddress, List<Users> users) {
        this.workAddress = workAddress;
        this.users = users;
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

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
