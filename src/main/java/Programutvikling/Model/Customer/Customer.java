package Programutvikling.Model.Customer;

import Programutvikling.Model.AccidentReport;
import Programutvikling.Model.Insurance.Insurance;
import Programutvikling.Model.MyArrays;
import Programutvikling.Model.MyDate;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static Programutvikling.Model.MyArrays.customerListscsv;
import static Programutvikling.Model.MyArrays.getCustomerList;

public class Customer extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    //Dato kunde opprettet
    private MyDate dateCustomerCreated;

    //Faktura-adresse
    private String billingAdress;
    private String billingPostalCode;
    private String billingCity;

    //Kundenummer
    private String customerID;

    //Setter automatisk customerID
    public String CustomerIDSetter() {
        int newID = 1;
        for(Customer c : MyArrays.getCustomerList()) {
            if(Integer.parseInt(c.getCustomerID()) >= newID) {
                newID = Integer.parseInt(c.getCustomerID())+1;
            }
        }
        DecimalFormat formatter = new DecimalFormat("0000");
        String newIDFormatted = formatter.format(newID);

        return newIDFormatted;
    }
    //Forsikringsnummer //TODO bytt ut denne, Pass på her at customerId alltid må ha fire siffer, kunde nr 1 = 0001.


    //Summen av alle ubetalte kompansasjoner
    private double sumUnpaidCompensations = 0;

    public Customer(String firstName, String lastName, String phoneNumber, String email,
                    String billingAdress, String billingPostalCode, String billingCity) {
        super(firstName, lastName, phoneNumber, email);
        MyDate dateObj = new MyDate();
        this.dateCustomerCreated = dateObj;
        this.billingAdress = billingAdress;
        this.billingPostalCode = billingPostalCode;
        this.billingCity = billingCity;
        customerID = CustomerIDSetter();
    }

    //Konstruktør for bruk ved oppretting av kunde
    public Customer(String customerID, MyDate date, String firstName, String lastName, String phoneNumber, String email,
                    String billingAdress, String billingPostalCode, String billingCity)
    throws InvalidPersonFormatException{
        super(firstName, lastName, phoneNumber, email);
        this.dateCustomerCreated = date;
        this.billingAdress = billingAdress;
        this.billingPostalCode = billingPostalCode;
        this.billingCity = billingCity;
        this.customerID = customerID;
        setCustomersUnpaidCompensations();
    }


    //Oppretter array med all kundeinfo
    static ArrayList arr = new ArrayList();
    public void customerInfoArray() {
        arr.add(customerID);
        arr.add(dateCustomerCreated.toString());
        arr.add(getFirstName());
        arr.add(getLastName());
        arr.add(getPhoneNumber());
        arr.add(getEmail());
        arr.add(billingAdress);
        arr.add(billingPostalCode);
        arr.add(billingCity);
    }

    public static ArrayList arrOut() {
        return arr;
    }


    //Gettere og Settere for faktura-adressen
    public String getBillingAdress() {
        return billingAdress;
    }

    public void setBillingAdress(String bAdress) {
        this.billingAdress = bAdress;
    }

    public String getBillingPostalCode() {
        return this.billingPostalCode = billingPostalCode;
    }

    public void setBillingPostalCode(String bPostalCode) { this.billingPostalCode = bPostalCode; }

    public String getBillingCity() { return billingCity; }

    public void setBillingCity(String bCity) { this.billingCity = bCity; }

    //Getter for dateCustomerCreated

    public MyDate getDateCustomerCreated() {
        return dateCustomerCreated;
    }

    public void setDateCustomerCreated(MyDate date) {
        this.dateCustomerCreated = date;
    }

    //Getter for insurancenumber

    public String getCustomerID() { return customerID; }

    public void setCustomerID(String customerID) { this.customerID = customerID; }



    //Henter skademeldingenes ubetalte kompansasjoner, legger dem i array og regner ut summen av dem
    public void setCustomersUnpaidCompensations() {
        for (AccidentReport i : MyArrays.AccidentReportListscsv()) {
            if(i.getAccidentNumber().substring(0,4).equals(this.customerID)) {
                double sum = (i.getValuationAmount() - i.getPaidCompansationAmount());
                sumUnpaidCompensations += sum;
            }
        }
    }

    public String getCustomerUnpaidCompensations() {
        String unPaidString = Double.toString(sumUnpaidCompensations);
        return unPaidString;
    }

    //toString; Brukes ved skriving til CSV-fil
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getCustomerID());
        buffer.append(";");
        buffer.append(dateCustomerCreated);
        buffer.append(";");
        buffer.append(getFirstName());
        buffer.append(";");
        buffer.append(getLastName());
        buffer.append(";");
        buffer.append(getPhoneNumber());
        buffer.append(";");
        buffer.append(getEmail());
        buffer.append(";");
        buffer.append(billingAdress);
        buffer.append(";");
        buffer.append(billingPostalCode);
        buffer.append(";");
        buffer.append(billingCity);
        buffer.append(";");
        return buffer.toString();
    }

}
