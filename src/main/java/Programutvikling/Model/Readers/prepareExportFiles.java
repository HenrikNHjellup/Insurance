package Programutvikling.Model.Readers;

import Programutvikling.Model.AccidentReport;
import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.BoatInsurance;
import Programutvikling.Model.Insurance.HouseInsurance;
import Programutvikling.Model.Insurance.TravelInsurance;
import Programutvikling.Model.Writers.ObjectWriterJOBJ;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//preparing export to jobjfile
public class prepareExportFiles {
    public static void prepareExportFiles() throws IOException {
        String customerPath = "objectFiles/customerObjects.jobj";
        String hiPath = "objectFiles/houseInsuranceObjects.jobj";
        String biPath = "objectFiles/boatInsuranceObjects.jobj";
        String tiPath = "objectFiles/travelInsuranceObjects.jobj";
        String arPath = "objectFiles/accidentReportObjects.jobj";

        ArrayList<Object> customerList = ObjectReaderCSV.readObjects("objectFiles/customerObjects.csv",
                "Customer");

        ArrayList<Object> houseInsuranceList = ObjectReaderCSV.readObjects("objectFiles/houseInsuranceObjects.csv",
                "HouseInsurance");

        ArrayList<Object> boatInsuranceList = ObjectReaderCSV.readObjects("objectFiles/boatInsuranceObjects.csv",
                "BoatInsurance");

        ArrayList<Object> travelInsuranceList = ObjectReaderCSV.readObjects("objectFiles/travelInsuranceObjects.csv",
                "TravelInsurance");

        ArrayList<Object> accidentReportList = ObjectReaderCSV.readObjects("objectFiles/accidentReportObjects.csv",
                "AccidentReport");

        ObjectWriterJOBJ.writeObjects(customerList,new File(customerPath));
        ObjectWriterJOBJ.writeObjects(houseInsuranceList,new File(hiPath));
        ObjectWriterJOBJ.writeObjects(boatInsuranceList,new File(biPath));
        ObjectWriterJOBJ.writeObjects(travelInsuranceList,new File(tiPath));
        ObjectWriterJOBJ.writeObjects(accidentReportList,new File(arPath));
    }
}
