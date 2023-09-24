package DataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	@Test
	public void getData() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\nites\\Desktop\\SELENIUM\\code\\16_Framework_Excel_Data_Driven\\excelDataProvider\\excelDataProvider.xlsx");

		XSSFWorkbook worksheet = new XSSFWorkbook(fis);

		XSSFSheet sheet = worksheet.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();

		Object[][] data = new Object[rowCount - 1][columnCount];

		for (int i = 1; i < rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				System.out.println(row.getCell(j));
			}
		}
	}
}
