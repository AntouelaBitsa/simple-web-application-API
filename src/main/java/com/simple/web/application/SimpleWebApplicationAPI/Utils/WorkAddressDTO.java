package com.simple.web.application.SimpleWebApplicationAPI.Utils;

public class WorkAddressDTO {
    private Integer workAddID;
    private String workAddress;

    // Default constructor
    public WorkAddressDTO() {}

    // Getters and Setters
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

    @Override
    public String toString() {
        return "WorkAddressDTO{" +
                "workAddress='" + workAddress + '\'' +
                '}';
    }
}
