package Programutvikling.Model.Readers;

import Programutvikling.Model.AccidentReport;
import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.*;
import Programutvikling.Model.Customer.InvalidPersonFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Programutvikling.Model.Readers.ObjectParsers.*;


public class ObjectReaderCSV implements ObjectReaderInterface{

    public static ArrayList readObjects(String path, String type) throws IOException {

        ArrayList objectList = new ArrayList();

        switch (type) {
            case "Customer":
                ArrayList<Customer> customerObjectList = new ArrayList<>();
                BufferedReader customerReader = null;

                try {
                    customerReader = Files.newBufferedReader(Paths.get(path));
                    String line;

                    // Leser filen og oppretter objekt for hver linje, legger dem så i arrayet som skal returneres
                    while ((line = customerReader.readLine()) != null) {
                        try {
                            customerObjectList.add(parseCustomer(line));
                            System.out.println(parseCustomer(line));
                        } catch (InvalidPersonFormatException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (customerReader != null) {
                        customerReader.close();
                    }
                }
                objectList = customerObjectList;
                break;

            case "BoatInsurance":
                ArrayList<BoatInsurance> boatInsuranceObjectList = new ArrayList<>();
                BufferedReader boatInsuranceReader = null;

                try {
                    boatInsuranceReader = Files.newBufferedReader(Paths.get(path));
                    String insuranceLine;

                    // Leser filen og oppretter objekt for hver linje, legger dem så i arrayet som skal returneres
                    while ((insuranceLine = boatInsuranceReader.readLine()) != null) {
                        try {
                            boatInsuranceObjectList.add(parseBoatInsurance(insuranceLine));
                            System.out.println(parseBoatInsurance(insuranceLine));
                        } catch (InvalidBoatInsuranceInputException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (boatInsuranceReader != null) {
                        boatInsuranceReader.close();
                    }
                }
                objectList = boatInsuranceObjectList;
                break;

            case "HouseInsurance":
                ArrayList<HouseInsurance> houseInsuranceObjectList = new ArrayList<>();
                BufferedReader houseInsuranceReader = null;

                try {
                    houseInsuranceReader = Files.newBufferedReader(Paths.get(path));
                    String insuranceLine;

                    // Leser filen og oppretter objekt for hver linje, legger dem så i arrayet som skal returneres
                    while ((insuranceLine = houseInsuranceReader.readLine()) != null) {
                        try {
                            houseInsuranceObjectList.add(parseHouseInsurance(insuranceLine));
                            //System.out.println(parseBoatInsurance(insuranceLine));
                        } catch (InvalidInsuranceInputException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (houseInsuranceReader != null) {
                        houseInsuranceReader.close();
                    }
                }
                objectList = houseInsuranceObjectList;
                break;

            case "TravelInsurance":
                ArrayList<HouseInsurance> travelInsuranceObjectList = new ArrayList<>();
                BufferedReader travelInsuranceReader = null;

                try {
                    travelInsuranceReader = Files.newBufferedReader(Paths.get(path));
                    String insuranceLine;

                    // Leser filen og oppretter objekt for hver linje, legger dem så i arrayet som skal returneres
                    while ((insuranceLine = travelInsuranceReader.readLine()) != null) {
                        try {
                            travelInsuranceObjectList.add(parseHouseInsurance(insuranceLine));
                            System.out.println(parseTravelInsurance(insuranceLine));
                        } catch (InvalidInsuranceInputException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (travelInsuranceReader != null) {
                        travelInsuranceReader.close();
                    }
                }
                objectList = travelInsuranceObjectList;
                break;
            case "AccidentReport":
                ArrayList<AccidentReport> accidentReportObjectList = new ArrayList<>();
                BufferedReader accidentReportReader = null;

                try {
                    travelInsuranceReader = Files.newBufferedReader(Paths.get(path));
                    String insuranceLine;

                    // Leser filen og oppretter objekt for hver linje
                    while ((insuranceLine = travelInsuranceReader.readLine()) != null) {
                        try {
                            accidentReportObjectList.add(parseAccidentReport(insuranceLine));
                            System.out.println(parseAccidentReport(insuranceLine));
                        } catch (InvalidAccidentReportInputException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (accidentReportReader != null) {
                        accidentReportReader.close();
                    }
                }
                objectList = accidentReportObjectList;
                break;
        }
        return objectList;
    }


}
