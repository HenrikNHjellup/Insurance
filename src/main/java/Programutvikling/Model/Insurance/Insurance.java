package Programutvikling.Model.Insurance;

import Programutvikling.Model.MyArrays;
import Programutvikling.Model.MyDate;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;


/*
 * Superklasse som definerer felles atributter for forsikringsklassene
 */
public abstract class Insurance implements Serializable {
    private String insuranceId; // Forsikringsnummer som er unikt for kunden, og knytter konkret forsikring mot konkret kunde.
    private double insuranceAmount; // Årlig forsikringspremie
    private double insuranceValue; // Verdien i kroner det er forsikret for
    private MyDate dateInsuranceCreated; //Dato forsikringen er opprettet
    private String insuranceConditions; // Forsikringsbetingelser kort oppsummert eller henvisning til egen dokumentasjon???


    //Konstruktør for oppretting av ny forsikring(insuranceId blir automatisk konstruert riktig):
    public Insurance(String customerId,
                     //TODO Pass på her at customerId alltid må ha fire siffer !! Må kanskje være string eller bruker string.format
                     double insuranceAmount,
                     double insuranceValue,
                     MyDate dateInsuranceCreated,
                     String insuranceConditions)
            throws InvalidInsuranceInputException {

        if (CheckValidInsuranceInput.checkValidInsuranceNumber(customerId) &
                CheckValidInsuranceInput.checkValidInsuranceAmount(insuranceAmount) &
                CheckValidInsuranceInput.checkValidInsuranceValue(insuranceValue) &
                CheckValidInsuranceInput.checkValidDateInsuranceCreated(dateInsuranceCreated) &
                CheckValidInsuranceInput.checkValidInsuranceConditions(insuranceConditions)) {
            //Disse to sjekker om dette er en helt ny forsikring, eller om det blir gjenopprettet fra fil
            if(customerId.length() == 4){ this.insuranceId = constructInsuranceNumber(customerId); }
            if(customerId.length() >4){ this.insuranceId = customerId; }
            this.insuranceAmount = insuranceAmount;
            this.insuranceValue = insuranceValue;
            this.insuranceConditions = insuranceConditions;
            this.dateInsuranceCreated = dateInsuranceCreated;
        }

    }
    //Konstruktør for gjenoppretting av kunde fra fil(Der insuranceId allerede er konstruert
    /*public Insurance(String customerId,
                     //TODO Pass på her at customerId alltid må ha fire siffer !! Må kanskje være string eller bruker string.format
                     double insuranceAmount,
                     double insuranceValue,
                     MyDate dateInsuranceCreated,
                     String insuranceConditions)
            throws InvalidInsuranceInputException {

        if (CheckValidInsuranceInput.checkValidInsuranceNumber(customerId) &
                CheckValidInsuranceInput.checkValidInsuranceAmount(insuranceAmount) &
                CheckValidInsuranceInput.checkValidInsuranceValue(insuranceValue) &
                CheckValidInsuranceInput.checkValidDateInsuranceCreated(dateInsuranceCreated) &
                CheckValidInsuranceInput.checkValidInsuranceConditions(insuranceConditions)) {

            this.insuranceId = customerId;
            this.insuranceAmount = insuranceAmount;
            this.insuranceValue = insuranceValue;
            this.insuranceConditions = insuranceConditions;
            this.dateInsuranceCreated = dateInsuranceCreated;
        }

    } */

    public abstract String giveInsuranceType();

    private String constructInsuranceNumber(String customerId) {
        String insId = customerId;
        int inID = insuranceNumberIterator(customerId);
        DecimalFormat f = new DecimalFormat("000");
        String newID = f.format(inID);
        if(giveInsuranceType().substring(0,1).equals("H")) {
            insId+="H"+newID;}
        if(giveInsuranceType().substring(0,1).equals("B")) {
            insId+="B"+newID;}
        if(giveInsuranceType().substring(0,1).equals("R")) {
            insId+="R"+newID;}

            //TODO implementer metode som løper igjennom kundens forsikringer
            // og nummererer løpende om kunden har forsikring av samme type fra før.


    return insId;
    }

