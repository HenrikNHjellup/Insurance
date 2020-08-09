package Programutvikling.Model.Writers;

import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.BoatInsurance;
import Programutvikling.Model.Insurance.HouseInsurance;
import Programutvikling.Model.MyArrays;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class EditObjectFromFile {
    public static void editObjectFromFile(String identifier,ArrayList arrayList){
        //Hvis identifier tilsvarer en customerID vil denne bli valgt, og en kunde blir endret
        if(identifier.length() ==4){
            ArrayList<Customer> arr = MyArrays.getCustomerList();
            ArrayList<Customer> arrEdit = MyArrays.getCustomerList();
            int iterator = 0;
            for(Customer c : arr){
                if(c.getCustomerID().equals(identifier)){
                    arrEdit.remove(iterator);
                    System.out.println("Customer removed from array");
                }
                iterator++;
            }

            Customer customer = (Customer)arrayList.get(0);
            arrEdit.add(customer);
            OverwriteCSVfile.overWriteHelper(arrEdit,new File("objectFiles/customerObjects.csv"),"Customer");
        }

        //Hvis identifier tilsvarer en insuranceID vil denne bli valgt, og en type forsikring blir endret
        if(identifier.length() == 8) {

            //Velger denne for å endre husforsikring, hvis substring inneholder h (HouseInsurance)
            if(identifier.substring(4,5).equals("H")){
                ArrayList<HouseInsurance> arr = MyArrays.HouseInsuranceListscsv();
                ArrayList<HouseInsurance> arrEdit = MyArrays.HouseInsuranceListscsv();
                int iterator = 0;
                for(HouseInsurance hi : arr){
                    if(hi.getInsuranceId().equals(identifier)){
                        arrEdit.remove(iterator);
                        System.out.println("HouseInsuranceObject removed from array");
                    }
                    iterator++;
                }

                HouseInsurance hi = (HouseInsurance)arrayList.get(0);
                arrEdit.add(hi);
                OverwriteCSVfile.overWriteHelper(arrEdit,new File("objectFiles/houseInsuranceObjects.csv"),
                            "HouseInsuranceObject");

            }

            //Velger denne for å endre båtforsikring, hvis substring inneholder b (BoatInsurance)
            if(identifier.substring(4,5).equals("B")){
                ArrayList<BoatInsurance> arr = MyArrays.BoatInsuranceListscsv();
                ArrayList<BoatInsurance> arrEdit = MyArrays.BoatInsuranceListscsv();
                int iterator = 0;
                for(BoatInsurance bi : arr){
                    if(bi.getInsuranceId().equals(identifier)){
                        arrEdit.remove(iterator);
                        System.out.println("BoatInsuranceObject removed from array");
                    }
                    iterator++;
                }

                BoatInsurance bi = (BoatInsurance)arrayList.get(0);
                arrEdit.add(bi);
                OverwriteCSVfile.overWriteHelper(arrEdit,new File("objectFiles/boatInsuranceObjects.csv"),
                            "BoatInsurance");

            }
        }
    }


}
