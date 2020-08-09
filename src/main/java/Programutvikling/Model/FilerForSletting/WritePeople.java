package Programutvikling.Model.FilerForSletting;

import Programutvikling.Model.Customer.Person;

import java.io.IOException;
import java.util.ArrayList;

public class WritePeople {
    String path = "personObjects.csv";
    public void writePeople(PersonWriter writer, ArrayList<Person> people, String path) {
        try {
            writer.writePeople(people, path);
        } catch (IOException e) {
            System.err.println("Could not write people to file. Cause: " + e.getCause());
        }
    }

}
