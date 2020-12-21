package modelingdata.gensentence;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
//import java.util.Scanner;

import modelingdata.stockinfo.StockInfo;

public class Sentence12 extends Sentence {
	
	private StockInfo decreaseMax, increaseMax = new StockInfo();
	private int increaseStock = 0, decreaseStock = 0, equalStock = 0, increasePercentStock = 0, decreasePercentStock = 0;
	private double decreaseMaxPercent = 0, increaseMaxPercent = 0;

	/**
	 *
	 */
	@Override
	public void process(String Date) {
		// TODO Auto-generated method stub
		getSentence("sentence12");

		List<StockInfo> StockTodayList = new ArrayList<>();
		ListIterator<StockInfo> iter;
//		StockList st = new StockList();
		
//		st.StockInfoList = st.getData();
		
//		System.out.println(st.stockInfoList.size());	
		for (iter = st.stockInfoList.listIterator(); iter.hasNext();){
			StockInfo temp = iter.next();
			
			if (temp.getDate().equals(Date)){
				StockTodayList.add(temp);
			}
		}

		
//		System.out.println(StockTodayList.size());
		
		decreaseMax = StockTodayList.get(0);
		increaseMax = StockTodayList.get(0);
//		
		
		for (iter = StockTodayList.listIterator(); iter.hasNext(); iter.next()){
//			System.out.println(iter.next().toString());
			StockInfo temp = StockTodayList.get(iter.nextIndex());
//			
			StockInfo tempYTD = st.getYesterday(temp);
			
//			System.out.println(tempYTD.getDate() + " " + tempYTD.getCodeStock());
			if (temp.getClosePrice() < tempYTD.getClosePrice()){
				decreaseStock += 1;
				if ((tempYTD.getClosePrice() - temp.getClosePrice()) > (st.getYesterday(decreaseMax).getClosePrice() - decreaseMax.getClosePrice())){
					decreaseMax = temp;
					decreaseMaxPercent = (1 - tempYTD.getClosePrice() / temp.getClosePrice()) * 100;
					}
				
			}
				
			if (temp.getClosePrice() > tempYTD.getClosePrice()){
				increaseStock += 1;
				if ((temp.getClosePrice() - tempYTD.getClosePrice()) > (increaseMax.getClosePrice() - st.getYesterday(increaseMax).getClosePrice())){
					increaseMax = temp;
					increaseMaxPercent = (temp.getClosePrice() / tempYTD.getClosePrice() - 1) * 100;
					}
					
				
			}
				
			if (temp.getClosePrice() == tempYTD.getClosePrice())
				equalStock += 1;
			
			if ((temp.getClosePrice() / tempYTD.getClosePrice()) > 1.05)
				increasePercentStock += 1;
			
			if ((temp.getClosePrice() / tempYTD.getClosePrice()) < 0.95)
				decreasePercentStock += 1;
		}
		
		String result = MessageFormat.format(str, 
				decreaseStock, //0
				equalStock, //1
				increaseStock,//2 
				Date, //3
				decreaseMax.getCodeStock(),//4 
				increaseMax.getCodeStock(), //5
				increasePercentStock, //6
				decreasePercentStock, //7
				decreaseMaxPercent, //8
				increaseMaxPercent);//9
		
//		System.out.println(result);
		saveSentence(result, "sentences");
	}
	
		
//	
//
//		
//	public static void main(String args[])
//	{
//		Sentence12 st1 = new Sentence12();
//		Scanner sc = new Scanner(System.in);
//		String today = sc.next();
//		st1.process(today);
////		st1.getSentence("sentence12");
//		sc.close();

		
//	}

}
