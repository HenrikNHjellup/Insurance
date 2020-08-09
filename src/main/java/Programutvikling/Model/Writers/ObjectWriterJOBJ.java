package Programutvikling.Model.Writers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectWriterJOBJ {

    public static void writeObjects(ArrayList<Object> objects, File filepath) throws IOException {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(objects);
            objectOut.reset();
            objectOut.close();
            fileOut.close();
            System.out.println("The Object was succesfully written to a file");
        } finally {

        }
    }

}
