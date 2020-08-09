package Programutvikling.Model.FilerForSletting;

import Programutvikling.Model.Customer.Person;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonWriterSmall implements PersonWriter {

    @Override
    public void writePeople(ArrayList<Person> people, String path) throws IOException {
        List<String> data = new ArrayList<>();

        people.forEach(p -> data.add(p.toString()));

        Path file = Paths.get(path);
        Files.write(file, data, Charset.forName("UTF-8"));
    }
}
