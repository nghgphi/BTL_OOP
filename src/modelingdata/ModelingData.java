package modelingdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import modelingdata.gensentence.Sentence;
import modelingdata.gensentence.Sentence1;
import modelingdata.gensentence.Sentence10;
import modelingdata.gensentence.Sentence12;
import modelingdata.gensentence.Sentence2;
import modelingdata.gensentence.Sentence3;
import modelingdata.gensentence.Sentence4;
import modelingdata.gensentence.Sentence5;
import modelingdata.gensentence.Sentence6;
import modelingdata.gensentence.Sentence7;
import modelingdata.gensentence.Sentence9;
import modelingdata.readfilecsv.FileInfo;
//import modelingdata.stockinfo.StockInfo;
import modelingdata.stockinfo.StockList;

public class ModelingData {
	List<Sentence> Sentences;
	FileInfo Inf;
	List<String> dayList;
	List<String> codeList;
	List<Integer> monthList;
	
	public void setDayList() {
		String dir = System.getProperty("user.dir");

		String line  = "";
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(dir + "\\data\\data\\BID.csv"));
//			System.out.println("Read file successed");
			int i = 0;
			while((line = br.readLine()) != null && (i < 113))
			{
				String[] values = line.split(",");
				dayList.add(values[0]);
				i++;
			}
			br.close();

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setCodeList() {
		String dir = System.getProperty("user.dir");
		
		String line  = "";
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(dir + "\\data\\filename.txt"));
//			System.out.println("Read file successed");
			while((line = br.readLine()) != null)
			{
				String values = line;
				codeList.add(values.substring(0, 3));
			}
			br.close();
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setMonthList()
	{
		monthList.add(1);
		monthList.add(2);
		monthList.add(3);
		monthList.add(4);
		monthList.add(5);
		monthList.add(6);
	}
	
	public ModelingData() {
		dayList = new ArrayList<>();
		codeList = new ArrayList<>();
		monthList = new ArrayList<>();
		Sentences = new ArrayList<>();
		Inf = new FileInfo();
		Sentence.st = new StockList();
		Sentence.st.setData(Inf.getStockInfoList()); 
		
		Sentences.add(new Sentence9());
		Sentences.add(new Sentence10());
		Sentences.add(new Sentence12());
		Sentences.add(new Sentence5());
		Sentences.add(new Sentence6());
		Sentences.add(new Sentence7());
		Sentences.add(new Sentence1());
		Sentences.add(new Sentence2());
		Sentences.add(new Sentence3());
		Sentences.add(new Sentence4());
		
		setCodeList();
		setDayList();
		setMonthList();
	}
	
	public void initData() {
		for (int i = 0; i < monthList.size(); i++) {
			processData(monthList.get(i));
		}
		
		for (int i = 0; i < dayList.size(); i++) {
			processData(dayList.get(i));
		}
//		
		for (int i = 0; i < dayList.size(); i++) {
			for (int j = 0; j < codeList.size(); j++) {
				processData(codeList.get(j), dayList.get(i));
			}
		}
	}
	
	public void processData(String date) {
		Sentences.get(0).process(date);
		Sentences.get(2).process(date);
		Sentences.get(8).process(date);
		Sentences.get(9).process(date);
	}
	
	public void processData(String codeStock, String date) {
		Sentences.get(3).process(codeStock, date);
		Sentences.get(4).process(codeStock, date);
		Sentences.get(5).process(codeStock, date);
		Sentences.get(6).process(codeStock, date);
		Sentences.get(7).process(codeStock, date);// xử lý theo mã và ngày
	}
	
	public void processData(int month) {
		Sentences.get(1).process(month);
	}
	
	public static void main(String args[]) {
		ModelingData md = new ModelingData();

//		sc.close();
		System.out.println("mô hình hóa");
		md.initData();
	}
	
	
	
	
	
}	
