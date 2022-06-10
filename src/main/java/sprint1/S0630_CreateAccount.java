package sprint1;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReaddatafromExcel;
import utilities.RetryFailedTestcase;

public class S0630_CreateAccount extends ReaddatafromExcel
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
	public void createAccount(String username, String password) throws InterruptedException 
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		
		//Click on New button
		
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		//Click on Accounts tab
		driver.findElement(By.xpath("(//a[@title='Accounts']//following::lightning-primitive-icon)[1]")).click();
		Thread.sleep(3000);
		//Click on New button
		WebElement newAccount=driver.findElement(By.xpath("(//a[@role='menuitem'])[1]"));
		driver.executeScript("arguments[0].click();",newAccount);
		//Enter 'your name' as account name
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Radhika");
		//Select Ownership as Public   
		driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']")).click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		//Click save and verify Account name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement accountCreate=driver.findElement(By.xpath("//div[@title='\"Manjula\"']"));
		String actualResult=accountCreate.getText();
		System.out.println(actualResult);
		String expectedTitle="Radhika";
		if(actualResult.contains(expectedTitle))
			System.out.println("Data is created");
		else
					System.out.println("Data is not created");
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
