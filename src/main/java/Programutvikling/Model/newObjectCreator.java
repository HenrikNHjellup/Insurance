package Programutvikling.Model;

import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.BoatInsurance;
import Programutvikling.Model.Insurance.HouseInsurance;
import Programutvikling.Model.Insurance.InvalidInsuranceInputException;
import Programutvikling.Model.Insurance.TravelInsurance;
import Programutvikling.Model.Readers.InvalidAccidentReportInputException;
import Programutvikling.Model.Writers.ObjectWriterCSV;
import Programutvikling.Model.Writers.ObjectWriterJOBJ;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class newObjectCreator {
    //Oppretter kunder og skriver dem til egen csv-fil
    public  static void customerCreator(String firstName, String lastName, String phoneNumber, String email,
                                 String billingAdress, String billingPostalCode, String billingCity) {
        ArrayList<Object> customerArrayList = new ArrayList<>();
        try {
            Customer customer = new Customer(firstName, lastName, phoneNumber, email, billingAdress, billingPostalCode,
                    billingCity);
            customerArrayList.add(customer);
            if (customer == null) {
                throw new NullPointerException("CustomerObject has not been initialized properly");
            } else {
                ObjectWriterCSV.writeObjects(customerArrayList, new File("objectFiles/customerObjects.csv"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Oppretter husforsikring og skriver dem til egen csv-fil
    public static void houseInsuranceCreator(String customerID, double insuranceAmount, double insuranceValue,
                                              MyDate dateInsuranceCreated, String insuranceConditions, String houseAdress,
                                              String buildingType, String construction, String buildingStandard,
                                              int buildingArea, int insuranceAmountBuilding,
                                              int insuranceAmountHousehold) throws InvalidInsuranceInputException{
        ArrayList<Object> houseInsuranceArrayList = new ArrayList<>();
        try {
            HouseInsurance hi = new HouseInsurance(customerID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,houseAdress,buildingType,construction,
                    buildingStandard,buildingArea,insuranceAmountBuilding,insuranceAmountHousehold);
            houseInsuranceArrayList.add(hi);
            try {
                if (hi == null) {
                    throw new NullPointerException("HouseInsuranceObject has not been initialized properly");
                } else {
                    ObjectWriterCSV.writeObjects(houseInsuranceArrayList,new File("objectFiles/houseInsuranceObjects.csv"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(hi);
        } catch (/*IOException | */InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
        MyArrays.fillInsArray();
    }
    //Oppretter Båtforsikring og skriver dem til egen csv-fil
    public  static void BoatInsuranceCreator(String customerID, double insuranceAmount, double insuranceValue,
                                             MyDate dateInsuranceCreated, String insuranceConditions,
                                             String ownerLastName, String ownerFirstName, String registrationId,
                                             String boatType, String model, int length, int registrationYear,
                                             String operation) {
        ArrayList<Object> boatInsuranceArrayList = new ArrayList<>();
        try {
            BoatInsurance bi = new BoatInsurance(customerID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,
                    ownerLastName,ownerFirstName,registrationId,
                    boatType,model,length,registrationYear,
                    operation);
            boatInsuranceArrayList.add(bi);
            if (bi == null) {
                throw new NullPointerException("BoatInsuranceObject has not been initialized properly");
            } else {
                ObjectWriterCSV.writeObjects(boatInsuranceArrayList, new File("objectFiles/boatInsuranceObjects.csv"));
            }
        } catch (IOException | InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
    }

    //Oppretter Reiseforsikring og skriver dem til egen csv-fil
    public  static void TravelInsuranceCreator(String customerID, double insuranceAmount, double insuranceValue,
                                             MyDate dateInsuranceCreated, String insuranceConditions,
                                               String insuranceRange,int travelInsuranceAmount) {
        ArrayList<Object> travelInsuranceArrayList = new ArrayList<>();
        try {
            TravelInsurance ti = new TravelInsurance(customerID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,insuranceRange,travelInsuranceAmount);
            travelInsuranceArrayList.add(ti);
            if (ti == null) {
                throw new NullPointerException("TravelInsuranceObject has not been initialized properly");
            } else {
                ObjectWriterCSV.writeObjects(travelInsuranceArrayList, new File("objectFiles/travelInsuranceObjects.csv"));
            }
        } catch (IOException | InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
    }

    //Oppretter Skademelding og skriver dem til egen csv-fil
    public  static void AccidentReportCreator(MyDate accidentDate, String insuranceID, String accidentType, String accidentDescription,
                                              int valuationAmount, int paidCompansationAmount) {
        ArrayList<Object> accidentReportArrayList = new ArrayList<>();
        try {
            AccidentReport ar = new AccidentReport(accidentDate,insuranceID,accidentType,accidentDescription,
                    valuationAmount,paidCompansationAmount);
            accidentReportArrayList.add(ar);
            if (ar == null) {
                throw new NullPointerException("AccidentReportObject has not been initialized properly");
            } else {
                ObjectWriterCSV.writeObjects(accidentReportArrayList, new File("objectFiles/accidentReportObjects.csv"));
            }
        } catch (IOException | InvalidAccidentReportInputException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("Duplicates")
    public  static void customerCreatorJOBJ(String firstName, String lastName, String phoneNumber, String email,
                                        String billingAdress, String billingPostalCode, String billingCity) {
        ArrayList<Object> customerArrayList = new ArrayList<>();
        try {
            Customer customer = new Customer(firstName, lastName, phoneNumber, email, billingAdress, billingPostalCode,
                    billingCity);
            customerArrayList.add(customer);
            ObjectWriterJOBJ.writeObjects(customerArrayList,new File("customerObjects.jobj"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static void houseInsuranceCreatorJOBJ(String customerID,
                                              double insuranceAmount,
                                              double insuranceValue,
                                              MyDate dateInsuranceCreated,
                                              String insuranceConditions,
                                              String houseAdress,
                                              String buildingType,
                                              String construction,
                                              String buildingStandard,
                                              int buildingArea,
                                              int insuranceAmountBuilding,
                                              int insuranceAmountHousehold) {
        ArrayList<Object> houseInsuranceArrayList = new ArrayList<>();
        try {
            HouseInsurance hi = new HouseInsurance(customerID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,houseAdress,buildingType,construction,
                    buildingStandard,buildingArea,insuranceAmountBuilding,insuranceAmountHousehold);
            houseInsuranceArrayList.add(hi);
            try {
                ObjectWriterJOBJ.writeObjects(houseInsuranceArrayList,new File("houseInsuranceObjects.jobj"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(hi);
        } catch (/*IOException | */InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
    }
    public  static void BoatInsuranceCreatorJOBJ(String customerID, double insuranceAmount, double insuranceValue,
                                             MyDate dateInsuranceCreated, String insuranceConditions,
                                             String ownerLastName, String ownerFirstName, String registrationId,
                                             String boatType, String model, int length, int registrationYear,
                                             String operation) {
        ArrayList<Object> boatInsuranceArrayList = new ArrayList<>();
        try {
            BoatInsurance bi = new BoatInsurance(customerID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,
                    ownerLastName,ownerFirstName,registrationId,
                    boatType,model,length,registrationYear,
                    operation);
            boatInsuranceArrayList.add(bi);
            ObjectWriterJOBJ.writeObjects(boatInsuranceArrayList,new File("boatInsuranceObjects.jobj"));
        } catch (IOException | InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
    }

    public  static void TravelInsuranceCreatorJOBJ(String customerID, double insuranceAmount, double insuranceValue,
                                               MyDate dateInsuranceCreated, String insuranceConditions,
                                               String insuranceRange,int travelInsuranceAmount) {
        ArrayList<Object> travelInsuranceArrayList = new ArrayList<>();
        try {
            TravelInsurance ti = new TravelInsurance(customerID,insuranceAmount, insuranceValue,
                    dateInsuranceCreated,insuranceConditions,insuranceRange,travelInsuranceAmount);
            travelInsuranceArrayList.add(ti);
            ObjectWriterJOBJ.writeObjects(travelInsuranceArrayList,new File("travelInsuranceObjects.jobj"));
        } catch (IOException | InvalidInsuranceInputException e) {
            e.printStackTrace();
        }
    }

    public  static void AccidentReportCreatorJOBJ(MyDate accidentDate, String accidentNumber, String accidentType, String accidentDescription,
                                              int valuationAmount, int paidCompansationAmount) {
        ArrayList<Object> accidentReportArrayList = new ArrayList<>();
        try {
            AccidentReport ar = new AccidentReport(accidentDate,accidentNumber,accidentType,accidentDescription,
                    valuationAmount,paidCompansationAmount);
            accidentReportArrayList.add(ar);
            ObjectWriterJOBJ.writeObjects(accidentReportArrayList,new File("accidentReportObjects.jobj"));
        } catch (IOException | InvalidAccidentReportInputException e) {
            e.printStackTrace();
        }
    }
}
