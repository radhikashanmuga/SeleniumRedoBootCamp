package sprint1;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;


public class S0634_CreateLegalEntity extends BaseClass
{
	@Test
	public void testLegalEntity() throws InterruptedException 
	{
		
			/*Download the chrome driver and set the path
			WebDriverManager.chromedriver().setup();	
			//Handle Notifications
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			//Login to https://login.salesforce.com- mars@testleaf.com, BootcampSel$123
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("Login")).click();*/
			
			//Click on toggle menu button from the left corner	
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			//Click view All and click Sales from App Launcher
			driver.findElement(By.xpath("//button[text()='View All']")).click();
					
			//Click on Opportunity tab 
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");	
			driver.findElement(By.xpath("//p[@class=\"slds-truncate\"]")).click();
			driver.findElement(By.xpath("(//a[@title='Legal Entities']//following::lightning-primitive-icon)[1]")).click();
			/*Thread.sleep(3000);	
			driver.findElement(By.xpath("(//a[@role='menuitem'])[1]")).click();*/
				
				WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']")); 
				
				driver.executeScript("arguments[0].click();", newLegalEntity);
				
				/*WebElement cases=driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']")); 
				Actions action = new Actions(driver); 
				action.moveToElement(cases).click().build().perform();*/
				
				driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("Salesforce Automation By Radhika");
				
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				
				WebElement web=driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]"));
				String ActualTitle=web.getText();
				String ExpectedTitle="Salesforce Automation By Radhika";
				Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

}
