package sprint1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S0630_CreateAccount extends BaseClass
{
	@Test
	public void createAccount() 
	{
		//Click on toggle menu button from the left corner
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		
		//Click on Opportunity tab 
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		
		//Click on New button
		
		
		//Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
		//Choose close date as Today
		//Select 'Stage' as Need Analysis
		//click Save and VerifyOppurtunity Name
	}

}
