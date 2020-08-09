package Programutvikling.Model.Insurance;

import Programutvikling.Model.MyDate;

import java.util.Calendar;

public class TravelInsurance extends Insurance {
    private String insuranceRange; // området hvor forsikringen gjelder
    private int travelInsuranceAmount;
    private String insuranceType;


    //Konstruktør:

    public TravelInsurance(String insuranceNumber,
                           double insuranceAmount,
                           double insuranceValue,
                           MyDate dateInsuranceCreated,
                           String insuranceConditions,
                           String insuranceRange,
                           int travelInsuranceAmount)
            throws InvalidInsuranceInputException {
        super(insuranceNumber, insuranceAmount, insuranceValue, dateInsuranceCreated, insuranceConditions);

        if (CheckValidTravelInsuranceInput.CheckValidInsuranceRange(insuranceRange) &
                CheckValidTravelInsuranceInput.CheckValidTravelInsuranceAmount(travelInsuranceAmount)) {
            this.insuranceRange = insuranceRange;
            this.travelInsuranceAmount = travelInsuranceAmount;
            this.insuranceType = "Reiseforsikring";
        }
    }
    //Forrige metode er overloadet for å kunne håndtere customerId som Integer
    // og insuranceId som String
    /*public TravelInsurance(String insuranceNumber,
                           double insuranceAmount,
                           double insuranceValue,
                           MyDate dateInsuranceCreated,
                           String insuranceConditions,
                           String insuranceRange,
                           int travelInsuranceAmount)
            throws InvalidInsuranceInputException {
        super(insuranceNumber, insuranceAmount, insuranceValue, dateInsuranceCreated, insuranceConditions);

        if (CheckValidTravelInsuranceInput.CheckValidInsuranceRange(insuranceRange) &
                CheckValidTravelInsuranceInput.CheckValidTravelInsuranceAmount(travelInsuranceAmount)) {
            this.insuranceRange = insuranceRange;
            this.travelInsuranceAmount = travelInsuranceAmount;
            this.insuranceType = "Reiseforsikring";
        }
    }*/


    //Get-metoder for å hente variable i eksisterende objekt:

    public String getinsuranceRange() {
        return insuranceRange;
    }

    public int getTravelInsuranceAmount() {
        return travelInsuranceAmount;
    }

    public String getInsuranceType() {
        return insuranceType;
    }


    //Set-metoder:


    public void setInsuranceRange(String insuranceRange) {
        try {
            if (CheckValidTravelInsuranceInput.CheckValidInsuranceRange(insuranceRange)) {
                this.insuranceRange = insuranceRange;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println("Input is not valid");
        }

    }

    public void setTravelInsuranceAmount(int travelInsuranceAmount) {
        try {
            if (CheckValidTravelInsuranceInput.CheckValidTravelInsuranceAmount(travelInsuranceAmount)) {
                this.travelInsuranceAmount = travelInsuranceAmount;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println("Input is not valid");
        }
    }

    @Override
    public String giveInsuranceType() {
        return "Reiseforsikring";
    }

    //toString; Brukes ved skriving til CSV-fil
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getInsuranceId());
        buffer.append(";");
        buffer.append(getInsuranceAmount());
        buffer.append(";");
        buffer.append(getInsuranceValue());
        buffer.append(";");
        buffer.append(getDateInsuranceCreated());
        buffer.append(";");
        buffer.append(getInsuranceConditions());
        buffer.append(";");
        buffer.append(insuranceRange);
        buffer.append(";");
        buffer.append(travelInsuranceAmount);
        buffer.append(";");
        return buffer.toString();
    }
}
