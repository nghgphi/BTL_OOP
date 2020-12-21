package modelingdata.gensentence;

import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import modelingdata.stockinfo.StockInfo;

public class Sentence10 extends Sentence{
	
	StockInfo maxVolume = new StockInfo();
	double totalVolume = 0, totalVolLastMonth = 0, aveVolume = 0;
	String change1Month = null;
	double percentChange1 = 0,  days = 0;

	
	public void process(int Month) {

		getSentence("sentence10");

		ListIterator<StockInfo> iter;

//		String change1Month = null, change2Months = null;
//		double percentChange1 = 0, percentChange2 = 0,  days = 0;
		
//		maxVolume = st.StockInfoList.get(0);
		
		String str1 = "Cụ thể, tổng <khối lượng giao dịch| chứng khoán trong <tháng {5}| trên sàn HOSE đạt {2} tỷ đơn vị, <{0}| {3}% so với tháng {6} và <{1}|";
		String str2 = "Theo đó, tổng <khối lượng giao dịch| trong tháng qua đạt {2} tỉ cổ phiếu, bình quân khối lượng giao dịch đạt {8} triệu CP/phiên,  <{0}| {3}% so với tháng trước.";
		String str3 = "Như vậy là <khối lượng giao dịch| trong <tháng {5}| đã <{0}| tới {3}% so với tháng trước đó.";
		
		if (((str1.equals(str) || str2.equals(str) || str3.equals(str)) && Month >= 3) || ((!str1.equals(str) && !str2.equals(str) && !str3.equals(str)))){
			
		
		for (iter = st.stockInfoList.listIterator(); iter.hasNext(); )
		{
			StockInfo temp = iter.next();
			String month = temp.getDate().substring(3, 5);
			
			
			if (Integer.parseInt(month)  == Month - 1)
				totalVolLastMonth += temp.getVolume();
			if (Integer.parseInt(month)  == Month){
				totalVolume += temp.getVolume();
				days += 1;
				if (maxVolume.getVolume() < temp.getVolume()){
					maxVolume = temp;
				}
				
			}
//				System.out.println(temp.toString());
			
		}
		
		aveVolume = totalVolume / days;
		
		if (totalVolume < totalVolLastMonth){
			change1Month = "giảm";
			percentChange1 = (1 - totalVolume / totalVolLastMonth) * 100; 
		}
		else{
			change1Month = "tăng";
			percentChange1 = (totalVolume / totalVolLastMonth - 1) * 100; 
		}

		String result = MessageFormat.format(str, 
				change1Month, //0
				totalVolume / 1000000000,//1
				percentChange1, //2
				Month, //3
				Month - 1,//4 
				aveVolume / 1000000,//5 
				maxVolume.getDate(), //6
				maxVolume.getVolume() / 1000000,//7 
				maxVolume.getCodeStock());//8
//		System.out.println(result);
		saveSentence(result, "sentences");

		}
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int Month = sc.nextInt();
//		String CodeStock = sc.next();
		Sentence10 st10 = new Sentence10();
		
		st10.process(Month);
		sc.close();
		
	}
}
