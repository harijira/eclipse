package testpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void OrangeLogin() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(1000);
		
		
		htmlreporter=new ExtentHtmlReporter("extent.html"); //reports in html format
		extent=new ExtentReports();  //html report
		extent.attachReporter(htmlreporter); //attaching both the reports
		
		
		String otitle=driver.getTitle();
		driver.manage().window().maximize();
	}
	@Test(enabled = true,priority = 0)
	public void OrangeTest() throws InterruptedException {
		WebElement uname=driver.findElement(By.name("username"));
		uname.sendKeys("Admin");
		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
		WebElement pword=driver.findElement(By.name("password"));
		pword.sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		/*//WebDriverWait wait=new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit']")));
		
		driver.findElement(By.linkText("Admin")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys("abcd");
		driver.findElement(By.xpath("//*[@placeholder='Type for hints...']")).sendKeys("employeeone");
		Thread.sleep(2000);
		WebElement ddb1=driver.findElement(By.xpath("(//*[@class='oxd-select-text-input'])[1]"));
		Actions keyact=new Actions(driver);
		Thread.sleep(2000);
		keyact.sendKeys(ddb1, Keys.ARROW_DOWN).click().build().perform();
		//keyact.sendKeys(ddb1, Keys.ARROW_DOWN).click().build().perform();
		driver.navigate().refresh();
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();*/
		
	}
	@Test(enabled = false,priority = 1)
	public void OrangeLinks() {
		List<WebElement> olinks=driver.findElements(By.tagName("a"));
		List<WebElement> xllinks=driver.findElements(By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']"));
		System.out.println("The available Links are: ");
		for(int i=0; i<olinks.size(); i++) {
			String linkhref=olinks.get(i).getAttribute("href");
			//System.out.println(linkhref);
			System.out.println("link text: "+olinks.get(i).getText());
			String linkxl= xllinks.get(i).getAttribute("xmlns");
			System.out.println("xmlns: "+linkxl);
		}
		System.out.println("\nNumber of links: "+olinks.size());
		System.out.println("Number of xmlns-links: "+xllinks.size()+"\n");
	}
	@Test(enabled = false,priority = 2)
	public void MouseCheck() {
		Actions maction=new Actions(driver);
		WebElement button=driver.findElement(By.className("oxd-main-menu-item-wrapper"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu-item-wrapper")));
		maction.contextClick(button).click().perform();
	}
	@Test(enabled = true,priority = 1)
	public void Table() {
		test=extent.createTest("This is my first test"); //must use this line
		driver.findElement(By.linkText("Admin")).click();
		test.pass("i clicked on admin");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		List<WebElement> rows=driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
		test.pass("finiding the list of web elements");
		int nrows=rows.size();
		System.out.println(nrows);
		test.pass("pinting the size of the rows");
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(3).click();
		test.pass("clicking on the checkbox");
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(3).click();
		test.pass("clicking on delete icon");
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")));
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		test.pass("deleting the user");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		extent.flush();
	}
}
