package modelingdata.stockinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StockList {
	public List<StockInfo> stockInfoList = new ArrayList<>();
	
	public void setData(List<StockInfo> stockInfoList) {
//		List<StockInfo> stockInfoList = new ArrayList<>();
//		Iterator<StockInfo> iter;
//		FileInfo data = new FileInfo();
//		data.read();
		this.stockInfoList = stockInfoList;
//		return data.FileInfoList;
	}
	
	public StockInfo getYesterday(StockInfo today)
	{
		ListIterator<StockInfo> iter;
		int iterIdx = 0;
		
		
	 
		for (iter  = stockInfoList.listIterator(); iter.hasNext() ;)
		{
			
			if (stockInfoList.get(iterIdx) == today) 
				break;
			iterIdx = iter.nextIndex();
			
			iter.next();
		}
		
		return stockInfoList.get(iterIdx + 1);

	}
	
	public StockInfo getKDaysBefore(StockInfo today, int k)
	{
		ListIterator<StockInfo> iter;
		int iterIdx = 0;
		
		for (iter  = stockInfoList.listIterator(); iter.hasNext() ;)
		{
			
			if (stockInfoList.get(iterIdx) == today) 
				break;
			iterIdx = iter.nextIndex();
			
			iter.next();
		}
		if (iterIdx + k < stockInfoList.size())
			return stockInfoList.get(iterIdx + k);
		else
			return null;
	}
}
