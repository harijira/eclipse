package testpackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupsAlerts extends JavaScript{
	public static String url="https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeTest
	public void openurl() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test(enabled = true)
	public void alert() throws InterruptedException {
		System.out.println("alert");
		WebElement element=driver.findElement(By.id("alertButton"));
		/*System.out.println("Click me button was clicked");
		Alert popalert=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popalert.accept();*/
		 String bgcolor= element.getCssValue("backgroundColor");//gives the background color of the element
	        
	        for(int i=0; i<500; i++) {  // change the background color multiple times
	            changeColor("#005020",element,driver);  //#000000-> This represent black
	            //changeColor(bgcolor,element,driver);  // change to it's original color
		  Thread.sleep(7000);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	}
	@Test(enabled = false)
	public void alert2() {
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait=new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert popalert2=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popalert2.accept();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test(enabled = false)
	public void alert3() throws InterruptedException {
		driver.findElement(By.id("confirmButton")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Alert popalert3=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popalert3.dismiss();
		Thread.sleep(2000);
	}
	@Test(enabled = false)
	public void alert4() throws InterruptedException, IOException {
		driver.findElement(By.id("promtButton")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Alert popalert4=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		popalert4.sendKeys("user");
		Thread.sleep(2000);
		popalert4.accept();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		scroll.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(2000);
		scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		TakesScreenshot sshot=(TakesScreenshot)driver;
		File pic1=sshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic1, new File("C:\\Users\\Hariharamanikandan K\\Pictures\\SeleniumScSh\\Scsh1.png"));
		Thread.sleep(4000);
	}
	@AfterTest
	public void winclose() {
		driver.close();
	}
}
