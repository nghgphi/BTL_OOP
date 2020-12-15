package readFileCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StockList {
	List<StockInfo> StockInfoList = new ArrayList<>();
	
	List<StockInfo>  getData() {
//		List<StockInfo> StockInfoList = new ArrayList<>();
//		Iterator<StockInfo> iter;
		FileInfo data = new FileInfo();
		data.read();
		return data.FileInfoList;	
	}
	
	StockInfo getYesterday(StockInfo today)
	{
		ListIterator<StockInfo> iter;
		int iterIdx = 0;
		
		
	 
		for (iter  = StockInfoList.listIterator(); iter.hasNext() ;)
		{
			
			if (StockInfoList.get(iterIdx) == today) 
				break;
			iterIdx = iter.nextIndex();
			
			iter.next();
		}
		
		return StockInfoList.get(iterIdx + 1);

	}
	
	StockInfo getKDaysBefore(StockInfo today, int k)
	{
		ListIterator<StockInfo> iter;
		int iterIdx = 0;
		
		for (iter  = StockInfoList.listIterator(); iter.hasNext() ;)
		{
			
			if (StockInfoList.get(iterIdx) == today) 
				break;
			iterIdx = iter.nextIndex();
			
			iter.next();
		}
		if (iterIdx + k < StockInfoList.size())
			return StockInfoList.get(iterIdx + k);
		else
			return null;
	}
}
