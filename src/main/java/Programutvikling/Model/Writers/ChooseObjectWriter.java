package Programutvikling.Model.Writers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseObjectWriter {
    public void chooseObjectWriterJOBJ(ArrayList<Object> objects, File filepath) {

        ObjectWriterJOBJ objectWriter = new ObjectWriterJOBJ();

        try {
            objectWriter.writeObjects(objects, filepath);
        } catch (IOException e) {
            System.err.println("Could not write to the requested file. Cause: " + e.getCause());
        }
    }

    public void chooseObjectWriterCSV(ArrayList<Object> objects, File filepath) {

        ObjectWriterCSV objectWriter = new ObjectWriterCSV();

        try {
            objectWriter.writeObjects(objects, filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
