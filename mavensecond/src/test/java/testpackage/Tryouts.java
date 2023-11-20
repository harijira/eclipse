package testpackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tryouts {
	public static String url = "https://www.makemytrip.com/holidays-india/";
    WebDriver driver;
    @BeforeTest
    public void openurl() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }
    @Test
    public void tc1() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement inputElement = driver.findElement(By.id("fromCity"));
        String value = inputElement.getAttribute("value");
        System.out.println(value);
    	inputElement.click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	Actions mact=new Actions(driver);
    	mact.click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//*[@data-testid='Hyderabad']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.xpath("//*[@data-cy='toCity']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("(//*[@class='dest-city-name'])[4]")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.xpath("//*[@aria-label='Fri Nov 24 2023']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.xpath("//*[@class='applyBtn']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.className("action")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("search_button")).click();
    	Thread.sleep(3000);
//    	driver.findElement(By.className("skipBtn")).click();
    	driver.navigate().refresh();
    	Thread.sleep(5000);
    }
    @Test
    public void tc2() throws InterruptedException {
    	JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,400)");
		//driver.findElement(By.className("skipBtn")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	WebElement pack=driver.findElement(By.xpath("(//*[@class='silderCardImage  active '])[2]"));
    	WebDriverWait exwait=new WebDriverWait(driver, 10);
    	exwait.until(ExpectedConditions.visibilityOf(pack));
    	pack.click();
    	Thread.sleep(3000);
    	
    	Set<String> s = driver.getWindowHandles();
    	System.out.println(s);
    	Iterator<String> it = s.iterator();
    	String child=it.next();
    	child=it.next();
    	System.out.println(child);
    	driver.switchTo().window(child);
    	Thread.sleep(3000);
    }
    @Test
    public void tc3() {
    	JavascriptExecutor scroll=(JavascriptExecutor)driver;
    	scroll.executeScript("window.scrollBy(0,400)");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	WebElement htxt= driver.findElement(By.xpath("//div[contains(@class,'appendRight3' and text()='Hotels']"));
    	System.out.println(htxt.getText());
    }
}
