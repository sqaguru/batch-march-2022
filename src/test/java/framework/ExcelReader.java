package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {

	public static Object[] readExcelData() {
		Object object[] = null;
		try {
			HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(
					"D:\\sqa-guru\\bat-mar-2022-7pm_mvn\\batch-march-2022\\src\\test\\resources\\testdata\\GoogleTestWithExcelParameters.xls"));

			HSSFSheet sheet = workBook.getSheet("GoogleSearch");

			int totalRows = sheet.getPhysicalNumberOfRows();

			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			object = new Object[totalRows - 1];

			/* row counter */
			for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {
				HashMap<String, String> testData = new HashMap<String, String>();
				HSSFRow row = sheet.getRow(rowCounter);
				HSSFRow rowHeader = sheet.getRow(0);
				/* column counter */
				for (int columnCounter = 0; columnCounter < totalColumns; columnCounter++) {
					String cellHeader = rowHeader.getCell(columnCounter).getStringCellValue();
					String cellData = row.getCell(columnCounter).getStringCellValue();
					System.out.println(cellHeader + ": " + cellData);
					testData.put(cellHeader, cellData);
				}
				object[rowCounter - 1] = testData;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
