package Programutvikling.Model.Insurance;

/*

klasse for å beregne årlig forsikringsgebyr.

 */
public class ComputeInsuranceAmount {


    public static Double computeHouseInsuranceAmount(String buildingType, String construction, String standard,
                                              int area, int insuranceAmountBuilding, int insuranceAmountHouseHold) {
        double insuranceAmount = 0.0;

        double costPerArea;

        double costofBuildingtype = 0;
        double costofStandard = 0;
        double costofConstruction = 0;
        switch (buildingType) {
            case "Villa":
                costofBuildingtype = 3;
                break;
            case "Leilighet":
                costofBuildingtype = 2;
                break;
            case "Næringsbygg":
                costofBuildingtype = 4;
                break;
            case "Fritidsbolig":
                costofBuildingtype = 1;
                break;
        }

        switch (standard) {
            case "Lav":
                costofStandard = 0.7;
                break;
            case "Middels":
                costofStandard = 1.0;
                break;
            case "Høy":
                costofStandard = 1.3;
        }
        switch (construction) {
            case "Reisverk(tre)":
                costofConstruction = 1.0;
                break;
            case "Murstein":
                costofConstruction = 0.5;
                break;
            case "Stål/Betong":
                costofConstruction = 0.2;
                break;
            case "Laft(tre)":
                costofConstruction = 0.9;
                break;
            case "Papp":
                costofConstruction = 10;
        }

        //Formel for innbo:
        double ComputedInsuranceAmountBuilding = ((double) insuranceAmountHouseHold / 100000) *
                costofStandard * costofConstruction;


        //Formel for arealkostnad:
        costPerArea = costofBuildingtype * costofConstruction * costofStandard;

        // Formel for hus + innbo:
        insuranceAmount = ((double) insuranceAmountBuilding / 10000) *
                (area * costPerArea) + ComputedInsuranceAmountBuilding;

        //return String.format("%.2f",insuranceAmount);
        return insuranceAmount;

    }

    public static Double computeBoatInsuranceAmount(String boatType, String model, int numberofHorsePower,
                                                     int feet, int insuranceAmountBoat) {
        double insuranceAmount = 0.0;
        double costPerFoot;
        double costofBoatType = 0;
        double costofModel = 0;

        switch (boatType) {
            case "Robåt":
                costofBoatType = 1;
                break;
            case "Motorbåt":
                costofBoatType = 4;
                break;
            case "Seilbåt":
                costofBoatType = 6;
                break;
            case "Ubåt":
                costofBoatType = 12;
                break;
            case "Yacht":
                costofBoatType = 16;
                break;
            case "Fregatt":
                costofBoatType = 20;
        }

        switch (model) {
            case "Bertram":
                costofModel = 0.7;
                break;
            case "Lund":
                costofModel = 0.9;
                break;
            case "Pioner":
                costofModel = 1.1;
                break;
            case "Smart Rib":
                costofModel = 1.3;
                break;
            case "Yamarin":
                costofModel = 1.5;
        }

        //Formel for kostnad pr fot:
        costPerFoot = costofBoatType * numberofHorsePower * costofModel;

        // Formel for båtforsikring:
        insuranceAmount = ((double) insuranceAmountBoat / 10000) *
                (feet * costPerFoot);

        return insuranceAmount;
    }

    public static Double computeTravelInsuranceAmount(int insuranceAmountTravel) {
        double insuranceAmount = insuranceAmountTravel / 10;

        return insuranceAmount;
    }

}
