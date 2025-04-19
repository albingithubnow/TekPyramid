package dataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws Exception {

		String ExpectedTestID = "tc_02";
		String data1 = "";
		String data2 = "";
		String data3 = "";

		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\New folder\\testscriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");

		int rowcount = sh.getLastRowNum();

		for (int i = 0; i <= rowcount; i++) {
			String data = "";
			try {
				data = sh.getRow(i).getCell(0).toString();

				// putting the condition
				if (data.equals(ExpectedTestID)) {
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}

			} catch (Exception e) {
			}
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		}
		wb.close();

	}
}
