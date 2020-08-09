package Programutvikling.Model.Readers;

import Programutvikling.Model.Customer.InvalidPersonFormatException;

import java.io.IOException;
import java.util.ArrayList;

public interface ObjectReaderInterface {
    static ArrayList readObjects(String path, String type) {
        ArrayList objectList = new ArrayList();
        return objectList;
    }
}
