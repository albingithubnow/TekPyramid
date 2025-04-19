package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Exception {

		//Step 1: get the excel path location and java object of he physical excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\New folder\\testscriptdata.xlsx");
		
		//step 2: open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: get the control of the org sheet
		  Sheet sh = wb.getSheet("Sheet1");
		  
		  // to read single data
//		  Row row = sh.getRow(1);
		  
//		  String column1Data = row.getCell(0).toString();
//		  String column2Data = row.getCell(1).toString();
//		  
//		  System.out.println(column1Data);
//		  System.out.println(column2Data);
		  
//		  System.out.println(column1Data +"\t" + column2Data);
		 
		  // to print all the data, we use java iteration
		  
		  int rowCount = sh.getLastRowNum();
		  
	for (int i=1; i<=rowCount; i++)
	{
		Row row = sh.getRow(i);
		
		String column1Data = row.getCell(0).toString();
		String column2Data = row.getCell(1).toString();
		
		System.out.println(column1Data +"\t" + column2Data);		  
	}
		  wb.close();		  
		  
		  
		
		
	}

}
