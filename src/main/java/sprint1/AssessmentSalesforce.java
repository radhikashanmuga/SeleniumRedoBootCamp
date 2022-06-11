package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReaddatafromExcel;

public class AssessmentSalesforce 
{
	public static ChromeDriver driver;
	public String data;
	public ReaddatafromExcel readdata=new ReaddatafromExcel();
	public String excelSheetName="data";
	@Test(dataProvider="excelDataProvider")
	public void assessement(String username, String password) throws InterruptedException 
	{
		//1. Login to https://login.salesforce.com
		WebDriverManager.chromedriver().setup();
		//Handle Notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Login to https://login.salesforce.com- mars@testleaf.com, BootcampSel$123
		driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();	
		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//3. Click view All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//4. Click Service Console from App Launcher
		WebElement serviceconsole=driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].click();", serviceconsole);
		Thread.sleep(3000);
		//5. Select Home from the DropDown
		
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
		
		//7. Navigate to Dashboard tab
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("(//span[text()='Dashboards'])")).click();
		//8. Click on New Dashboard
		
		driver.findElement(By.xpath("//a[@title='New Dashboard']")).click();
		//9. Enter the Dashboard name as "YourName_Workout"
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Radhika_Workout");
		//10. Enter Description as Testing and Click on Create
		//driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
		//11. Click on Create
		//driver.findElement(By.xpath("//input[@id=submitBtn']")).click();
		//12. Click on Done
		
		
		//13. Click on Dashboard tab
		//14. Verify the Dashboard is Created
		//15. Click on the newly created Dashboard
		//16. Click on Subscribe
		//14. Select Frequency as "Daily"
		//15. Time as 10:00 AM
		//16. Click on Save
		//17. Verify "You started Dashboard Subscription" message displayed or not
		//18. Close the "YourName_Workout" tab
		//19. Click on Private Dashboards
		//20. Verify the newly created Dashboard available
		//21. Click on dropdown for the item
		//22. Select Delete
		//23. Confirm the Delete
		//24. Verify the item is not available under Private Dashboard folder
			
	}
	@DataProvider(name = "excelDataProvider") 
	public Object[][] getInputRecords()
	{ 
		return readdata.getExcelSheet(excelSheetName);
	}
}
