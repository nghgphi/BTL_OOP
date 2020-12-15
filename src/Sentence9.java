package readFileCSV;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Sentence9 extends Sentence{
	private StockInfo MaxVolume = new StockInfo();
	private double MaxAverageVol = Double.MIN_VALUE, MinAverageVol = Double.MAX_VALUE, SmallVol = 0;
	private String MinAverageCode = null, MaxAverageCode = null, SmallCode = null;
	@Override
	public void process(String Date)
	{
		StockList st = new StockList();
//		double MaxAverageVol = Double.MIN_VALUE, MinAverageVol = Double.MAX_VALUE;
	
		double Percent = 0, time = 0;
		getSentence("sentence12");
		
//		StockInfo StockToday = new StockInfo();
		List<StockInfo> StockTodayList = new ArrayList<>();
		ListIterator<StockInfo> iter;
		
		st.StockInfoList = st.getData();
		

		for (iter = st.StockInfoList.listIterator(); iter.hasNext();)
		{
			StockInfo temp = iter.next();
			
			if (temp.getDate().equals(Date))
			{
				StockTodayList.add(temp);
			}
		}
		
		
		for(iter = StockTodayList.listIterator(); iter.hasNext(); )
		{
			StockInfo StockTemp = iter.next();
			double TotalVolume = 0;
			
			for (int i = 0; i < 10; i++)
			{
				TotalVolume += st.getKDaysBefore(StockTemp, i).getVolume();
			}
			
			if (MaxVolume.getVolume() < StockTemp.getVolume())
			{
				MaxVolume = StockTemp;
				time = StockTemp.getVolume() * 10 / TotalVolume; // khối lượng giao dịch nhiều nhất gấp bao nhiêu lần khối lượng tb trong 10 ngày trở lại
			}
			
			if (MinAverageVol > (TotalVolume / 10))
			{
				MinAverageVol = TotalVolume / 10;
				MinAverageCode = StockTemp.getCodeStock();
			}
			
			if (MaxAverageVol < (TotalVolume / 10))
			{
				MaxAverageVol = TotalVolume / 10;
				MaxAverageCode = StockTemp.getCodeStock();
			}
			
			if (((TotalVolume / 10) < 300000))
			{
				SmallVol = TotalVolume / 10;
				SmallCode =  StockTemp.getCodeStock();
//				System.out.println("YES");
			}
			
		}
		Percent = (MinAverageVol / MaxAverageVol) * 100;
		
		String result = MessageFormat.format(str, 
				MaxAverageCode, 
				Math.round(MaxAverageVol), 
				MinAverageCode, 
				Math.round(MinAverageVol), 
				Percent,
				SmallCode, 
				Math.round(SmallVol), 
				MaxVolume.getCodeStock(), 
				Math.round(MaxVolume.getVolume() / 1000000), 
				time);
		System.out.println(result);
		saveSentence(result, "sentence12");
//		System.out.println(MinAverageCode + " : " + MinAverageVol);
		//"tăng"

	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Sentence9 st9 = new Sentence9();
		String Date = sc.next();
//		String CodeStock = sc.next();
		
		
		st9.process(Date);
		sc.close();
//		System.out.println(st9.str);
	}
}
