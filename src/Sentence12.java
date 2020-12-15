package readFileCSV;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Sentence12 extends Sentence {
	
	private StockInfo DecreaseMax, IncreaseMax = new StockInfo();
	private int IncreaseStock = 0, DecreaseStock = 0, EqualStock = 0, IncreasePercentStock = 0, DecreasePercentStock = 0;
	private double DecreaseMaxPercent = 0, IncreaseMaxPercent = 0;

	@Override
	public void process(String Date) {
		// TODO Auto-generated method stub
		getSentence("sentence12");

		List<StockInfo> StockTodayList = new ArrayList<>();
		ListIterator<StockInfo> iter;
		StockList st = new StockList();
		
		st.StockInfoList = st.getData();
		
		System.out.println(st.StockInfoList.size());	
		for (iter = st.StockInfoList.listIterator(); iter.hasNext();)
		{
			StockInfo temp = iter.next();
			
			if (temp.getDate().equals(Date))
			{
				StockTodayList.add(temp);
			}
		}

		
		System.out.println(StockTodayList.size());
		
		DecreaseMax = StockTodayList.get(0);
		IncreaseMax = StockTodayList.get(0);
//		
		
		for (iter = StockTodayList.listIterator(); iter.hasNext(); iter.next())
		{
//			System.out.println(iter.next().toString());
			StockInfo temp = StockTodayList.get(iter.nextIndex());
//			
			StockInfo tempYTD = st.getYesterday(temp);
			
//			System.out.println(tempYTD.getDate() + " " + tempYTD.getCodeStock());
			if (temp.getClosePrice() < tempYTD.getClosePrice())
			{
				DecreaseStock += 1;
				if ((tempYTD.getClosePrice() - temp.getClosePrice()) > (st.getYesterday(DecreaseMax).getClosePrice() - DecreaseMax.getClosePrice()))
					{
					DecreaseMax = temp;
					DecreaseMaxPercent = (1 - tempYTD.getClosePrice() / temp.getClosePrice()) * 100;
					}
				
			}
				
			if (temp.getClosePrice() > tempYTD.getClosePrice())
			{
				IncreaseStock += 1;
				if ((temp.getClosePrice() - tempYTD.getClosePrice()) > (IncreaseMax.getClosePrice() - st.getYesterday(IncreaseMax).getClosePrice()))
					{
					IncreaseMax = temp;
					IncreaseMaxPercent = (1 - temp.getClosePrice() / tempYTD.getClosePrice()) * 100;
					}
					
				
			}
				
			if (temp.getClosePrice() == tempYTD.getClosePrice())
				EqualStock += 1;
			
			if ((temp.getClosePrice() / tempYTD.getClosePrice()) > 1.05)
				IncreasePercentStock += 1;
			
			if ((temp.getClosePrice() / tempYTD.getClosePrice()) < 0.95)
				DecreasePercentStock += 1;
		}
		
		String result = MessageFormat.format(str, 
				DecreaseStock, 
				EqualStock, 
				IncreaseStock, 
				Date, 
				DecreaseMax.getCodeStock(), 
				IncreaseMax.getCodeStock(), 
				IncreasePercentStock, 
				DecreasePercentStock, 
				DecreaseMaxPercent, 
				IncreaseMaxPercent);
		
		System.out.println(result);
		saveSentence(result, "sentence12");
	}
	
		
	

		
	public static void main(String args[])
	{
		Sentence12 st1 = new Sentence12();
		Scanner sc = new Scanner(System.in);
		String today = sc.next();
		st1.process(today);
//		st1.getSentence("sentence12");
		sc.close();

		
	}

}
