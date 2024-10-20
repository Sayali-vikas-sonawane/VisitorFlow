package com.visitor;

import java.sql.Timestamp;

public class Visitor {
    private String visitorId;
    private String name;
    private String lastName;
    private String email;
    private String phone_number;
    private String address;
    private String gender;
    private String purpose;
    private String additionalInfo;
    private Timestamp submissionTimestamp;
    private boolean isBlock;

    // Constructor
    public Visitor(String visitorId, String name, String lastName, String email, String phone_number,
                   String address, String gender, String purpose, String additionalInfo, Timestamp submissionTimestamp, boolean isBlock) {
        this.visitorId = visitorId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.gender = gender;
        this.purpose = purpose;
        this.additionalInfo = additionalInfo;
        this.submissionTimestamp = submissionTimestamp;
        this.isBlock=isBlock;
    }

    // Getters and Setters
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Timestamp getSubmissionTimestamp() {
        return submissionTimestamp;
    }

    public void setSubmissionTimestamp(Timestamp submissionTimestamp) {
        this.submissionTimestamp = submissionTimestamp;
    }
    public boolean getisBlock() {
        return isBlock;
    }

    public void setisBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId='" + visitorId + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", purpose='" + purpose + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", submissionTimestamp=" + submissionTimestamp + '\'' +
                ", isBlock=" + isBlock +
                '}';
    }
}
