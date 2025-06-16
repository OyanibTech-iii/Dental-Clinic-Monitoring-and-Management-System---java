package test;

import java.util.Date;

public class Patient {
    private int patientID;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String address;
    private Date birthdate;
    private String contactNumber;
    private String email;
    
    // Getters and Setters
    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Display patient details
    public void displayDetails() {
        System.out.println("Patient Details");
        System.out.println("ID: " + patientID);
        System.out.println("Name: " + lastName + ", " + firstName + " " + middleName);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Birthdate: " + birthdate);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Email: " + email);
    }
}