package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Devayan
 */
public class ExcelUtility {

	/**
	 * This method is used to fetch String value from excel file
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getStringValueFromExcel(String sheet, int rowNum, int cellNum)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory
				.create(new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx"));
		return workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}

	/**
	 * This method is used to fetch numeric value from excel file
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public double getNumericValueFromExcel(String sheet, int rowNum, int cellNum)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory
				.create(new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx"));
		return workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}

	/**
	 * This method is used to fetch boolean value from excel file
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean getBooleanValueFromExcel(String sheet, int rowNum, int cellNum)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory
				.create(new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx"));
		return workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
	}

	/**
	 * This method is used to fetch LocalDateTime value from excel file
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public LocalDateTime getLocalDateTimeValueFromExcel(String sheet, int rowNum, int cellNum)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory
				.create(new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx"));
		return workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getLocalDateTimeCellValue();
	}

}
