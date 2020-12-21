package modelingdata.gensentence;
// so sÃ¡nh cá»• phiáº¿u so vá»›i 1 ngÃ y trÆ°á»›c
import java.text.MessageFormat;
import java.util.ListIterator;

import modelingdata.stockinfo.StockInfo;

public class Sentence1 extends Sentence {
	
	private Count A;
	private StockInfo temp;
	private StockInfo tempYTD;
	
	public void FindData(String CodeStock, String Date) {
		getSentence("sentences1");
		ListIterator<StockInfo> iter;
//		st.stockInfoList = st.setData();
		for (iter  = st.stockInfoList.listIterator(); iter.hasNext();iter.next()){
			
			int iterIdx = iter.nextIndex();
			if (iterIdx >= st.stockInfoList.size() - 1) 
				break;
			StockInfo temp = st.stockInfoList.get(iterIdx);     
			if (temp.getCodeStock().equals(CodeStock) && temp.getDate().equals(Date)){
				
				this.temp=temp;
				this.tempYTD = st.stockInfoList.get(iterIdx + 1);
				break;
			}
		}
				this.A=new Count(temp,tempYTD);
	
	}	
	public String CheckColor (StockInfo temp) {
		if(temp.getClosePrice() > temp.getOpenPrice()) 
			return "sắc xanh";
		else return "sắc đỏ";
	}

//	@Override
	public void process(String CodeStock,String Date) {
				try {
					FindData(CodeStock, Date);
				String result = MessageFormat.format(str,
						temp.getDate(),//{0}
						temp.getCodeStock(),//{1}
						temp.getOpenPrice() * 1000,//{2}
						temp.getClosePrice() * 1000,// {3}
						temp.getHighPrice() * 1000,//{4}
						temp.getLowPrice(),//{5}
						Math.round((temp.getVolume() / 1000000.0) * 100.0) / 100.0,//{6}
						A.AugDecPrice(),//{7} 
						A.getPriceDiff() * 1000,//{8}
						A.getPricePercent(),//{9}
						CheckColor(temp));//{10}
				saveSentence( result, "sentences");
//	             System.out.println(result);
		}
		catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
	}
		
	

}
