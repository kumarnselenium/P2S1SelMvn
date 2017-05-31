

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FileUploadTest {
		
	@Test
	public void example() throws AWTException, InterruptedException, MalformedURLException
	{
		/*System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		ChromeDriver oBrowser = new ChromeDriver();*/
	
		//just updates
		System.out.println("hi");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setVersion("58");
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		RemoteWebDriver oBrowser = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);

		//System.setProperty("webdriver.chrome.driver", "");
		oBrowser.get("http://www.zamzar.com/");
		//oBrowser.manage().window().maximize();
		
		oBrowser.findElement(By.id("inputFile")).click();
		
		String sFilePath = "C:\\Selenium\\Selenium Docs\\Selenium Syllabus_H2K.pdf";
		
		//Selecting the String(path of the file)
		StringSelection oFilePathToBeUpload = new StringSelection(sFilePath);
		
		//Copying the path into Clipboard => Ctrl+C
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(oFilePathToBeUpload, null);
		
		//3. Goto the place where we want to paste - cursor focus
		Robot oRbt = new Robot();
		oRbt.keyPress(KeyEvent.VK_ENTER);
		oRbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		//Ctrl + V = pasting the path (from Clipboard) 
		oRbt.keyPress(KeyEvent.VK_CONTROL);
		oRbt.keyPress(KeyEvent.VK_V);
		oRbt.keyRelease(KeyEvent.VK_CONTROL);
		oRbt.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		
		oRbt.keyPress(KeyEvent.VK_ENTER);
		oRbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		//oRbt.keyPress(KeyEvent.VK_ENTER);
		//oRbt.keyRelease(KeyEvent.VK_ENTER);
		
		oBrowser.quit();
		
		
	}

	
}
