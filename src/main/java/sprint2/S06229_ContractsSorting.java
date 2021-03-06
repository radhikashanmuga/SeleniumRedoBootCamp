package sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S06229_ContractsSorting extends BaseClass
{
	public void contractSorting() throws InterruptedException 
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
		//5.Sort the Contracts by Contract number in ascending order
		driver.findElement(By.xpath("//span[text()='Sort']")).click();
		//6. Verify the Contracts displayed in ascending order by Contract number
	}

	
}
