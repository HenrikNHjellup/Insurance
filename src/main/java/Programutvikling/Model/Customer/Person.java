package Programutvikling.Model.Customer;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Person  implements Serializable{

    //Datafelt fornavn
    private String firstName;
    //Datafelt etternavn
    private String lastName;
    //Datafelt telefonnummer
    private String phoneNumber;
    //Datafelt epost-adresse
    private String email;

    //Personklassens konstruktør
    public Person(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Gettere og settere for samtlige Person-variabler
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("%s; %s; %s; %s", firstName,lastName,phoneNumber,email);
    }

    /*@Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(firstName);
        buffer.append(" ");
        buffer.append(lastName);
        buffer.append(" ");
        buffer.append(phoneNumber);
        buffer.append(" ");
        buffer.append(email);
        buffer.append(" ");
        return buffer.toString();
    }

    /*@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(firstName);
        buffer.append(" ");
        buffer.append(lastName);
        buffer.append(" ");
        buffer.append(phoneNumber);
        buffer.append(" ");
        buffer.append(email);
        buffer.append(" ");
        return buffer.toString();
    }*/


}
