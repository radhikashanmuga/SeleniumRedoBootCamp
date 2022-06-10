package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.poifs.nio.DataSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReaddatafromExcel;

public class BaseClass extends ReaddatafromExcel
{
	public static ChromeDriver driver;
	public String data;
	public ReaddatafromExcel readdata=new ReaddatafromExcel();
	public String excelSheetName="data";

	@BeforeTest
	public void launchBrowser()
	{
		//excelFilePath=".\\datafiles\\data.xlsx";
		WebDriverManager.chromedriver().setup();
		//Handle Notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Login to https://login.salesforce.com- mars@testleaf.com, BootcampSel$123
		 driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	@DataProvider(name = "excelDataProvider") 
	public Object[][] getInputRecords()
	{ 
		return readdata.getExcelSheet(excelSheetName);
	}
	
}
