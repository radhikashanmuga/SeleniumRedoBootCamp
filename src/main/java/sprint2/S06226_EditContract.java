package sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S06226_EditContract
{
	@Test
	public void editContract() throws InterruptedException
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
		//4. Click the Contract tab
		//driver.findElement(By.xpath("(//span[text()='Contracts'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='slds-page-header__name-switcher']")).click();
		driver.findElement(By.xpath("//span[text()='All Contracts']")).click();
		//5. Search the Account number in the Search box
		WebElement search=driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		search.click();
		search.sendKeys("00000165");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Actions sear=new Actions(driver);
		sear.moveToElement(search).doubleClick().perform();
		WebElement closebox=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']"));
		closebox.click();
		
		//6.Click on the Dropdown icon and Select Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//7.Select Status as 'Activated'
		WebElement status=driver.findElement(By.xpath("//a[@class='select' and @data-interactive-lib-uid='8']"));
		Actions sta=new Actions(driver);
		sta.moveToElement(status).click().perform();
		driver.findElement(By.xpath("//a[@role='menuitemradio' and @title='Activated']")).click();
		Thread.sleep(15);
		//8.Select Owner Expiration Notice as'30 days'
		WebElement owner=driver.findElement(By.xpath("//a[@class='select' and @data-interactive-lib-uid='15']"));
		Actions ownerExp=new Actions(driver);
		ownerExp.moveToElement(owner).click().perform();
		driver.findElement(By.xpath("//a[@role='menuitemradio' and @title='30 Days']")).click();
		//9.Click save and Verify the Status
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		WebElement savemes=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		String actual=savemes.getText();
		System.out.println(actual);
		String expected="saved";
		if(actual.contains(expected))
		{
			System.out.println("Record is edited");
		}
		else
		{
			System.out.println("Record is not edited");
		}
	}

}
