package sprint1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReaddatafromExcel;
import utilities.RetryFailedTestcase;

public class S0634_CreateLegalEntity extends BaseClass
{
	public static ChromeDriver driver;
	public String data;
	public ReaddatafromExcel readdata=new ReaddatafromExcel();
	public String excelSheetName="data";
	
	@BeforeTest
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		//Handle Notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Login to https://login.salesforce.com- mars@testleaf.com, BootcampSel$123
		driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();	
	}
	@Test(dataProvider="excelDataProvider", retryAnalyzer=RetryFailedTestcase.class)
	public void testLegalEntity(String username, String password) throws InterruptedException 
	{	
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("Login")).click();	
			//Click on toggle menu button from the left corner	
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			//Click view All and click Sales from App Launcher
			
			WebElement serviceconsole=driver.findElement(By.xpath("//a[@data-label='Service Console']"));
			driver.executeScript("arguments[0].click();", serviceconsole);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@title='Legal Entities']")).click();
			driver.findElement(By.xpath("//a[@title='New']")).click();
			/*driver.findElement(By.xpath("//button[text()='View All']")).click();		
			//Click on Opportunity tab 
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");	
			driver.findElement(By.xpath("//p[@class=\"slds-truncate\"]")).click();
			driver.findElement(By.xpath("(//a[@title='Legal Entities']//following::lightning-primitive-icon)[1]")).click();
			/*Thread.sleep(3000);	
			driver.findElement(By.xpath("(//a[@role='menuitem'])[1]")).click();
			WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']")); 
			driver.executeScript("arguments[0].click();", newLegalEntity);
			/*WebElement cases=driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']")); 
			Actions action = new Actions(driver); 
			action.moveToElement(cases).click().build().perform();*/
			driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("Salesforce Automation By Radhika");
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			WebElement web=driver.findElement(By.xpath("(//span[@class='uiOutputText])[1]"));
			String ActualTitle=web.getText();
			String ExpectedTitle="Salesforce Automation By Radhika";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	/*@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}*/
	@DataProvider(name = "excelDataProvider") 
	public Object[][] getInputRecords()
	{ 
		return readdata.getExcelSheet(excelSheetName);
	}
}
