package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBacktoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./TestData/testscriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(3);
	Cell cel = row.createCell(4);
	cel.setCellType(CellType.STRING);// we have to specify the datatype
	cel.setCellValue("Fail");  //we pass the value to the cell
		
	// opening same excel in write mode
	FileOutputStream fos = new FileOutputStream("./TestData/testscriptdata.xlsx");
	wb.write(fos); //this will save the data in the excel
	wb.close();
	System.out.println("=========executed================");
	}

}
