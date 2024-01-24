package Pages;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;

public class LoginPage {
	
	public static WebDriver driver =null;
	

	public void launchbrowser() {

		System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		// Instantiate a ChromeDriver class.
		
		 driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.adp.com/");

		

	}
	
	public static void enterDetails(DataTable dataTable)  {
		
		System.out.println(dataTable.asLists().get(1).get(1));
		driver.findElement(By.xpath("//input[@data-sc-field-name='Full_Name']")).sendKeys(dataTable.asLists().get(0).get(1));
		driver.findElement(By.xpath("//input[@data-sc-field-name='Email']")).sendKeys(dataTable.asLists().get(1).get(1));
		driver.findElement(By.xpath("//input[@data-sc-field-name='Phone']")).sendKeys("980765443");
	
		try {
			takeSnapShot(driver,"./test.png");
		} catch (Exception e) {
			
		}
		
		driver.quit();
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
