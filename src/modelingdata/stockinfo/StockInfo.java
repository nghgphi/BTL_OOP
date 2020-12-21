package modelingdata.stockinfo;


public class StockInfo {

	private String date;
	private String codeStock;
	private double openPrice, closePrice, highPrice, lowPrice, volume;
	
	public String getDate() {
		return date;
	}
	public String getCodeStock() {
		return codeStock;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public double getVolume() {
		return volume;
	}
//	public List<StockInfo> getStockInfoList() {
//		return StockInfoList;
//	}
	public StockInfo() {
//		this.StockInfoList = getData();
	}
//	public String toString()
//	{
//		return Date + " " + CodeStock + " " + OpenPrice + " " + ClosePrice + " " + HighPrice + " " + LowPrice + " " + Volume;
//	}
	public StockInfo(String Date, String CodeStock, double OpenPrice, double ClosePrice, double HighPrice, double LowPrice, double Volume)
	{
		this.date = Date;
		this.codeStock = CodeStock;
		this.openPrice = OpenPrice;
		this.closePrice = ClosePrice;
		this.highPrice = HighPrice;
		this.lowPrice = LowPrice;
		this.volume = Volume;
	}
	
}
