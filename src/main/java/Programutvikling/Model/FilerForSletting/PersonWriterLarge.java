package Programutvikling.Model.FilerForSletting;

import Programutvikling.Model.Customer.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PersonWriterLarge implements PersonWriter {
    @Override
    public void writePeople(ArrayList<Person> people, String path) throws IOException {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(path, "UTF-8");

            for (Person person : people) {
                writer.println(person);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
