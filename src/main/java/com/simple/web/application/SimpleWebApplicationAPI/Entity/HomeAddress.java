package com.simple.web.application.SimpleWebApplicationAPI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

@Entity
@Table(name = "homeaddress")
public class HomeAddress {
    //TODO: add nullable = false
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_addid")
    private Integer homeAddID;
    @Column(name = "home_address")
//    @SerializedName("homeAddress")
    private String homeAddress;
    @OneToOne(mappedBy = "homeAdd", cascade = CascadeType.ALL)
    private Users user;

    public HomeAddress() {
    }

    public HomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

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
