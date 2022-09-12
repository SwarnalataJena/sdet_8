package genericLirbrary;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility2 {
	public String readDatafromExcel2(String sheetname,int row, int cell) throws Throwable, Throwable, Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.XLPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String value=c.getStringCellValue();
		return value;
	}

}
