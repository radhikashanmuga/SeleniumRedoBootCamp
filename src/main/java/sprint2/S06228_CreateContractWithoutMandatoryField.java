package sprint2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S06228_CreateContractWithoutMandatoryField
{
	@Test
	public void contractwithoutMandfield() throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//3. Click View All and click 'Contract' from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//mark[text()='Contracts'])[1]")).click();
		//4. Click on the Dropdown icon in the Contract tab
		driver.findElement(By.xpath("(//a[@title='Contracts']//following::lightning-primitive-icon)[1]")).click();
		Thread.sleep(3000);
		//5. Click on New Contract
		WebElement newContract=driver.findElement(By.xpath("//span[text()='New Contract']"));
		driver.executeScript("arguments[0].click();", newContract);
		//6. Select the accounts listed on the'Account Name' field
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("(//div[@title='Test'])[1]")).click();
		//7.Select the Contract Start Date as Tommorow's Date
		Date dt=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		dt=calendar.getTime();
		String tomorrowDate=new SimpleDateFormat("MM/dd/yyyy").format(dt);
		WebElement tomDate=driver.findElement(By.xpath("(//input[@class=' input'])[1]"));
		tomDate.sendKeys(tomorrowDate);
		//8.Click save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		//9.Verify the Alert message(These required fields must be completed: Contract Term (months))
		String actualResult=driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).getText();
		System.out.println(actualResult);
		String expectedResult="Review the errors on this page.";
		Assert.assertEquals(actualResult, expectedResult);
	}
}
