package sprint1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReaddatafromExcel;

public class S0635_EditLegalEntity
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
	@Test(dataProvider="excelDataProvider")
	public void testEditLegalEntity(String username, String password) throws InterruptedException 
	{
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();	
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on Opportunity tab 
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class=\"slds-truncate\"]")).click();
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("Salesforce Automation By Radhika");
		WebElement editLegalEntity=new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@role='button'])[19]")));
		//WebElement editLegalEntity = driver.findElement(By.xpath("(//a[@role='button'])[19]")); 
		driver.executeScript("arguments[0].click();", editLegalEntity);	
		WebElement dropdown=driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Active']")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'Radhika')])[1]")).click();
		String ActualResult=driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow '])[5]")).getText();
		String ExpectedResult="Active";
		Assert.assertEquals(ExpectedResult,ActualResult);
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
