package com.simple.web.application.SimpleWebApplicationAPI.Utils;

import java.time.LocalDate;

public class UsersDTO {
    private Integer userID;
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthDate;
    private WorkAddressDTO workAdd;
    private HomeAddressDTO homeAdd;

    // Default constructor
    public UsersDTO() {}

    // Getters and Setters

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public WorkAddressDTO getWorkAdd() {
        return workAdd;
    }

    public void setWorkAdd(WorkAddressDTO workAdd) {
        this.workAdd = workAdd;
    }

    public HomeAddressDTO getHomeAdd() {
        return homeAdd;
    }

    public void setHomeAdd(HomeAddressDTO homeAdd) {
        this.homeAdd = homeAdd;
    }

    @Override
    public String toString() {
        return "UsersDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", workAdd=" + workAdd +
                ", homeAdd=" + homeAdd +
                '}';
    }
}