    public int insuranceNumberIterator(String customerId){
        int newID = 1;
        for(HouseInsurance hi : MyArrays.HouseInsuranceListscsv()) {
            if((hi.getInsuranceId().substring(0,4)).equals(customerId)){
                if(Integer.parseInt(hi.getInsuranceId().substring(5)) >= newID){
                    newID = (Integer.parseInt(hi.getInsuranceId().substring(5)))+1;
                }
            }
        }
        for(BoatInsurance bi : MyArrays.BoatInsuranceListscsv()) {
            if((bi.getInsuranceId().substring(0,4)).equals(customerId)){
                if(Integer.parseInt(bi.getInsuranceId().substring(5)) >= newID){
                    newID = (Integer.parseInt(bi.getInsuranceId().substring(5)))+1;
                }
            }
        }
        for(TravelInsurance ti : MyArrays.TravelInsuranceListscsv()) {
            if((ti.getInsuranceId().substring(0,4)).equals(customerId)){
                if(Integer.parseInt(ti.getInsuranceId().substring(5)) >= newID){
                    newID = (Integer.parseInt(ti.getInsuranceId().substring(5)))+1;
                }
            }
        }
        return newID;
    }

    //Get-metoder for å hente variable i eksisterende objekt:

    public String getInsuranceId() {
        return insuranceId;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public double getInsuranceValue() {
        return insuranceValue;
    }

    public Calendar getDateInsuranceCreated() {
        return dateInsuranceCreated;
    }

    public String getInsuranceConditions() {
        return insuranceConditions;
    }
    public String getInsuranceType() {
        //TODO Pass på her at customerId alltid må ha fire siffer !!
        String insuranceType="";
        if(this.insuranceId.substring(4,5).equals("H")) {
            insuranceType="Husforsikring";
        }
        if(this.insuranceId.substring(4,5).equals("B")) {
            insuranceType="Båtforsikring";
        }
        if(this.insuranceId.substring(4,5).equals("R")) {
            insuranceType="Reiseforsikring";
        }
        return insuranceType;
    }


    //Set-metoder:


    public void setInsuranceId(int insuranceId) {
        try {
            if (CheckValidInsuranceInput.checkValidInsuranceNumber(insuranceId)) {
                this.insuranceId = Integer.toString(insuranceId);
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setInsuranceAmount(double insuranceAmount) {
        try {
            if (CheckValidInsuranceInput.checkValidInsuranceAmount(insuranceAmount)) {
                this.insuranceAmount = insuranceAmount;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println("Input is not valid");
        }
    }

    public void setInsuranceValue(double insuranceValue) {
        try {
            if (CheckValidInsuranceInput.checkValidInsuranceValue(insuranceValue)) {
                this.insuranceValue = insuranceValue;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println("Input is not valid");
        }

    }

    public void setDateInsuranceCreated(MyDate dateInsuranceCreated) {
        try {
            if (CheckValidInsuranceInput.checkValidDateInsuranceCreated(dateInsuranceCreated)) {
                this.dateInsuranceCreated = dateInsuranceCreated;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println("Input is not valid");
        }
    }

    public void setInsuranceConditions(String insuranceConditions) {
        try {
            if (CheckValidInsuranceInput.checkValidInsuranceConditions(insuranceConditions)) {
                this.insuranceConditions = insuranceConditions;
            }
        } catch (InvalidInsuranceInputException e) {
            System.err.println("Input is not valid");
        }

    }

    /*Tostring for testing */
    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceId + "\n" +
                ", insuranceAmount=" + insuranceAmount + "\n" +
                ", insuranceValue=" + insuranceValue + "\n" +
                ", dateInsuranceCreated=" + dateInsuranceCreated.getTime() + "\n" +
                ", insuranceConditions='" + insuranceConditions + '\'' +
                '}';
    }
}
