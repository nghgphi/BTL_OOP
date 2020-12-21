package modelingdata.readfilecsv;

//import java.io.BufferedReader;
import java.io.File;
//import java.util.List;


public abstract class InputRead {
	String dir = System.getProperty("user.dir");

    File directoryPath = new File(dir + "\\data\\data");
    //List of all files and directories
    File filesList[] = directoryPath.listFiles();

	abstract void read();
}
