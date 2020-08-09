package Programutvikling.Model.Writers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface ObjectWriterInterface {
    static void writeObjects(ArrayList<Object> objects, File filepath) throws IOException{};
}

