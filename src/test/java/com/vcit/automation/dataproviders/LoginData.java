package com.vcit.automation.dataproviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginData {

	@DataProvider(name = "users",parallel = false)
	public static Object[][] users(){
		return new Object[][] {{"ramu.chandran@gmail.com","acha2519"},{"raja01@yopmail.com","test@1234"}};
	}
	
	@DataProvider(name = "usersFromExcel",parallel = false)
	public static Object[][] usersFromExcel() throws Exception{
		File file = new File("./datafiles/data.xlsx");
		System.out.println(file.exists());
		Workbook workbook= new XSSFWorkbook(new FileInputStream(file));
		Sheet sheet = workbook.getSheet("LoginDetails");
		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		Object[][] data = new Object[rows][2];
		
		for(int i=1;i<=rows;i++) {
			Row row = sheet.getRow(i);
			data[i-1][0]=row.getCell(0).getStringCellValue();
			data[i-1][1]=row.getCell(1).getStringCellValue();
		}
		
		return data;
	}
	
	@DataProvider(name = "usersFromTextFile",parallel = false)
	public static Iterator<Object[]> usersFromTextFile() throws Exception{
		File file = new File("./datafiles/users.txt");
		BufferedReader inStream = new BufferedReader(new FileReader(file));
        String inString;
        List<Object[]> data = new ArrayList<Object[]>();
        while ((inString = inStream.readLine()) != null) {
        	StringTokenizer tokens = new StringTokenizer(inString,"|");
        	data.add(new Object[] {tokens.nextElement(),tokens.nextElement()});
        }
        inStream.close();
		
		return data.iterator();
	}
	
	
	public static void main(String[] args) throws Exception {
		File file = new File("./datafiles/data.xlsx");
		usersFromExcel();
		System.out.println(file.exists());
	}
}
