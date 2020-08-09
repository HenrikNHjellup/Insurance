package Programutvikling.Model.Insurance;



/*Klasse for forsikring av typen Hus og innbo */


import Programutvikling.Model.MyDate;

import java.util.Calendar;

public class HouseInsurance extends Insurance {
    private String houseAdress;// Kan denne lagres i array?
    private String buildingType; // Type bygning
    private String construction; // evt buildingMaterial
    private String buildingStandard; //Hva skal legges i denne? Kanskje vi gjør det enkelt og forutsetter feks lav, middels høy...
    private int buildingArea; //antall kvadratmeter
    private int insuranceAmountBuilding; // Forsikringssum bygning
    private int insuranceAmountHousehold;// Forsikringssum innbo (hvis ikke dette skilles ut som egen klasse


    //Konstruktør :

    public HouseInsurance(String customerID,
                          double insuranceAmount,
                          double insuranceValue,
                          MyDate dateInsuranceCreated,
                          String insuranceConditions,
                          String houseAdress,
                          String buildingType,
                          String construction,
                          String buildingStandard,
                          int buildingArea,
                          int insuranceValueBuilding,
                          int insuranceValueHousehold) throws InvalidInsuranceInputException {

        super(customerID, insuranceAmount, insuranceValue, dateInsuranceCreated, insuranceConditions);

        if (CheckValidHouseInsuranceInput.CheckValidHouseAdress(houseAdress) &
                CheckValidHouseInsuranceInput.CheckValidBuildingType(buildingType) &
                CheckValidHouseInsuranceInput.CheckValidConstruction(construction) &
                CheckValidHouseInsuranceInput.CheckValidBuildingStandard(buildingStandard) &
                CheckValidHouseInsuranceInput.CheckValidBuildingArea(buildingArea) &
                CheckValidHouseInsuranceInput.CheckValidInsuranceAmountBuiliding(insuranceValueBuilding) &
                CheckValidHouseInsuranceInput.CheckValidInsureAmountHousehold(insuranceValueHousehold)) {

            this.houseAdress = houseAdress;
            this.buildingType = buildingType;
            this.construction = construction;
            this.buildingStandard = buildingStandard;
            this.buildingArea = buildingArea;
            this.insuranceAmountBuilding = insuranceValueBuilding;
            this.insuranceAmountHousehold = insuranceValueHousehold;
        }
    }
    //Forrige metode er overloadet for å kunne håndtere customerId som Integer
    // og insuranceId som String
    /*public HouseInsurance(String insuranceNumber,
                          double insuranceAmount,
                          double insuranceValue,
                          MyDate dateInsuranceCreated,
                          String insuranceConditions,
                          String houseAdress,
                          String buildingType,
                          String construction,
                          String buildingStandard,
                          int buildingArea,
                          int insuranceValueBuilding,
                          int insuranceValueHousehold) throws InvalidInsuranceInputException {

        super(insuranceNumber, insuranceAmount, insuranceValue, dateInsuranceCreated, insuranceConditions);

        if (CheckValidHouseInsuranceInput.CheckValidHouseAdress(houseAdress) &
                CheckValidHouseInsuranceInput.CheckValidBuildingType(buildingType) &
                CheckValidHouseInsuranceInput.CheckValidConstruction(construction) &
                CheckValidHouseInsuranceInput.CheckValidBuildingStandard(buildingStandard) &
                CheckValidHouseInsuranceInput.CheckValidBuildingArea(buildingArea) &
                CheckValidHouseInsuranceInput.CheckValidInsuranceAmountBuiliding(insuranceValueBuilding) &
                CheckValidHouseInsuranceInput.CheckValidInsureAmountHousehold(insuranceValueHousehold)) {

            this.houseAdress = houseAdress;
            this.buildingType = buildingType;
            this.construction = construction;
            this.buildingStandard = buildingStandard;
            this.buildingArea = buildingArea;
            this.insuranceAmountBuilding = insuranceValueBuilding;
            this.insuranceAmountHousehold = insuranceValueHousehold;
        }
    }*/

    //Get-metoder for å vise variable i eksisterende objekt:

    public String getHouseAdress() {
        return houseAdress;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public String getConstruction() {
        return construction;
    }

    public String getBuildingStandard() {
        return buildingStandard;
    }

    public int getBuildingArea() {
        return buildingArea;
    }

    public int getInsuranceAmountBuilding() {
        return insuranceAmountBuilding;
    }

    public int getInsuranceAmountHousehold() {
        return insuranceAmountHousehold;
    }




    //Set-metoder:

    @Override
    public String giveInsuranceType() {
        return "Husforsikring";
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
        buffer.append(houseAdress);
        buffer.append(";");
        buffer.append(buildingType);
        buffer.append(";");
        buffer.append(construction);
        buffer.append(";");
        buffer.append(buildingStandard);
        buffer.append(";");
        buffer.append(buildingArea);
        buffer.append(";");
        buffer.append(insuranceAmountBuilding);
        buffer.append(";");
        buffer.append(insuranceAmountHousehold);
        buffer.append(";");
        return buffer.toString();
    }
}




