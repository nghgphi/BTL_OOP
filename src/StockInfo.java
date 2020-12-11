package readFileCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.text.MessageFormat;
import java.util.ListIterator;

import readFileCSV.FileInfo;

public class StockInfo {

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
//	public List<StockInfo> getStockInfoList() {
//		return StockInfoList;
//	}
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
	
	
	List<StockInfo>  getData() {
		List<StockInfo> StockInfoList = new ArrayList<>();
//		Iterator<StockInfo> iter;
		FileInfo data = new FileInfo();
		data.read();
//		for (iter  = data.FileInfoList.iterator(); iter.hasNext();)
//		{
//			StockInfo temp = iter.next();
//			StockInfoList.add(temp);
//		}
		return data.FileInfoList;		
	}
	
//	@Override
//	void read() {
//		// TODO Auto-generated method stub
////	     File directoryPath = new File("C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\data");
////	      //List of all files and directories
////	     File filesList[] = directoryPath.listFiles();
////	      System.out.println("List of files and directories in the specified directory:");
//	      for(File file : filesList) 
//	      {
//	        String path = "C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\data\\" + file.getName();
//			String line  = "";
//			try 
//			{
//				BufferedReader br = new BufferedReader(new FileReader(path));
////				System.out.println("Read file successed");
//				while((line = br.readLine()) != null)
//				{
//					String[] values = line.split(",");
//					StockInfo listLine;
//					listLine = new StockInfo(values[0], values[2], Double.parseDouble(values[3]), Double.parseDouble(values[1]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), Double.parseDouble(values[6]));
//					StockInfoList.add(listLine);
//				}
//			}catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}catch (IOException e) {
//				e.printStackTrace();
//			}
//	      }
//	}
	public static void main(String args[])
	{
		StockInfo st = new StockInfo();
		String str = new String();
		try
		{
		File FileDir = new File("C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\sentence1.txt");
		BufferedReader in = new BufferedReader(
				   new InputStreamReader(
		                      new FileInputStream(FileDir), "UTF8"));
		int k;
//		while ((str = in.readLine()) != null)
//		{
//			k = k+1;
//		}
//		for
		str = in.readLine();
		
		ListIterator<StockInfo> iter;
		for (iter  = st.getData().listIterator(); iter.hasNext();)
		{
			StockInfo temp = iter.next();
			
			StockInfo tempYTD = iter.next();
			if (tempYTD != null && temp.getCodeStock().equals("VNM") && temp.getDate().equals("25/03/2020"))
			{
				if (tempYTD.getClosePrice() > temp.getClosePrice())
				{
					System.out.println("giam");
				}
				if (tempYTD.getClosePrice() < temp.getClosePrice())
				{
					System.out.println("tang");
				}
				if (tempYTD.getClosePrice() == temp.getClosePrice())
				{
					System.out.println("dung");
				}
				
			}
		
			if (iter.hasPrevious())
			{
				iter.previous();
			}
//			String result = MessageFormat.format(str, temp.Date, temp.CodeStock, temp.OpenPrice, temp.ClosePrice * 1000, temp.HighPrice, temp.LowPrice, Math.round((temp.Volume / 1000000.0) * 100.0) / 100.0
//														);
//			System.out.println(result);
//			
		}
		}
		catch (UnsupportedEncodingException e)
		{
			System.out.println(e.getMessage());
		}
	    catch (IOException e)
	    {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
//		FileInfo fi = new FileInfo();
//		st.read();
//		Iterator<StockInfo> iter;

//		String pattern = "{1} hôm nay đứng giá {3} đồng với hơn {6} triệu đơn vị khối lượng giao dịch.";
		
//		for (iter  = st.getData().iterator(); iter.hasNext();)
//		{
//			StockInfo temp = iter.next();
//			if (temp.getCodeStock().equals("BID") && temp.getClosePrice() < 34)
//			{
//				String result = MessageFormat.format(str, temp.Date, temp.CodeStock, temp.OpenPrice, temp.ClosePrice * 1000, temp.HighPrice, temp.LowPrice, Math.round((temp.Volume / 1000000.0) * 100.0) / 100.0 );
//				System.out.println(result);
//			}
//		}

	}
	
}
