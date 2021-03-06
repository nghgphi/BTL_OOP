package modelingdata.readfilecsv;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import modelingdata.stockinfo.StockInfo;

public class FileInfo extends InputRead {
	List<StockInfo> FileInfoList;
	
	public FileInfo() {
		FileInfoList = new ArrayList<>();
		read();
	}
	
	public List<StockInfo> getStockInfoList() {
		return FileInfoList;
	}
	
	@Override
	void read() {
		
//		StockInfo st = new StockInfo();
//		List<StockInfo> FileInfoList = new ArrayList<>();
		// TODO Auto-generated method stub
//	     File directoryPath = new File("C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\data");
//	      //List of all files and directories
//	     File filesList[] = directoryPath.listFiles();
//	      System.out.println("List of files and directories in the specified directory:");
//		List<StockInfo> FileInfoList = new ArrayList<>();
		String dir = System.getProperty("user.dir");

		for(File file : filesList) 
	      {
	        String path = dir + "\\data\\data\\" + file.getName();
			String line  = "";
			try 
			{
				BufferedReader br = new BufferedReader(new FileReader(path));
//				System.out.println("Read file successed");
				while((line = br.readLine()) != null)
				{
					String[] values = line.split(",");
					StockInfo listLine;
					listLine = new StockInfo(values[0], values[2], Double.parseDouble(values[3]), Double.parseDouble(values[1]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), Double.parseDouble(values[6]));
					FileInfoList.add(listLine);
				}
				br.close();
				
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	      }
	}
}