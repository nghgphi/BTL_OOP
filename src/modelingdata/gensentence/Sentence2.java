package modelingdata.gensentence;
// so  sánh 1 loại cổ phiếu với 3 ngày trước
import java.text.MessageFormat;
import java.util.ListIterator;

import modelingdata.stockinfo.StockInfo;

public class Sentence2 extends Sentence {
	private StockInfo temp;
	private StockInfo tempYTD1;
	private StockInfo tempYTD2;
	private StockInfo tempYTD3;
	private Count A;
	private Count B;
	private Count C;
	
	public void FindData(String CodeStock,String Date) {
		getSentence("sentences2");
		ListIterator<StockInfo> iter;
//		st.stockInfoList=st.getData();
		for (iter  = st.stockInfoList.listIterator(); iter.hasNext();iter.next())
		{
			
			int iterIdx = iter.nextIndex();
			if (iterIdx >= st.stockInfoList.size() - 1) 
				break;
			StockInfo temp = st.stockInfoList.get(iterIdx);     
			if (temp.getCodeStock().equals(CodeStock) && temp.getDate().equals(Date)){
				this.temp= temp;
				this.tempYTD1 = st.stockInfoList.get(iterIdx + 1);
				this.tempYTD2 = st.stockInfoList.get(iterIdx + 2);
				this.tempYTD3 = st.stockInfoList.get(iterIdx + 3);
				this.A=new Count(temp,tempYTD1);
				this.B=new Count(temp,tempYTD2);
				this.C=new Count(temp,tempYTD3);
				break;
			}
	    }
	}

	
	@Override
	public void process(String CodeStock, String Date) {
		
		try {
			FindData(CodeStock,Date);
				A.AugDecVolume();
				B.AugDecVolume();
				C.AugDecVolume();
				double Value=temp.getClosePrice() * Math.round((temp.getVolume() / 1000000.0) * 100.0);
				if (0 < A.getVolumePercent() && A.getVolumePercent() <= 10 && 0 < B.getVolumePercent() && B.getVolumePercent() <=10 && 0 < C.getVolumePercent() && C.getVolumePercent()<=10){
					str="So với 3 phiên trước, khối lượng giao dịch <{1}> biến động nhẹ, còn gần {6} triệu.";
				String result = MessageFormat.format(str,
						temp.getDate(),//{0}
						temp.getCodeStock(),//{1}
						temp.getOpenPrice(),//{2}
						temp.getClosePrice() * 1000,// {3}
						temp.getHighPrice(),//{4}
						temp.getLowPrice(),//{5} 
						Math.round((temp.getVolume() / 1000000.0) * 100.0) / 100.0,//{6}
						A.AugDecPrice(),//{7}
						A.getPriceDiff() * 1000,//{8}
						A.getVolumePercent(),//{9}
						A.AugDecVolume());//{10}
	             saveSentence( result, "sentences");
				}
				else {
					String result = MessageFormat.format(str,
							temp.getDate(),//{0}
							temp.getCodeStock(),//{1}
							temp.getOpenPrice(),//{2}
							temp.getClosePrice() * 1000,// {3}
							temp.getHighPrice(),//{4}
							temp.getLowPrice(),//{5}
							Math.round((temp.getVolume() / 1000000.0) * 100.0) / 100.0,//{6}
							A.AugDecPrice(),//{7}
							A.getPriceDiff() * 1000,//{8}
							A.getVolumePercent(),//{9}
							A.AugDecVolume(),//{10}
							temp.getVolume(),//{11}
							B.AugDecVolume(),//{12}
							B.getVolumePercent(),//{13}
							tempYTD1.getDate(),//{14}
							C.AugDecVolume(),//{15}
							C.getVolumePercent(),//16
							tempYTD2.getDate(),//{17}
							Value);//{18}
					
					saveSentence( result, "sentences");
		     
			
		         }
		}catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
	}
		
	

}

	


