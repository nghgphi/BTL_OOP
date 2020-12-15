package readFileCSV;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Sentence10 extends Sentence{
	
	StockInfo MaxVolume = new StockInfo();
	
	double TotalVolume = 0, TotalVolLastMonth = 0, TotalVolTwoMonthsAgo = 0, AveVolume = 0;
	
	
	@Override
	public void process(int Month) {
		StockList st = new StockList();
		// TODO Auto-generated method stub
		List<StockInfo> StockInMonth = new ArrayList<>();
		st.StockInfoList = st.getData();
		getSentence("sentence10");
//		System.out.println(str);
		ListIterator<StockInfo> iter;
//		double TotalVolume = 0;
		String Change1Month = null, Change2Months = null;
		double PercentChange1 = 0, PercentChange2 = 0,  days = 0;
		
//		MaxVolume = st.StockInfoList.get(0);
		
		for (iter = st.StockInfoList.listIterator(); iter.hasNext(); )
		{
			StockInfo temp = iter.next();
			String month = temp.getDate().substring(3, 5);
			
			
			if (Integer.parseInt(month)  == Month - 2)
				TotalVolTwoMonthsAgo += temp.getVolume();
			if (Integer.parseInt(month)  == Month - 1)
				TotalVolLastMonth += temp.getVolume();
			if (Integer.parseInt(month)  == Month)
			{
				TotalVolume += temp.getVolume();
				days += 1;
				if (MaxVolume.getVolume() < temp.getVolume())
				{
					MaxVolume = temp;
				}
				
			}
//				System.out.println(temp.toString());
			
		}
		
		AveVolume = TotalVolume / days;
		
		if (TotalVolume < TotalVolLastMonth)
		{
			Change1Month = "giảm";
			PercentChange1 = (1 - TotalVolume / TotalVolLastMonth) * 100; 
		}
		else
		{
			Change1Month = "tăng";
			PercentChange1 = (TotalVolume / TotalVolLastMonth - 1) * 100; 
		}
		
		if (TotalVolume < TotalVolTwoMonthsAgo)
		{
			Change1Month = "giảm";
			PercentChange1 = (1 - TotalVolume / TotalVolTwoMonthsAgo) * 100; 
		}
		else
		{
			Change2Months = "tăng";
			PercentChange2 = (TotalVolume / TotalVolTwoMonthsAgo - 1) * 100; 
		}
		
		String result = MessageFormat.format(str, 
				Change1Month, 
				Change2Months, 
				TotalVolume / 1000000000, 
				PercentChange1, 
				PercentChange2, 
				Month, 
				Month - 1, 
				Month - 2, 
				AveVolume / 1000000, 
				MaxVolume.getDate(), 
				MaxVolume.getVolume() / 1000000, 
				MaxVolume.getCodeStock());
		System.out.println(result);
		saveSentence(result, "sentence10");

		
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int Month = sc.nextInt();
//		String CodeStock = sc.next();
		Sentence10 st10 = new Sentence10();
		
		st10.process(Month);
//		sc.close();
		
	}
}
