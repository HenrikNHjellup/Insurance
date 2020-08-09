package Programutvikling.Model.Insurance;

/*Klasse for forsikring av typen båt */


import Programutvikling.Model.MyDate;

import java.util.Calendar;


public class BoatInsurance extends Insurance {
    private String ownerLastName; //Etternavn på eier, antar at eier kan være annen person en forsikringstaker
    private String ownerFirstName;
    private String registrationId; //registreringsnummer, må følge en form: QWE123
    private String boatType; // Antar at dette er verdier som Seilbåt, motorbåt, robåt etc.
    private String model; // Modellnavnet
    private int length; // Båtens lengde i antall fot
    private int registrationYear; // registrert år
    private String operation; // Type drift: seil, påhengsmotor, integrert motor, etc.
    private int power; // Hvis motordrift, styrke i antall hk



    public BoatInsurance(String customerId,
                         double insuranceAmount,
                         double insuranceValue,
                         MyDate dateInsuranceCreated,
                         String insuranceConditions,
                         String ownerLastName,
                         String ownerFirstName,
                         String registrationId,
                         String boatType,
                         String model,
                         int length,
                         int registrationYear,
                         String operation)
            throws InvalidInsuranceInputException {
        super(customerId, insuranceAmount, insuranceValue, dateInsuranceCreated, insuranceConditions);

        if (CheckValidBoatInsuranceInput.checkValidBoatOwnerLastName(ownerLastName) &
                CheckValidBoatInsuranceInput.checkValidBoatOwnerFirstName(ownerFirstName) &
                CheckValidBoatInsuranceInput.checkValidBoatRegistrationId(registrationId) &
                CheckValidBoatInsuranceInput.checkValidBoatType(boatType) &
                CheckValidBoatInsuranceInput.checkValidBoatModel(model) &
                CheckValidBoatInsuranceInput.checkValidBoatLength(length) &
                CheckValidBoatInsuranceInput.checkValidBoatRegistrationYear(registrationYear) &
                CheckValidBoatInsuranceInput.checkValidBoatOperation(operation)) {

            this.ownerLastName = ownerLastName;
            this.ownerFirstName = ownerFirstName;
            this.registrationId = registrationId;
            this.boatType = boatType;
            this.model = model;
            this.length = length;
            this.registrationYear = registrationYear;
            this.operation = operation;
        }
    }
    //Forrige metode er overloadet for å kunne håndtere customerId som Integer
    // og insuranceId som String
    /*public BoatInsurance(String insuranceId,
                         double insuranceAmount,
                         double insuranceValue,
                         MyDate dateInsuranceCreated,
                         String insuranceConditions,
                         String ownerLastName,
                         String ownerFirstName,
                         String registrationId,
                         String boatType,
                         String model,
                         int length,
                         int registrationYear,
                         String operation)
            throws InvalidInsuranceInputException {
        super(insuranceId, insuranceAmount, insuranceValue, dateInsuranceCreated, insuranceConditions);

        if (CheckValidBoatInsuranceInput.checkValidBoatOwnerLastName(ownerLastName) &
                CheckValidBoatInsuranceInput.checkValidBoatOwnerFirstName(ownerFirstName) &
                CheckValidBoatInsuranceInput.checkValidBoatRegistrationId(registrationId) &
                CheckValidBoatInsuranceInput.checkValidBoatType(boatType) &
                CheckValidBoatInsuranceInput.checkValidBoatModel(model) &
                CheckValidBoatInsuranceInput.checkValidBoatLength(length) &
                CheckValidBoatInsuranceInput.checkValidBoatRegistrationYear(registrationYear) &
                CheckValidBoatInsuranceInput.checkValidBoatOperation(operation)) {

            this.ownerLastName = ownerLastName;
            this.ownerFirstName = ownerFirstName;
            this.registrationId = registrationId;
            this.boatType = boatType;
            this.model = model;
            this.length = length;
            this.registrationYear = registrationYear;
            this.operation = operation;
        }
    }*/



//Get-metoder for å hente variable i eksisterende objekt:

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getBoatType() {
        return boatType;
    }

    public String getModel() {
        return model;
    }

    public int getLength() {
        return length;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public String getOperation() {
        return operation;
    }

    public int getPower() {
        return power;
    }



    //Set-metoder:


    public void setOwnerLastName(String ownerLastName) {
        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatOwnerLastName(ownerLastName)) {
                this.ownerLastName = ownerLastName;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }


    public void setOwnerFirstName(String ownerFirstName) {
        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatOwnerLastName(ownerFirstName)) {
                this.ownerFirstName = ownerFirstName;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setRegistrationId(String registrationId) {

        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatRegistrationId(registrationId)) {
                this.registrationId = registrationId;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setBoatType(String boatType) {

        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatType(boatType)) {
                this.boatType = boatType;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setModel(String model) {

        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatOwnerLastName(model)) {
                this.model = model;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setLength(int length) {

        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatLength(length)) {
                this.length = length;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setRegistrationYear(int registrationYear) {
        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatRegistrationYear(registrationYear)) {
                this.registrationYear = registrationYear;;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setOperation(String operation) {

        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatOperation(operation)) {
                this.operation = operation;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setPower(int power) {

        try {
            if (CheckValidBoatInsuranceInput.checkValidBoatPower(power)) {
                this.power = power;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String giveInsuranceType() {
        return "Båtforsikring";
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
        buffer.append(getOwnerLastName());
        buffer.append(";");
        buffer.append(getOwnerFirstName());
        buffer.append(";");
        buffer.append(registrationId);
        buffer.append(";");
        buffer.append(boatType);
        buffer.append(";");
        buffer.append(model);
        buffer.append(";");
        buffer.append(length);
        buffer.append(";");
        buffer.append(registrationYear);
        buffer.append(";");
        buffer.append(operation);
        buffer.append(";");
        return buffer.toString();
    }
}
