package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0685_CreateRefund 
{
	public static void main(String[] args) throws InterruptedException 
	{
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
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button']//following::lightning-primitive-icon)[8]")).click();
		WebElement refund=driver.findElement(By.xpath("//span[text()='Refunds']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",refund);
		driver.executeScript("arguments[0].click();", refund);
		WebElement newRefund=driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);",newRefund);
		driver.executeScript("arguments[0].click();", newRefund);
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("(//div[@title='Ramkumar'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[text()='Canceled']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("5000");
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Referenced']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		
		//driver.findElement(By.xpath("//a[@title='External']")).click();
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight);",driver);	
	}
}
