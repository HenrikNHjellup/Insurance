package Programutvikling.Model.FilerForSletting;

import Programutvikling.Model.Customer.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface PersonWriter {
    void writePeople(ArrayList<Person> people, String path) throws IOException;
}

