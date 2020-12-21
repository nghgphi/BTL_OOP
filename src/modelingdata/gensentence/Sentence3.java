package modelingdata.gensentence;
// 4 cổ phiếu cao nhất ngày
import java.text.MessageFormat;
import java.util.ListIterator;
import java.util.Vector;

import modelingdata.stockinfo.StockInfo;

    public class Sentence3 extends Sentence {
	   
    	
    	private double percentAllVolume;
    	private Count A;
    	private Vector<StockInfo> ListStock ;
    	
	
		
		
	   public void FindData(String Date) {
	    	getSentence("sentences3");
	    	Vector<StockInfo> ListStock =new Vector<StockInfo>();
			ListIterator<StockInfo> iter;
//			st.stockInfoList = st.getData();
			for (iter  = st.stockInfoList.listIterator(); iter.hasNext();iter.next())
			{
				
				int iterIdx = iter.nextIndex();
				if (iterIdx >= st.stockInfoList.size() - 1) 
					break;
				StockInfo temp = st.stockInfoList.get(iterIdx);     
				if ( temp.getDate().equals(Date))
				{
					ListStock.add(temp);
				}
			}  
			this.ListStock= ListStock;
	  }
	   
	// sáº¯p theo khá»‘i lÆ°á»£ng giao dá»‹ch   
	   public Vector<StockInfo> ByVolume(Vector<StockInfo> ListStock) {
		   Vector<StockInfo> A = ListStock;
		   int n = A.size();
			 for (int i = 0 ; i < n - 1; i++) 
		            for (int j = i + 1; j < n; j++)
	                if (A.get(i).getVolume() < A.get(j).getVolume()) 
	                {
	                   StockInfo container = A.get(i);
	                   A.set(i , A.get(j)); 
	                   A.set(j , container);
	                }
			 return A;
	   }
	// sáº¯p theo giÃ¡ cá»• phiáº¿u   
	   public Vector<StockInfo> ByPrice(Vector<StockInfo> ListStock2) {
		   Vector<StockInfo> B = ListStock2;
		   int n = B.size();
			 for (int i = 0 ; i < n - 1; i++) 
		            for (int j = i + 1; j < n; j++)
	                if (B.get(i).getClosePrice() < B.get(j).getClosePrice()) 
	                {
	                   StockInfo container = B.get(i);
	                   B.set(i , B.get(j)); 
	                   B.set(j , container);
	                     
	        }
			 return B;
	   }
	  
	    
	  public double getTotal(Vector<StockInfo> a) {
		   double total = 0;
		   for(int i = 0; i <= 29; i++) {
			   total += a.get(i).getVolume();
		   }
		   return total;
	  }
	   
	  
	  public void getMaxVolume (String Date) {
		  getSentence("sentences3");
			ListIterator<StockInfo> iter;
//			st.stockInfoList = st.getData();
			
		  for (iter  = st.stockInfoList.listIterator(); iter.hasNext();iter.next())
			{	
				int iterIdx = iter.nextIndex();
				if (iterIdx >= st.stockInfoList.size() - 1) 
					break;
				StockInfo temp = st.stockInfoList.get(iterIdx); 
				StockInfo tempYTD = st.stockInfoList.get(iterIdx+1); 
				 
				if ( temp.getDate().equals(Date) && temp.getCodeStock().equals(ByVolume(ListStock).get(0).getCodeStock()))
				{
					break;
				}
				this.A = new Count(temp,tempYTD);
			}
	  }
	  
	
	  @Override
	  public void process(String Date) {
			try {
				FindData(Date);
				
				
		getMaxVolume (Date);
		percentAllVolume=(ByVolume(ListStock).get(0).getVolume()+ByVolume(ListStock).get(1).getVolume()+ByVolume(ListStock).get(2).getVolume())/getTotal(ByVolume(ListStock));
        String result = MessageFormat.format(str,
        		ByVolume(ListStock).get(0).getCodeStock(),//{0}
				Math.round((ByVolume(ListStock).get(0).getVolume() / 1000000.0) * 100.0) / 100.0,//{1}
				ByVolume(ListStock).get(1).getCodeStock(),//{2}
				Math.round((ByVolume(ListStock).get(1).getVolume() / 1000000.0) * 100.0) / 100.0,//{3}
				ByVolume(ListStock).get(2).getCodeStock(),//{4}
				Math.round((ByVolume(ListStock).get(2).getVolume() / 1000000.0) * 100.0) / 100.0,//{5}
				ByVolume(ListStock).get(3).getCodeStock(),//{6} 
				Math.round((ByVolume(ListStock).get(3).getVolume() / 1000000.0) * 100.0) / 100.0,//{7}
				ByVolume(ListStock).get(4).getCodeStock(),//{8}
				Math.round((ByVolume(ListStock).get(4).getVolume() / 1000000.0) * 100.0) / 100.0,//{9}
				A.AugDecPrice(),//{10}
				A.getPriceDiff()*1000,//{11}
				percentAllVolume*100);//{12}
        
        saveSentence( result, "sentences");
		}catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
	}
		
	
}
