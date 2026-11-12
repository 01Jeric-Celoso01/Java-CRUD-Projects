package org.jcc.model;

import org.jcc.enums.Category;
import org.jcc.enums.Gender;
import org.jcc.util.GenerateAge;
import org.jcc.util.GenerateId;
import org.jcc.util.Uppercase;

import java.time.LocalDate;

public class Contact {
    private String contactId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private Gender gender;
    private String birthDay;
    private int age;
    private String company;
    private String jobTitle;
    private Category category;
    private String notes;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Contact(String firstName, String middleName, String lastName, String phoneNumber, String email, String address,
                   Gender gender, String birthDay, int age, String company, String jobTitle, Category category, String notes, LocalDate createdAt, LocalDate updatedAt) {
        this.contactId = GenerateId.contactId();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.birthDay = birthDay;
        this.age = age;
        this.company = company;
        this.jobTitle = jobTitle;
        this.category = category;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public Gender getGender() { return gender; }
    public String getBirthDay() {
        if (birthDay == null || !birthDay.isEmpty()) {
            return birthDay;
        }

        return birthDay.substring(0, 2) + "/" + birthDay.substring(2, 4) + "/" + birthDay.substring(4, 8);
    }
    public int getAge() { return age; }
    public String getCompany() { return company; }
    public String getJobTitle() { return jobTitle; }
    public Category getCategory() { return category; }
    public String getNotes() { return notes; }
    public LocalDate getCreatedAt() { return createdAt; }
    public LocalDate getUpdatedAt() { return updatedAt; }

    public void setContactId(String contactId) { this.contactId = contactId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email;}
    public void setAddress(String address) { this.address = address; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setBirthDay(String birthDay) { this.birthDay = birthDay; }
    public void setAge(int age) { this.age = age; }
    public void setCompany(String company) { this.company = company; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setCategory(Category category) { this.category = category; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDate updatedAt) { this.updatedAt = updatedAt;}
}
