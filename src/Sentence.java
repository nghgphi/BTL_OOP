package readFileCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Sentence {
//	StockInfo st = new StockInfo();
	String str;
	
	public void getSentence(String path) {
		try {
//			st.StockInfoList = st.getData();
			String dir = System.getProperty("user.dir");
			File FileDir = new File(dir + "\\sentence\\" + path + ".txt");
			BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(FileDir), "UTF8"));

			List<String> ListSentences = new ArrayList<>();
			
			
			while ((str = in1.readLine()) != null) {
				ListSentences.add(str);
			}
			in1.close();
			
			Random rand = new Random();
			int SenIndex = rand.nextInt(ListSentences.size());
			
			str = ListSentences.get(SenIndex);
		}
		catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
	    catch (IOException e) {
			System.out.println(e.getMessage());
	    } 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void saveSentence(String sentence, String path)
	{
		String Dir = System.getProperty("user.dir");
		String FileDir = Dir + "\\sentence\\" + path + "_output.txt";
		try {

			Files.write(Paths.get(FileDir), (sentence + "\r\n").getBytes(), StandardOpenOption.APPEND);
//			fw.write(sentence);
//			fw.close();
			System.out.println("Save sentence success!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void process(String Date)
	{
		
	}
	public void process(String Date, String CodeStock)
	{
		
	}
	public void process(int Month)
	{
		
	}
}
