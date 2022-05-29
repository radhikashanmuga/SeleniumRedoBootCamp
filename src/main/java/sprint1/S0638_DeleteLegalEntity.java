package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S0638_DeleteLegalEntity extends BaseClass
{
	
	@Test
	public void deleteLegalEntity() throws InterruptedException
	{
		//Click on toggle menu button from the left corner		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();		
		//Click on Opportunity tab 
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");	
		driver.findElement(By.xpath("//p[@class=\"slds-truncate\"]")).click();	
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("Salesforce Automation By Radhika");
		Thread.sleep(3000);
		WebElement deleteLegalEntity = driver.findElement(By.xpath("(//a[@role='button'])[19]")); 
		driver.executeScript("arguments[0].click();", deleteLegalEntity);	
		WebElement dropdown=driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click();", dropdown);		
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String actualResult=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(actualResult);
		String expectedResult="deleted";
		if(actualResult.contains(expectedResult))
			System.out.println("Data is deleted");
		else
					System.out.println("Data is not deleted");
	}

}
