package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReaddatafromExcel 
{
	public void readdatefromExcel() throws IOException
	{
		String data=".\\datafiles\\data.xlsx";
		FileInputStream fileinput=new FileInputStream(data);
		XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
		XSSFSheet sheet=workbook.getSheet("Sheet1");//this will get the data from sheet other method is XSSFSheet sheet=workbook.getSheetAt(0);
		int rows=sheet.getLastRowNum();//will get the number of rows in the data sheet
		int cols=sheet.getRow(1).getLastCellNum(); //this will get the no of cells in the 1st row	
	}
}
