package readFileCSV;

import java.io.BufferedReader;
import java.io.File;
import java.util.List;


public abstract class InputRead {
    File directoryPath = new File("C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\data");
    //List of all files and directories
    File filesList[] = directoryPath.listFiles();

	abstract void read();
}
