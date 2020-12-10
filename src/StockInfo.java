package readFileCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockInfo extends InputRead{

	private String Date;
	private String CodeStock;
	private double OpenPrice, ClosePrice, HighPrice, LowPrice, Volume;
	
	public String getDate() {
		return Date;
	}
	public String getCodeStock() {
		return CodeStock;
	}
	public double getOpenPrice() {
		return OpenPrice;
	}
	public double getClosePrice() {
		return ClosePrice;
	}
	public double getHighPrice() {
		return HighPrice;
	}
	public double getLowPrice() {
		return LowPrice;
	}
	public double getVolume() {
		return Volume;
	}
	public List<StockInfo> getStockInfoList() {
		return StockInfoList;
	}
	public StockInfo() {
		
	}
	public String toString()
	{
		return Date + " " + CodeStock + " " + OpenPrice + " " + ClosePrice + " " + HighPrice + " " + LowPrice + " " + Volume;
	}
	public StockInfo(String Date, String CodeStock, double OpenPrice, double ClosePrice, double HighPrice, double LowPrice, double Volume)
	{
		this.Date = Date;
		this.CodeStock = CodeStock;
		this.OpenPrice = OpenPrice;
		this.ClosePrice = ClosePrice;
		this.HighPrice = HighPrice;
		this.LowPrice = LowPrice;
		this.Volume = Volume;
	}
	List<StockInfo> StockInfoList = new ArrayList<>();
	@Override
	void read() {
		// TODO Auto-generated method stub
//	     File directoryPath = new File("C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\data");
//	      //List of all files and directories
//	     File filesList[] = directoryPath.listFiles();
//	      System.out.println("List of files and directories in the specified directory:");
	      for(File file : filesList) 
	      {
	        String path = "C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\data\\" + file.getName();
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
					StockInfoList.add(listLine);
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	      }
	}
	public static void main(String args[])
	{
		StockInfo st = new StockInfo();
		st.read();
		Iterator<StockInfo> iter;
		for (iter  = st.StockInfoList.iterator(); iter.hasNext();)
		{
			StockInfo temp = iter.next();
			if (temp.getCodeStock().equals("BID"))
			{
				System.out.println(temp.toString());
			}
		}

	}
	
}
