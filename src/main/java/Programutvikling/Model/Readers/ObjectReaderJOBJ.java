package Programutvikling.Model.Readers;

import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Customer.InvalidPersonFormatException;
import Programutvikling.Model.Insurance.*;
import Programutvikling.Model.MyDate;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Programutvikling.Model.Readers.ObjectParsers.*;
import static Programutvikling.Model.Readers.ObjectParsers.parseTravelInsurance;

public class ObjectReaderJOBJ implements ObjectReaderInterface{

    /**
     * Denne leser nå alle elementer fra fil og legger dem inn i arrayList */
    public static ArrayList readObjects(String path,String type) throws IOException, ClassNotFoundException {

        ArrayList objectList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            objectList = (ArrayList<Object>)objectIn.readObject();
            fileIn.close();
            objectIn.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }



        ArrayList<Object> outList = new ArrayList<>();
        //Switchen legger til objekter til arraylist, basert på hvilken type som er angitt
        switch (type) {
            case "Customer":
                for(Object o : objectList) {
                    Customer c = (Customer)o;
                    outList.add(c);
                }
                break;

            case "BoatInsurance":
                for(Object o : objectList) {
                    BoatInsurance c = (BoatInsurance)o;
                    outList.add(c);
                }
                break;

            case "HouseInsurance":
                for(Object o : objectList) {
                    HouseInsurance c = (HouseInsurance)o;
                    outList.add(c);
                }
                break;

            case "TravelInsurance":
                for(Object o : objectList) {
                    TravelInsurance c = (TravelInsurance)o;
                    outList.add(c);
                }
                break;
        }
        return outList;
    }





}
