package com.simple.web.application.SimpleWebApplicationAPI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    //TODO: add nullable = false
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_addid", referencedColumnName ="work_addid")
    @JsonProperty("workAddress")
    private WorkAddress workAdd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_addid", referencedColumnName = "home_addid")
    @JsonProperty("homeAddress")
    private HomeAddress homeAdd;

    public Users() {
    }

    public Users(String name, String surname, String gender, LocalDate birthDate, WorkAddress workAdd, HomeAddress homeAdd) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.workAdd = workAdd;
        this.homeAdd = homeAdd;
    }

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

    @JsonProperty("workAddress")
    public WorkAddress getWorkAdd() {
        return workAdd;
    }

    public void setWorkAdd(WorkAddress workAdd) {
        this.workAdd = workAdd;
    }

    @JsonProperty("homeAddress")
    public HomeAddress getHomeAdd() {
        return homeAdd;
    }

    public void setHomeAdd(HomeAddress homeAdd) {
        this.homeAdd = homeAdd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", workAdd=" + workAdd +
                ", homeAdd=" + homeAdd +
                '}';
    }

    public boolean hasEmptyOrNull() {
        return name.isEmpty() || name.equals(null) || surname.isEmpty() || surname.equals(null) || gender.isEmpty() || gender.equals(null) ||
                birthDate.equals(null) || workAdd.equals(null) || homeAdd.equals(null);
    }
}
