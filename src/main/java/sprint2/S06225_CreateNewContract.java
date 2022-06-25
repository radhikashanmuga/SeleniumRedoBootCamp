package sprint2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S06225_CreateNewContract 
{

	@Test
	public void createContract() throws InterruptedException
	{
		/*//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		
		//3. Click View All and click 'Contract' from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//mark[text()='Contracts'])[1]")).click();
		//4. Click on the Dropdown icon in the Contract tab
		Thread.sleep(10000);
		//driver.findElement(By.xpath("(//a[@title='Contracts']//following::lightning-primitive-icon)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Contracts'])[1]/following::a[1]")).click();
		Thread.sleep(3000);
		//5. Click on New Contract
		WebElement newContract=driver.findElement(By.xpath("//span[text()='New Contract']"));
		
		driver.executeScript("arguments[0].click();", newContract);
		
		//6. Select the accounts listed on the'Account Name' field
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("(//div[@title='Your Name'])[1]")).click();
		//7.Select the Contract Start Date as Tommorow's Date
		Date dt=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		dt=calendar.getTime();
		String tomorrowDate=new SimpleDateFormat("MM/dd/yyyy").format(dt);
		WebElement tomDate=driver.findElement(By.xpath("(//input[@class=' input'])[1]"));
		tomDate.sendKeys(tomorrowDate);
		//8.Enter Contract Term (months) as' 6 '
		
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("6");
		
		//9.Click save and Verify the Contract Name
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		
		//10.Get the Contract number
		//11.Get the difference between  the Contract Start Date and End Date and Check it matches the Contract Term.
		*/
		
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
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts");
		WebElement contract=driver.findElement(By.xpath("//a[@data-label='Contracts']"));
		Actions selectContract=new Actions(driver);
		selectContract.moveToElement(contract).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement contractDD=driver.findElement(By.xpath("//a[@title='Recently Viewed | Contracts']"));
		//Actions selectDD=new Actions(driver);
		//selectDD.moveToElement(contractDD).click().perform();
		String contractTitle=contractDD.getText();
		try 
		{
			if(contractTitle.contains("Contracts"))
			{
				driver.findElement(By.xpath("//a[@title='New']")).click();
				driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
				driver.findElement(By.xpath("(//div[@title='Test'])[1]")).click();
				Date dt=new Date();
				Calendar calendar=Calendar.getInstance();
				calendar.add(Calendar.DATE, 1);
				dt=calendar.getTime();
				String tomorrowDate=new SimpleDateFormat("MM/dd/yyyy").format(dt);
				WebElement tomDate=driver.findElement(By.xpath("(//input[@class=' input'])[1]"));
				tomDate.sendKeys(tomorrowDate);
				driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("6");
				
				//9.Click save and Verify the Contract Name
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			}
			else
			{
				System.out.println("");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		WebElement newContract=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		String actualtext=newContract.getText();
		String expText="created";
		if(actualtext.contains(expText))
		{
			System.out.println("New Contract is created");
		}
		else
			System.out.println("New Contract not created");
	}
}

