package sprint1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0637_VerifyLegalEntitiessortByLastModifiedDate {
	
	@Test
	public void sorting() throws InterruptedException, ParseException 
	{
		//Download the chrome driver and set the path
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
				
				//Click on toggle menu button from the left corner
				
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
				
				//Click view All and click Sales from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				
				
				//Click on Opportunity tab 
				driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
				driver.findElement(By.xpath("//p[@class=\"slds-truncate\"]")).click();
				
				String BeforeSort=driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputDateTime'])[1]")).getText();
				/*Date Bdate=new Date();*/
				SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/YYYY HH:MM");
				Date date1 = formatter.parse(BeforeSort);
				/*String lastdate=driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputDateTime'])[7]")).getText();
				System.out.println(BeforeSort);*/
				
				Thread.sleep(3000);
				
				/*WebElement sort=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[22]"));
				driver.executeScript("arguments[0].click();", sort);*/
				
				WebElement sort=driver.findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[2]"));
				Actions builder=new Actions(driver);
				builder.moveToElement(sort).click().perform();
				Thread.sleep(3000);
				builder.moveToElement(sort).click().perform();
				
				String AfterSort=driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputDateTime'])[1]")).getText();
				Date date2 = formatter.parse(AfterSort);
				Assert.assertNotEquals(date1, date2);
	}

}