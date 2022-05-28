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

public class S0635_EditLegalEntity extends BaseClass
{
	@Test
	public void testEditLegalEntity() throws InterruptedException 
	{
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on Opportunity tab 
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class=\"slds-truncate\"]")).click();
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("Salesforce Automation By Radhika");
		Thread.sleep(3000);
		WebElement editLegalEntity = driver.findElement(By.xpath("(//a[@role='button'])[19]")); 
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
}
