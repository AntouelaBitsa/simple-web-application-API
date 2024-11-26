package com.simple.web.application.SimpleWebApplicationAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "homeaddress")
public class HomeAddress {
    //TODO: add nullable = false
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer homeAddID;
    private String homeAddress;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "userID")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "homeAdd")
    private Users user;

    public HomeAddress(String homeAddress, Users user) {
        this.homeAddress = homeAddress;
        this.user = user;
    }

    public Integer getHomeAddID() {
        return homeAddID;
    }

    public void setHomeAddID(Integer homeAddID) {
        this.homeAddID = homeAddID;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
