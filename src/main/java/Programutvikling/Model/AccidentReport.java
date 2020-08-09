package Programutvikling.Model;

import Programutvikling.Model.Customer.Person;
import Programutvikling.Model.Insurance.BoatInsurance;
import Programutvikling.Model.Insurance.HouseInsurance;
import Programutvikling.Model.Insurance.TravelInsurance;
import Programutvikling.Model.Readers.InvalidAccidentReportInputException;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccidentReport implements Serializable {
    //Datafelt for datoen skaden oppsto
    private MyDate accidentDate;

    //Datafelt for skadenummer
    private String accidentNumber;

    //Datafelt for skadetype
    private String accidentType;

    //Datafelt for skadebeskrivelse
    private String accidentDescription;

    //Datafelt for vitnekontakt
    private String[] witnessContact;

    //Datafelt for takseringssum
    private double valuationAmount;

    //Datafelt for utbetalt erstatning
    private double paidCompansationAmount;

    //Konstruktør for skademeldingen
    public AccidentReport(MyDate accidentDate, String inID, String accidentType, String accidentDescription,
                          double valuationAmount, double paidCompansationAmount) throws InvalidAccidentReportInputException {
        this.accidentDate = accidentDate;
        if(inID.length()>8){this.accidentNumber=inID;}
        if(inID.length()==8){this.accidentNumber=constructAccidentNumber(inID);}
        this.accidentType = accidentType;
        this.accidentDescription = accidentDescription;
        this.valuationAmount = valuationAmount;
        this.paidCompansationAmount = paidCompansationAmount;
    }

    private String constructAccidentNumber(String insuranceId) {
        String insId;
        int inID = accidentNumberIterator(insuranceId);
        DecimalFormat f = new DecimalFormat("00");
        String newID = f.format(inID);
        insId = insuranceId+"A"+newID;



        return insId;
    }

    public int accidentNumberIterator(String insuranceId){
        int newID = 1;
        for(AccidentReport ar : MyArrays.AccidentReportListscsv()) {
            if((ar.accidentNumber.substring(0,8)).equals(insuranceId)){
                if(Integer.parseInt(ar.accidentNumber.substring(9)) >= newID){
                    newID = (Integer.parseInt(ar.accidentNumber.substring(9)))+1;
                }
            }
        }

        return newID;
    }
    //Oppretter et array med et eventuelt vitnes kontaktinformasjon
    //(Ligger ikke i konstruktør fordi det ikke alltid finnes et vitne)
    private void setWitnessContact(String firstName, String lastName, String phoneNumber, String email) {
        Person witness = new Person(firstName,lastName,phoneNumber,email);
        witnessContact[0] = witness.getFirstName();
        witnessContact[1] = witness.getLastName();
        witnessContact[2] = witness.getPhoneNumber();
        witnessContact[3] = witness.getEmail();
    }

    public String[] getWitnessContact() { return witnessContact; }

    //Gettere og settere for samtlige av klassens datafelt
    public MyDate getAccidentDate() { return accidentDate; }

    public void setAccidentDate(MyDate accidentDate) { this.accidentDate = accidentDate; }

    public String getAccidentNumber() { return accidentNumber; }

    public void setAccidentNumber(String accidentNumber) { this.accidentNumber = accidentNumber; }

    public String getAccidentType() { return accidentType; }

    public void setAccidentType(String accidentType) { this.accidentType = accidentType; }

    public String getAccidentDescription() { return accidentDescription; }

    public void setAccidentDescription(String accidentDescription) { this.accidentDescription = accidentDescription; }

    public double getValuationAmount() { return valuationAmount; }

    public void setValuationAmount(double valuationAmount) { this.valuationAmount = valuationAmount; }

    public double getPaidCompansationAmount() { return paidCompansationAmount; }

    public void setPaidCompansationAmount(double paidCompansationAmount) {
        this.paidCompansationAmount = paidCompansationAmount;
    }

    //toString; Brukes ved skriving til CSV-fil
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(accidentDate);
        buffer.append(";");
        buffer.append(accidentNumber);
        buffer.append(";");
        buffer.append(accidentType);
        buffer.append(";");
        buffer.append(accidentDescription);
        buffer.append(";");
        buffer.append(valuationAmount);
        buffer.append(";");
        buffer.append(paidCompansationAmount);
        buffer.append(";");
        return buffer.toString();
    }

}
