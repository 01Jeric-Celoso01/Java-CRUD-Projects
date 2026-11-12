package org.jcc.model;

public class BorrowerModel {
    private String id;
    private String fName;
    private String mName;
    private String lName;
    private String gender;
    private String number;
    private String email;
    private String address;

    public BorrowerModel(String id, String fName, String mName, String lName, String gender, String number, String email, String address) {
        this.id = id;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.gender = gender;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fName + " " + mName + ". " +lName;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
