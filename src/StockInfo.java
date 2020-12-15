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
//		this.StockInfoList = getData();
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
	
//	List<StockInfo> StockInfoList = new ArrayList<>();
	
//	List<StockInfo>  getData() {
////		List<StockInfo> StockInfoList = new ArrayList<>();
////		Iterator<StockInfo> iter;
//		FileInfo data = new FileInfo();
//		data.read();
//		return data.FileInfoList;		
	}
//	
//	StockInfo getYesterday(StockInfo today)
//	{
//		ListIterator<StockInfo> iter;
//		int iterIdx = 0;
//		
//		
//	 
//		for (iter  = StockInfoList.listIterator(); iter.hasNext() ;)
//		{
//			
//			if (StockInfoList.get(iterIdx) == today) 
//				break;
//			iterIdx = iter.nextIndex();
//			
//			iter.next();
//		}
//		
//		return StockInfoList.get(iterIdx + 1);
//
//	}
//	StockInfo getKDaysBefore(StockInfo today, int k)
//	{
//		ListIterator<StockInfo> iter;
//		int iterIdx = 0;
//		
//		for (iter  = StockInfoList.listIterator(); iter.hasNext() ;)
//		{
//			
//			if (StockInfoList.get(iterIdx) == today) 
//				break;
//			iterIdx = iter.nextIndex();
//			
//			iter.next();
//		}
//		if (iterIdx + k < StockInfoList.size())
//			return StockInfoList.get(iterIdx + k);
//		else
//			return null;
//	}

	

//	public static void main(String args[])
//	{
//		StockInfo st = new StockInfo();
//		String str = new String();
//		try
//		{
//		File FileDir = new File("C:\\Users\\Admin\\Desktop\\Java_OOP\\BTL_OOP\\data\\sentence1.txt");
//		BufferedReader in = new BufferedReader(
//				   new InputStreamReader(
//		                      new FileInputStream(FileDir), "UTF8"));
//		int k;
//		while ((str = in.readLine()) != null)
//		{
//			k = k+1;
//		}
//		for
//		str = in.readLine();	
//		ListIterator<StockInfo> iter;
//		String day = "26/03/2020";
//		st.StockInfoList = st.getData();
//		int m = 0;
//		for (iter  = st.StockInfoList.listIterator(); iter.hasNext();)
//		{
//			
//			int iterIdx = iter.nextIndex();
//			if (iterIdx >= st.StockInfoList.size() - 1) 
//				break;
//			StockInfo temp = st.StockInfoList.get(iterIdx);
////		
////			
//			StockInfo tempYTD = st.StockInfoList.get(iterIdx + 1);
//			m += 1;
//			if (tempYTD != null && temp.getCodeStock().equals("VNM") && temp.getDate().equals(day))
//			{
//				if (tempYTD.getClosePrice() > temp.getClosePrice())
//				{
//					System.out.println("Close price of " + tempYTD.CodeStock + " on " + tempYTD.getDate() + " is lower than" + " close price of " + temp.CodeStock + " on " + tempYTD.getDate());
//				}
//				if (tempYTD.getClosePrice() < temp.getClosePrice())
//				{
//					System.out.println("Close price of " + tempYTD.CodeStock + " on " + tempYTD.getDate() + " is higher than" + " close price of " + temp.CodeStock + " on " + temp.getDate());
//				}
//				if (tempYTD.getClosePrice() == temp.getClosePrice())
//				{
//					System.out.println("Close price of " + tempYTD.CodeStock + " on " + tempYTD.getDate() + " is equal to " + " close price of " + temp.CodeStock + " on " + temp.getDate());
//				}
//			
//			}
////		
//			iter.next();
//			
////			String result = MessageFormat.format(str, temp.Date, temp.CodeStock, temp.OpenPrice, temp.ClosePrice * 1000, temp.HighPrice, temp.LowPrice, Math.round((temp.Volume / 1000000.0) * 100.0) / 100.0
////														);
////			System.out.println(result);			
//		}
////		System.out.println(st.StockInfoList.size() + " " + m);
//		}
//		catch (UnsupportedEncodingException e)
//		{
//			System.out.println(e.getMessage());
//		}
//	    catch (IOException e)
//	    {
//			System.out.println(e.getMessage());
//	    }
//	    catch (Exception e)
//	    {
//			System.out.println(e.getMessage());
//	    }
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
