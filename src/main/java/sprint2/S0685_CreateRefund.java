package sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S0685_CreateRefund extends BaseClass
{
	@Test
	public void CreateRefundtest() throws InterruptedException 
	{
		//Click on menu button from the Left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Click view All and click Service Console from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		Thread.sleep(3000);
		
		//Click on the drop down and select Refunds
		driver.findElement(By.xpath("(//button[@type='button']//following::lightning-primitive-icon)[8]")).click();
		Thread.sleep(3000);
		WebElement refund=driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-standard-maintenance-plan slds-m-right--small slds-icon_container']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",refund);
		driver.executeScript("arguments[0].click();", refund);
		
		//Click on New
		WebElement newRefund=driver.findElement(By.xpath("(//div[@title='New'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);",newRefund);
		driver.executeScript("arguments[0].click();", newRefund);
		
		//Select Account name
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("(//div[@title='Ramkumar'])[2]")).click();
		
		//Select Status as Canceled
		driver.findElement(By.xpath("//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[text()='Canceled']")).click();
		
		//Give Amount as 50000 and select Referenced in Type
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("5000");
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Referenced']")).click();
		Thread.sleep(3000);
		
		//Select Processing Mode as External
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//a[@title='External']")).click();
		
		WebElement save=driver.findElement(By.xpath("//button[@title='Save']"));
		driver.executeScript("arguments[0].click();", save);
		
		String actualResult=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(actualResult);
		String expectedResult="created";
		if(actualResult.contains(expectedResult))
			System.out.println("Data is Created");
		else
			System.out.println("Data is not created");
	}
}

