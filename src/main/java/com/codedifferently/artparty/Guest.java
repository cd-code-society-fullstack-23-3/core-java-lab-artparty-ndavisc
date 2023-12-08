package com.codedifferently.artparty;

public class Guest {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String reasonForVisit;

    public Guest (String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = "";
        this.reasonForVisit = "";
    }

    public Guest (){
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phone = "";
        this.reasonForVisit = "";
    }
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getReasonForVisit(){
        return this.reasonForVisit = reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return String.format("First Name: %s, Last Name: %s, Email Address: %s, Phone Number: %s, Reason For Visit: %s",
                firstName, lastName, email, phone, reasonForVisit);
    }
}
