package Programutvikling.Model.Writers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OverwriteCSVfile {
    //Brukes for å slette/endre objekt fra fil(Append er ikke satt til true, og vil derfor overskrive)
    public static void overwriter(ArrayList objects, File filepath) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
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

    //Tar inn ArrayList og Filepath for å overskrive fil
    public static void overWriteHelper(ArrayList arr, File filepath,String type){
        try {
            OverwriteCSVfile.overwriter(arr,filepath);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(type+" written to file");
        }
    }

}
