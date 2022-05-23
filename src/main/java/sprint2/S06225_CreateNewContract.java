package sprint2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06225_CreateNewContract 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//1. Login to https://login.salesforce.com
		
		WebDriverManager.chromedriver().setup();
		
		//Handle Notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Login to https://login.salesforce.com- mars@testleaf.com, BootcampSel$123
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();
		
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		
		//3. Click View All and click 'Contract' from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//mark[text()='Contracts'])[1]")).click();
		//4. Click on the Dropdown icon in the Contract tab
		
		driver.findElement(By.xpath("(//a[@role='button'])[17])")).click();
		//
		//driver.findElement(By.xpath("(//a[@title='Contracts']//following::lightning-icon)[1]")).click();
		//5. Click on New Contract
		/*WebElement newContract=driver.findElement(By.xpath("//span[text()='New Contract']"));
		WebElement newContract=driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();", newContract);
		//6. Select the accounts listed on the'Account Name' field
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).click();
		driver.findElement(By.xpath("(//div[@title='Your Name'])[1]")).click();
		//7.Select the Contract Start Date as Tommorow's Date*/
		SimpleDateFormat dnt = new SimpleDateFormat("dd/MM/yy :: HH:mm:ss");
        Date date = new Date();
        System.out.println("Today Date & Time at Now :"+dnt.format(date));
		//driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		//8.Enter Contract Term (months) as' 6 '
		//9.Click save and Verify the Contract Name
		//10.Get the Contract number
		//11.Get the difference between  the Contract Start Date and End Date and Check it matches the Contract Term.
		//Expected Result:
		//The new Contract is created Successfully

	}

}
