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


public class S0636_CreateLegalEntityWithoutMandatoryField extends BaseClass
{

	@Test
	public void testMandatoryField()
	{
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
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Test Leaf");
		driver.findElement(By.xpath("(//textarea[@role='textbox'])[1]")).sendKeys("Nanganallur");
		driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("Salesforce Automation");
		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@placeholder='State']")).sendKeys("TN");
		driver.findElement(By.xpath("//input[@placeholder='Postal Code']")).sendKeys("600091");
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("India");
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Active']")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String ActualResult=driver.findElement(By.xpath("//li[text()='Complete this field.']")).getText();
		String ExpectedResult="Complete this field.";
		Assert.assertEquals(ExpectedResult, ActualResult);
	}
	

}
