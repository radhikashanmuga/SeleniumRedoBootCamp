package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReaddatafromExcel 
{
	public Object[][] getExcelSheet(String excelSheetName) 
	{
		Object[][] data = null ;
		try 
		{
			//FileInputStream fis = new FileInputStream("C:\\Radhika\\Test Leaf\\Sel\\SeleniumRedoBootCamp\\dataFiles\\data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook("C:\\Radhika\\Test Leaf\\Sel\\SeleniumRedoBootCamp\\dataFiles\\data.xlsx");
			XSSFSheet sheet = workbook.getSheetAt(0); 

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								//cellValue = row.getCell(j).getStringCellValue();

								row.getCell(j).getCellType();
								System.out.println("  cell type >>   "+row.getCell(j).getCellType());

								switch(row.getCell(j).getCellType())
								{
								case NUMERIC:
									System.out.println(row.getCell(j).getCellType() + "\t");
									cellValue = String.valueOf(row.getCell(j).getNumericCellValue());
									break;
								case STRING:
									System.out.println(row.getCell(j).getCellType() + "\t");
									cellValue = row.getCell(j).getStringCellValue();
									break;
								default:
									break;

								}


								/*

								if(cell.getCellType()==CellType.STRING) 
								    data = cell.getStringCellValue(); 
								else if(cell.getCellType()==CellType.NUMERIC) 
								    data = String.valueOf(cell.getNumericCellValue());
								 */

							}catch(NullPointerException e){

							}

							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
}