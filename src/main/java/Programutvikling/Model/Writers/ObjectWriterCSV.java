package Programutvikling.Model.Writers;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ObjectWriterCSV {

    public static void writeObjects(ArrayList objects, File filepath) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath, true);
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

}
