package sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06227_DeleteContract 
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
		//4. Click the Contract tab
		driver.findElement(By.xpath("(//span[text()='Contracts'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='slds-page-header__name-switcher']")).click();
		driver.findElement(By.xpath("//span[text()='All Contracts']")).click();
		//5. Search the Account number in the Search box
		WebElement search=driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		search.click();
		search.sendKeys("00000111");
		Thread.sleep(3000);
		search.sendKeys(Keys.ENTER);
		
		WebElement closebox=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']"));
		closebox.click();
		
		//6.Click on the Dropdown icon and Select Delete
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//7.Click on the Delete option in the displayed popup window.
		//8. Verify Whether Contract is Deleted using  Contract number
	}

}
