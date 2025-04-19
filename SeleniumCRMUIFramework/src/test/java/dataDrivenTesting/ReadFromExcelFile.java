package dataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelFile  {

	public static void main(String[] args) throws Exception {
		
	
	//Step 1: get the excel path location and java object of he physical excel file
	FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\New folder\\testscriptdata.xlsx");
	
	//step 2: open workbook in read mode
	Workbook wb = WorkbookFactory.create(fis);
	
	//step 3: get the control of the org sheet
	  Sheet sh = wb.getSheet("org");
	
	//step 4: get the control of the row
	  Row row = sh.getRow(1);
	
	//step 5: get the control of the cell and read the data
	  Cell cel = row.getCell(2);
	  
	  String data = cel.getStringCellValue();
	  System.out.println(data);
	  
	   double data2 = row.getCell(3).getNumericCellValue();  
	  System.out.println(data2);
	  
	
	//step 6: close the workbook
	wb.close();
	}
}
