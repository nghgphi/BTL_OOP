package modelingdata.gensentence;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
//import java.util.Scanner;

import modelingdata.stockinfo.StockInfo;

public class Sentence9 extends Sentence{
	private StockInfo maxVolume = new StockInfo();
	private double maxAverageVol = Double.MIN_VALUE, minAverageVol = Double.MAX_VALUE, smallVol = 0;
	private String minAverageCode = null, maxAverageCode = null, smallCode = null;
	@Override
	public void process(String Date)
	{
//		StockList st = new StockList();
//		double maxAverageVol = Double.MIN_VALUE, minAverageVol = Double.MAX_VALUE;
	
		double Percent = 0, time = 0;
		getSentence("sentence9");
		
//		StockInfo StockToday = new StockInfo();
		List<StockInfo> StockTodayList = new ArrayList<>();
		ListIterator<StockInfo> iter;
		
//		st.StockInfoList = st.getData();
		

		for (iter = st.stockInfoList.listIterator(); iter.hasNext(); ){
			StockInfo temp = iter.next();
			
			if (temp.getDate().equals(Date)){
				StockTodayList.add(temp);
			}
		}
		
		
		for(iter = StockTodayList.listIterator(); iter.hasNext(); ){
			StockInfo stockTemp = iter.next();
			double totalVolume = 0;
			
			for (int i = 0; i < 10; i++){
				totalVolume += st.getKDaysBefore(stockTemp, i).getVolume();
			}
			
			if (maxVolume.getVolume() < stockTemp.getVolume()){
				maxVolume = stockTemp;
				time = stockTemp.getVolume() * 10 / totalVolume; // khối lượng giao dịch nhi�?u nhất gấp bao nhiêu lần khối lượng tb trong 10 ngày trở lại
			}
			
			if (minAverageVol > (totalVolume / 10)){
				minAverageVol = totalVolume / 10;
				minAverageCode = stockTemp.getCodeStock();
			}
			
			if (maxAverageVol < (totalVolume / 10)){
				maxAverageVol = totalVolume / 10;
				maxAverageCode = stockTemp.getCodeStock();
			}
			
			if (((totalVolume / 10) < 300000)){
				smallVol = totalVolume / 10;
				smallCode =  stockTemp.getCodeStock();
//				System.out.println("YES");
			}
			
		}
		Percent = (minAverageVol / maxAverageVol) * 100;
		
		String result = MessageFormat.format(str, 
				maxAverageCode, //0
				Math.round(maxAverageVol),//1 
				minAverageCode, //2
				Math.round(minAverageVol),//3 
				Percent,//4
				smallCode, //5
				Math.round(smallVol),//6 
				maxVolume.getCodeStock(), // 7 
				Math.round(maxVolume.getVolume() / 1000000),//8 
				time,
				Date);//9
//		System.out.println(result);
		saveSentence(result, "sentences");
//		System.out.println(minAverageCode + " : " + minAverageVol);
		//"tăng"

	}

}
