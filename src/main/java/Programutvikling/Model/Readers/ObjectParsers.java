package Programutvikling.Model.Readers;

import Programutvikling.Model.AccidentReport;
import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.*;
import Programutvikling.Model.MyDate;
import Programutvikling.Model.Customer.InvalidPersonFormatException;

public class ObjectParsers {
    public static Object ObjectParser(String line, String type) { //Velger hvilken "parser den skal bruke ved input
                                                                  // "type"
        Object o = new Object();
        switch (type) {
            case "Customer":
                try {
                    o =  parseCustomer(line);
                } catch (InvalidPersonFormatException e) {
                    e.printStackTrace();
                }
                break;

            case "BoatInsurance":
                try {
                    parseBoatInsurance(line);
                } catch (InvalidBoatInsuranceInputException e) {
                    e.printStackTrace();
                }
                break;

            case "HouseInsurance":
                try {
                    parseHouseInsurance(line);
                } catch (InvalidInsuranceInputException e) {
                    e.printStackTrace();
                }
                break;

            case "TravelInsurance":
                try {
                    parseTravelInsurance(line);
                } catch (InvalidInsuranceInputException e) {
                    e.printStackTrace();
                }
                break;
            case "AccidentReport":
                try {
                    parseAccidentReport(line);
                } catch (InvalidAccidentReportInputException e) {
                    e.printStackTrace();
                }
                break;

        }
        return o;
    }
    public static Customer parseCustomer(String line) throws InvalidPersonFormatException {
        // split line string into three using the separator ";"
        String[] split = line.split(";");
        if(split.length != 11) {
            throw new InvalidPersonFormatException("Must use semicolon ; to separate the 11 data fields");
        }

        String customerID = split[0];
        MyDate date = new MyDate(Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        String firstName = split[4];
        String lastName = split[5];
        String phoneNumber = split[6];
        String email = split[7];
        String billingAdress = split[8];
        String billingPostalCode = split[9];
        String billingCity = split[10];

        Customer c = null;
        try {
            c = new Customer(customerID, date, firstName, lastName, phoneNumber,
                    email, billingAdress, billingPostalCode, billingCity);
        } catch (InvalidPersonFormatException e) {
            e.printStackTrace();
        }
        if (c == null) {
            throw new NullPointerException("CustomerObject has not been initialized properly");
        } else {
            return c;
        }
    }

    public static BoatInsurance parseBoatInsurance(String line) throws InvalidBoatInsuranceInputException {
        // split line string into three using the separator ";"
        String[] biSplit = line.split(";");
        if (biSplit.length != 15) {
            throw new InvalidBoatInsuranceInputException("Must use semicolon ; to separate the 15 data fields");
        }

        String insuranceID = biSplit[0];
        double insuranceAmount = Double.parseDouble(biSplit[1]);
        double insuranceValue = Double.parseDouble(biSplit[2]);
        MyDate dateInsuranceCreated = new MyDate(Integer.parseInt(biSplit[3]),Integer.parseInt(biSplit[4]),
                Integer.parseInt(biSplit[5]));
        String insuranceConditions = biSplit[6];
        String ownerLastName = biSplit[7];
        String ownerFirstName = biSplit[8];
        String registrationId = biSplit[9];
        String boatType = biSplit[10];
        String model = biSplit[11];
        int length = Integer.parseInt(biSplit[12]);
        int registrationYear = Integer.parseInt(biSplit[13]);
        String operation = biSplit[14];


        BoatInsurance bi = null;
        try {
            bi = new BoatInsurance(insuranceID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,
                    ownerLastName,ownerFirstName,registrationId,
                    boatType,model,length,registrationYear,
                    operation);
        } catch (InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
        if (bi == null) {
            throw new NullPointerException("BoatInsuranceObject has not been initialized properly");
        } else {
            return bi;
        }
    }

    public static HouseInsurance parseHouseInsurance(String line) throws InvalidInsuranceInputException {
        // split line string into three using the separator ";"
        String[] biSplit = line.split(";");
        if (biSplit.length != 14) {
            throw new InvalidInsuranceInputException("Must use semicolon ; to separate the 14 data fields");
        }

        String insuranceID = biSplit[0];
        double insuranceAmount = Double.parseDouble(biSplit[1]);
        double insuranceValue = Double.parseDouble(biSplit[2]);
        MyDate dateInsuranceCreated = new MyDate(Integer.parseInt(biSplit[3]),Integer.parseInt(biSplit[4]),
                Integer.parseInt(biSplit[5]));
        String insuranceConditions = biSplit[6];
        String houseAdress = biSplit[7];
        String buildingType = biSplit[8];
        String construction = biSplit[9];
        String buildingStandard = biSplit[10];
        int buildingArea = Integer.parseInt(biSplit[11]);
        int insuranceAmountBuilding = Integer.parseInt(biSplit[12]);
        int insuranceAmountHousehold = Integer.parseInt(biSplit[13]);

        HouseInsurance hi = null;
        try {
            hi = new HouseInsurance(insuranceID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,houseAdress,buildingType,construction,buildingStandard,
                    buildingArea,insuranceAmountBuilding,insuranceAmountHousehold);
        } catch (InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
        if (hi == null) {
            throw new NullPointerException("HouseInsuranceObject has not been initialized properly");
        } else {
            return hi;
        }
    }

    public static TravelInsurance parseTravelInsurance(String line) throws InvalidInsuranceInputException {
        // split line string into nine using the separator ";"
        String[] biSplit = line.split(";");
        if (biSplit.length != 9) {
            throw new InvalidInsuranceInputException("Must use semicolon ; to separate the 9 data fields");
        }

        String insuranceID = biSplit[0];
        double insuranceAmount = Double.parseDouble(biSplit[1]);
        double insuranceValue = Double.parseDouble(biSplit[2]);
        MyDate dateInsuranceCreated = new MyDate(Integer.parseInt(biSplit[3]),Integer.parseInt(biSplit[4]),
                Integer.parseInt(biSplit[5]));
        String insuranceConditions = biSplit[6];
        String insuranceRange = biSplit[7];
        int travelInsuranceAmount = Integer.parseInt(biSplit[8]);

        TravelInsurance ti = null;
        try {
            ti = new TravelInsurance(insuranceID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,insuranceRange,travelInsuranceAmount);
        } catch (InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
        if (ti == null) {
            throw new NullPointerException("TravelInsuranceObject has not been initialized properly");
        } else {
            return ti;
        }
    }

    public static AccidentReport parseAccidentReport(String line) throws InvalidAccidentReportInputException {
        // split line string into three using the separator ";"
        String[] biSplit = line.split(";");
        if (biSplit.length != 8) {
            throw new InvalidAccidentReportInputException("Must use semicolon ; to separate the 9 data fields");
        }
        MyDate accidentDate = new MyDate(Integer.parseInt(biSplit[0]),Integer.parseInt(biSplit[1]),
                Integer.parseInt(biSplit[2]));
        String accidentNumber = biSplit[3];
        String accidentType = biSplit[4];
        String accidentDescription = biSplit[5];
        double valuationAmount = Double.parseDouble(biSplit[6]);
        double paidCompansationAmount = Double.parseDouble(biSplit[7]);

        AccidentReport ar = null;
        try {
            ar = new AccidentReport(accidentDate,accidentNumber,
                    accidentType,accidentDescription,valuationAmount,
                    paidCompansationAmount);
        } catch (InvalidAccidentReportInputException e) {
            e.printStackTrace();
        }
        if (ar == null) {
            throw new NullPointerException("AccidentReportObject has not been initialized properly");
        } else {
            return ar;
        }
    }

    private static int parseNumber(String str, String errorMessage) throws InvalidPersonFormatException {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidPersonFormatException(errorMessage);
        }

        return number;
    }
}
