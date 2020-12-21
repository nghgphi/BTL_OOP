package modelingdata.gensentence;
//  5 cổ phiếu giữ giá tốt nhất trong ngày, ( xét trong 3 ngày)
import java.text.MessageFormat;      
import java.util.ListIterator;

import modelingdata.stockinfo.StockInfo;

public class Sentence4 extends Sentence {
	private Count A;
	int[] tempIdxKP= new int[5];
	int[] tempIdxKC= new int[5];	
	public boolean CheckKeepPrice( int tempIdxKP ) {
		StockInfo temp = st.stockInfoList.get(tempIdxKP); 
		StockInfo tempYTD1 = st.stockInfoList.get(tempIdxKP + 1);
		StockInfo tempYTD2 = st.stockInfoList.get(tempIdxKP + 2);     
		StockInfo tempYTD3 = st.stockInfoList.get(tempIdxKP + 3);     
		if ((temp.getClosePrice() - tempYTD1.getClosePrice()) > 0 && (tempYTD1.getClosePrice() - tempYTD2.getClosePrice()) > 0 && (tempYTD2.getClosePrice() - tempYTD3.getClosePrice()) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean CheckKeepColor( int tempIdxKC ) {
		StockInfo temp = st.stockInfoList.get(tempIdxKC); 
		StockInfo tempYTD1 = st.stockInfoList.get(tempIdxKC + 1);    
		if ((temp.getClosePrice() - temp.getOpenPrice()) > 0 && (tempYTD1.getClosePrice() - tempYTD1.getOpenPrice()) > 0 ) {
			return true;
		}
		return false;
	}
	public String fixKeepPrice (int i) {
		if(tempIdxKP[i]!=0) {
			StockInfo temp = st.stockInfoList.get(tempIdxKP[i]);
			if(i!=4) {
			return temp.getCodeStock()+" ";
			} 
			else{
				return temp.getCodeStock();
			}
		}else {
			return "";
		}
	}
	public String fixKeepColor (int i) {
		if(tempIdxKC[i]!=0) {
			StockInfo temp = st.stockInfoList.get(tempIdxKC[i]);
			if(i!=4) {
			return temp.getCodeStock() + " ";
			} else {
				return temp.getCodeStock();
			}
		}else {
			return "";
		}
	}
	
	public void FindData(String Date)  {
		getSentence("sentences4");
		ListIterator<StockInfo> iter;
//		st.stockInfoList = st.getData();
		int i = 0,j = 0;
		for (iter  = st.stockInfoList.listIterator(); iter.hasNext();iter.next()){
			if(i > 5 && j > 5) 
				break;
			if ( st.stockInfoList.get(iter.nextIndex()).getDate().equals(Date)){
			int iterIdx = iter.nextIndex();
  
			
				if (CheckKeepPrice(iterIdx)) {
					if(i<5) {
						this.tempIdxKP[i] = iterIdx;
						i++;
					}
					
				}
				if (CheckKeepColor(iterIdx)) {
					if(j < 5) {
						this.tempIdxKC[j] = iterIdx;
						j++;
					}
					
				}
			}
		}
		
	}
			
	

	@Override
	public void process(String Date) {
		   try
		{		
				FindData(Date);
			   StockInfo temp= st.stockInfoList.get(tempIdxKP[0]);	
				StockInfo tempYTD = st.stockInfoList.get(tempIdxKP[0] + 1);
				A=new Count(temp,tempYTD);
				String result = MessageFormat.format(str,
						temp.getDate(),//{0}
						temp.getCodeStock(),//{1}
						temp.getOpenPrice(),//{2}
						temp.getClosePrice() * 1000,// {3}
						temp.getHighPrice(),//{4}
						temp.getLowPrice(),//{5}
						Math.round((temp.getVolume() / 1000000.0) * 100.0) / 100.0,//{6}
						A.AugDecPrice(),//{7}
						A.getPriceDiff()*1000,//{8}
						A.getPricePercent(),//{9}
						fixKeepPrice(1),//{10}
						fixKeepPrice(2),//{11}
						fixKeepPrice(3),//{12}
						fixKeepPrice(4),//{13}
						st.stockInfoList.get(tempIdxKC[0]).getCodeStock(),//{14}
						fixKeepColor (1),//{15}
						fixKeepColor (2),//{16}
						fixKeepColor (3),//{17}
						fixKeepColor (4));//{18}
				saveSentence( result, "sentences");
	             
		}catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
	}
		
	

}
