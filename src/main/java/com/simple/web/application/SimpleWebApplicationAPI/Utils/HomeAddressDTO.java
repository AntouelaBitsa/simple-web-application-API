package com.simple.web.application.SimpleWebApplicationAPI.Utils;

public class HomeAddressDTO {
    private Integer homeAddID;
    private String homeAddress;

    // Default constructor
    public HomeAddressDTO() {}

    // Getters and Setters

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

    @Override
    public String toString() {
        return "HomeAddressDTO{" +
                "homeAddress='" + homeAddress + '\'' +
                '}';
    }
}
