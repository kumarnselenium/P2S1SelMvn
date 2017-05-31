

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizationTest {

	WebDriver oBrowser;
	
	@Test
	public void eBayInChrome()
	{
		
		ExcelRead oExcel = new ExcelRead("C:\\Selenium\\Selenium Docs\\P2S1 Class Notes\\eBayTestData.xls","Search");
				
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		oBrowser = new ChromeDriver();
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("http://www.ebay.com/");
		
		//3. Enter "laptop" in search text box
		//3.a ==> Recognize the text box ==> oBrowser.findElement(By.id("gh-ac"))
		//3.b then Enter value to the text box
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys(oExcel.getCellData("SearchFor", 1));
		
		//4. Click on "Search" button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		//5. Click on "Advanced" link
		oBrowser.findElement(By.linkText("Advanced")).click();
		
	}

	public void eBayInChromeDataDrivenScenario() throws InterruptedException
	{
		ExcelRead oExcel = new ExcelRead("C:\\Selenium\\Selenium Docs\\P2S1 Class Notes\\eBayTestData.xls","Search");
		
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		oBrowser = new ChromeDriver();
	
		for(int i=1; i<oExcel.rowCount(); i++)
		{	
			//2. Launch ==> www.ebay.com
			oBrowser.get("http://www.ebay.com/");
			
			//3. Enter "laptop" in search text box
			//3.a ==> Recognize the text box ==> oBrowser.findElement(By.id("gh-ac"))
			//3.b then Enter value to the text box
			oBrowser.findElement(By.id("gh-ac")).clear();
			oBrowser.findElement(By.id("gh-ac")).sendKeys(oExcel.getCellData("SearchFor", i));
			
			//4. Click on "Search" button
			oBrowser.findElement(By.id("gh-btn")).click();
			
			//5. Click on "Advanced" link
			oBrowser.findElement(By.linkText("Advanced")).click();
			
			Thread.sleep(4000);
		}
	}
	
}
