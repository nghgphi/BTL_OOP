package modelingdata.gensentence;

import java.text.MessageFormat;
import java.util.ListIterator;

import modelingdata.stockinfo.StockInfo;

//import java.util.ListIterator;
//import java.util.Scanner;
//
//import readFileCSV.StockInfo;
import java.lang.Math;

public class Sentence7 extends Sentence {
	private StockInfo temp;
	private StockInfo tempYTD;
	private double percentDiff , percentFinal ; 
	
	public Sentence7() {
		temp = new StockInfo();
		tempYTD = new StockInfo();
		percentDiff = 0;
		percentFinal = 0;
	}
	@Override
	public void process(String CodeStock, String Date) {
//		st.stockInfoList = st.getData();
		int i = 0;
		
		ListIterator<StockInfo> iter;
		for (iter = st.stockInfoList.listIterator(); iter.hasNext(); iter.next())
		{
			
			int iterIdx = iter.nextIndex();
			if (iterIdx >= st.stockInfoList.size() - 1) 
				break;
			StockInfo temp = st.stockInfoList.get(iterIdx);     
			if (temp.getCodeStock().equals(CodeStock) && temp.getDate().equals(Date) &&
				st.stockInfoList.get(iterIdx + 1).getCodeStock() == st.stockInfoList.get(iterIdx).getCodeStock()) {
				
				this.temp = temp;
				this.tempYTD = st.stockInfoList.get(iterIdx + 1); 
				break;
			}
	    }
		
		if(temp.getClosePrice() > tempYTD.getClosePrice() && 
			temp.getLowPrice() < tempYTD.getClosePrice()) {
			
			getSentence("7toGreen");
			percentDiff = 100 - temp.getLowPrice() / tempYTD.getClosePrice() * 100;
			percentFinal = -100 + temp.getClosePrice() / tempYTD.getClosePrice() * 100;
			String result = MessageFormat.format(str, Date, CodeStock, percentDiff, percentFinal, Math.round(temp.getVolume() / 100000.0 * 100.0) / 100.0, 1000 * (temp.getClosePrice() - tempYTD.getClosePrice()));
			saveSentence(result, "sentences");
		}
			
		else if(st.stockInfoList.get(i).getClosePrice() < st.stockInfoList.get(i + 1).getClosePrice()
				&& st.stockInfoList.get(i).getHighPrice() > st.stockInfoList.get(i + 1).getClosePrice()) {
			getSentence("7toRed");
			percentDiff = -100 + st.stockInfoList.get(i).getHighPrice() / st.stockInfoList.get(i + 1).getClosePrice() * 100;
			percentFinal = 100 - st.stockInfoList.get(i).getClosePrice() / st.stockInfoList.get(i + 1).getClosePrice() * 100;
			String result = MessageFormat.format(str, Date, CodeStock, percentDiff, percentFinal, Math.round(temp.getVolume() / 100000.0 * 100.0) / 100.0, 1000 * (- temp.getClosePrice() + tempYTD.getClosePrice()));
			saveSentence(result, "sentences");
		}
	}
}


