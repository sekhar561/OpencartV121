package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name ="LoginData")
	public String [][] getData() throws IOException{
		
		String path =".\\testData\\Opencart_testData.xlsx"; //taking xl file from data
		
		ExcelUtility xlutil = new ExcelUtility(path);//Creating an object for XLUtility
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols];// Created two dimensional array for stored the values
		
		for(int i=1; i<=totalrows;i++) { //1
			
			for(int j=0;j<totalcols;j++) {//0
				
				xlutil.getCellData("Sheet1", i, j);// 1,0
			}
		}
		
		return logindata;
		
	}
}
