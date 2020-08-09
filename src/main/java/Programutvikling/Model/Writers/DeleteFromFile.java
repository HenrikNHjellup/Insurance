package Programutvikling.Model.Writers;

import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.BoatInsurance;
import Programutvikling.Model.Insurance.HouseInsurance;
import Programutvikling.Model.MyArrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//ChangeCOmmitt

public class DeleteFromFile {
    //Brukes for å slette objekt fra fil(Append er ikke satt til true, og vil derfor overskrive)
    public static void deleteWriteObjects(ArrayList objects, File filepath) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        PrintWriter writer = new PrintWriter(fileWriter);
        try {


            for (Object o : objects) {
                writer.println(o);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    //Sletter objekt med gitt identifier fra fil, ser automatisk hva slags objekt det skal slette
    public static void deleteObjectFromFile(String identifier){
        if(identifier.length() ==4){
            ArrayList<Customer> arr = MyArrays.getCustomerList();
            ArrayList<Customer> arrDelete = MyArrays.getCustomerList();
            int iterator = 0;
            for(Customer c : arr){
                if(c.getCustomerID().equals(identifier)){
                    arrDelete.remove(iterator);
                    System.out.println("Customer removed from array");
                }
                iterator++;
            }
            try {
                deleteWriteObjects(arrDelete,new File("objectFiles/customerObjects.csv"));

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Customers written to file");
            }
        }
        if(identifier.length() == 8) {
            if(identifier.substring(4,5).equals("H")){
                ArrayList<HouseInsurance> arr = MyArrays.HouseInsuranceListscsv();
                ArrayList<HouseInsurance> arrDelete = MyArrays.HouseInsuranceListscsv();
                int iterator = 0;
                for(HouseInsurance hi : arr){
                    if(hi.getInsuranceId().equals(identifier)){
                        arrDelete.remove(iterator);
                        System.out.println("HouseInsuranceObject removed from array");
                    }
                    iterator++;
                }
                try {
                    deleteWriteObjects(arrDelete,new File("objectFiles/houseInsuranceObjects.csv"));

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("HouseInsuranceObject written to file");
                }
            }
            if(identifier.substring(4,5).equals("B")){
                ArrayList<BoatInsurance> arr = MyArrays.BoatInsuranceListscsv();
                ArrayList<BoatInsurance> arrDelete = MyArrays.BoatInsuranceListscsv();
                int iterator = 0;
                for(BoatInsurance bi : arr){
                    if(bi.getInsuranceId().equals(identifier)){
                        arrDelete.remove(iterator);
                        System.out.println("BoatInsuranceObject removed from array");
                    }
                    iterator++;
                }
                try {
                    deleteWriteObjects(arrDelete,new File("objectFiles/boatInsuranceObjects.csv"));

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("BoatInsuranceObject written to file");
                }
            }
        }
    }
}
