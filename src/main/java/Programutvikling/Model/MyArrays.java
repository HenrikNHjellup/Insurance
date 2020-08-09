package Programutvikling.Model;

import java.io.*;
import java.util.ArrayList;


import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.BoatInsurance;
import Programutvikling.Model.Insurance.HouseInsurance;
import Programutvikling.Model.Insurance.Insurance;
import Programutvikling.Model.Insurance.TravelInsurance;
import Programutvikling.Model.Readers.ObjectReaderCSV;
import Programutvikling.Model.Readers.ObjectReaderJOBJ;
import Programutvikling.Model.FilerForSletting.TempForTesting.CustomerTemp;

public class MyArrays {
    public static ArrayList<Customer> customerList = new ArrayList<>();
    public static ArrayList insuranceArrayList = new ArrayList();
    public static ArrayList<AccidentReport> accidentReports = new ArrayList();
    public static ArrayList<Customer> getCustomerList() {
        return customerListscsv();
    }

    public static ArrayList getInsArrayList() {
        //insuranceArrayList = null;
        fillInsArray();
        return insuranceArrayList;
        //return insuranceArrayList;
    }
    public static ArrayList<AccidentReport> getAccidentReportList() {
        return accidentReports;
    }

    public static void fillInsArray(){
        ArrayList<Object> thisArrayList = new ArrayList();

        if(BoatInsuranceListscsv() != null) {
            for (BoatInsurance bi : BoatInsuranceListscsv()) {
                thisArrayList.add(bi);
            }
        }
        if(HouseInsuranceListscsv() != null) {
            for (HouseInsurance hi : HouseInsuranceListscsv()) {
                thisArrayList.add(hi);
            }
        }
        if(TravelInsuranceListscsv() != null) {
            for (TravelInsurance ti : TravelInsuranceListscsv()) {
                thisArrayList.add(ti);
            }
        }
        insuranceArrayList = thisArrayList;
    }

    public static ArrayList<Customer> customerListscsv() { //Leser inn kunde-objekter fra fil og returnerer et array
        ArrayList<Customer> thisArrayList = new ArrayList<>();
        try {
            thisArrayList =  ObjectReaderCSV.readObjects("objectFiles/customerObjects.csv", "Customer");

            if(thisArrayList != null) { //Setter customerList basert på nyeste lesing fra fil(Skal nok flyttes vekk herfra)
                customerList = thisArrayList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return thisArrayList;
    }


    //Kan fjernes
    public String[] fileList(){
        return null;
    }

    public static ArrayList<BoatInsurance> BoatInsuranceListscsv() { //Leser inn BoatInsurance-objekter fra fil og returnerer et array
        ArrayList<BoatInsurance> thisArrayList = new ArrayList<>();
        try {
            thisArrayList =  ObjectReaderCSV.readObjects("objectFiles/boatInsuranceObjects.csv", "BoatInsurance");

            /*if(thisArrayList != null) { //Setter insuranceList basert på nyeste lesing fra fil(Skal nok flyttes vekk herfra)
                insuranceArrayList = thisArrayList;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        return thisArrayList;
    }

    public static ArrayList<HouseInsurance> HouseInsuranceListscsv() { //Leser inn BoatInsurance-objekter fra fil og returnerer et array
        ArrayList<HouseInsurance> thisArrayList = new ArrayList<>();
        try {
            thisArrayList =  ObjectReaderCSV.readObjects("objectFiles/houseInsuranceObjects.csv", "HouseInsurance");

            /*if(thisArrayList != null) { //Setter insuranceList basert på nyeste lesing fra fil(Skal nok flyttes vekk herfra)
                insuranceArrayList = thisArrayList;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        return thisArrayList;
    }

    public static ArrayList<TravelInsurance> TravelInsuranceListscsv() { //Leser inn BoatInsurance-objekter fra fil og returnerer et array
        ArrayList<TravelInsurance> thisArrayList = new ArrayList<>();
        try {
            thisArrayList =  ObjectReaderCSV.readObjects("objectFiles/travelInsuranceObjects.csv", "TravelInsurance");

            /*if(thisArrayList != null) { //Setter insuranceList basert på nyeste lesing fra fil(Skal nok flyttes vekk herfra)
                insuranceArrayList = thisArrayList;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        return thisArrayList;
    }

    public static ArrayList<AccidentReport> AccidentReportListscsv() { //Leser inn AccidentReport-objekter fra fil og returnerer et array
            ArrayList<AccidentReport> thisArrayList = new ArrayList<>();
            try {
                thisArrayList = ObjectReaderCSV.readObjects("objectFiles/accidentReportObjects.csv", "AccidentReport");


            } catch (IOException e) {
                e.printStackTrace();
            }

            return thisArrayList;
        }



    public static ArrayList customerListsjobj() throws ClassNotFoundException { //Leser inn kunde-objekter fra fil og returnerer et array
        ArrayList<Customer> thisArrayList = new ArrayList<>();
        ArrayList<Object> inArrayList = new ArrayList<>();
        try {
            inArrayList =  ObjectReaderJOBJ.readObjects("objectFiles/customerObjects.jobj","Customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inArrayList;
        //thisArrayList.add();
        //return thisArrayList;
    }

    //TODO
    //GETSET


    /*public static ArrayList insurancesArray() {
        /*
        Bare en midlertidig testmetode som oppretter et par forsikringsobjekter og legger det i arrayet.
        Den returnerer et array som tas inn i en metode i InsuranceController
        */
       /* ArrayList<Insurance> insurances = new ArrayList<>();

        Calendar cal = Calendar.getInstance();

        BoatInsurance forsikring = null;


        try {
            forsikring = new BoatInsurance(1234, 1000,
                    1000, cal, "insuranceConditions/BoatInsuranceConditions_34243.pdf", "etternavn", "fornavn",
                    "qwe123", "seilbåt", "seil2000", 30, 1998, "seil");

            insurances.add(forsikring);

        } catch (InvalidInsuranceInputException e) {
            System.err.printf("exceptions fra subklasse : " + e.getMessage());
        }

        HouseInsurance husforsikring = null;
        try {
            husforsikring = new HouseInsurance(6541, 1000,
                    1000, cal, "insuranceConditions/BoatInsuranceConditions_34243.pdf", "Adresse", "Villa",
                    "reisverk", "middels", 120, 100_000_000,
                    250_000);
            insurances.add(husforsikring);

        } catch (InvalidInsuranceInputException e) {
            System.err.printf("exceptions fra subklasse : " + e.getMessage());
        }


        return insurances;
    }*/

    public static ArrayList customerArray() {
 /*
        Bare en midlertidig testmetode som oppretter et par customers og legger det i arrayet.
        Den returnerer et array som tas inn i en metode i InsuranceController
        */
        ArrayList<CustomerTemp> customers = new ArrayList<>();

        CustomerTemp kunde1 = new CustomerTemp("Simen","Skark","14");
        CustomerTemp kunde2 = new CustomerTemp("Petter","Pettersen","13");
        CustomerTemp kunde3 = new CustomerTemp("Ole","Olsen","12");


        customers.add(kunde1);
        customers.add(kunde2);
        customers.add(kunde3);


        return customers;
    }

}


