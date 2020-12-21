package modelingdata.gensentence;

import java.text.MessageFormat;
//import java.util.ListIterator;
//import java.util.Scanner;
//
//import readFileCSV.StockInfo;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ListIterator;

import modelingdata.stockinfo.StockInfo;

public class Sentence5 extends Sentence {
	private double percent = 0.0;
	private int days = 0;
	
	@Override
	public void process(String codeStock, String date) {
//		st.stockInfoList = st.getData();
		int i = 0;
		
		ListIterator<StockInfo> iter;
//		st.stockInfoList=st.getData();
		for (iter = st.stockInfoList.listIterator(); iter.hasNext();iter.next())
		{
			
			int iterIdx = iter.nextIndex();
			if (iterIdx >= st.stockInfoList.size() - 1) 
				break;
			StockInfo temp = st.stockInfoList.get(iterIdx);     
			if (temp.getCodeStock().equals(codeStock) && temp.getDate().equals(date)){
//				this.temp= temp;
				i = iterIdx;
				break;
			}
	    }
		
		if(st.stockInfoList.get(i).getClosePrice() > st.stockInfoList.get(i + 1).getClosePrice() &&
				i < st.stockInfoList.size() - 1) {
			getSentence("5up");
			percent = -100 + st.stockInfoList.get(i).getClosePrice()/st.stockInfoList.get(i + 1).getClosePrice() * 100;
			while (st.stockInfoList.get(i).getClosePrice() > st.stockInfoList.get(i + 1).getClosePrice() && 
					st.stockInfoList.get(i).getCodeStock() == st.stockInfoList.get(i + 1).getCodeStock() &&
					i < st.stockInfoList.size() - 1) {
				days++;
				i++;
				if (i>=st.stockInfoList.size()-1) break;
			}
		}
		else if(st.stockInfoList.get(i).getClosePrice() < st.stockInfoList.get(i + 1).getClosePrice() &&
				i < st.stockInfoList.size() - 1) {
			getSentence("5down");
			percent = 100 - st.stockInfoList.get(i).getClosePrice()/st.stockInfoList.get(i + 1).getClosePrice() * 100;
			while (st.stockInfoList.get(i).getClosePrice() < st.stockInfoList.get(i + 1).getClosePrice() && 
					st.stockInfoList.get(i).getCodeStock() == st.stockInfoList.get(i + 1).getCodeStock() &&
					i < st.stockInfoList.size() - 1) {
				days += 1;
				i++;
				if (i>=st.stockInfoList.size()-1) break;
			}
		}
		
		if (days > 3) {
			String result = MessageFormat.format(str, date, codeStock, days, percent);
		    saveSentence(result, "sentences");
		}
	}
}


