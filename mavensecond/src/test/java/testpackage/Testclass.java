package testpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testclass {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	@BeforeSuite
	public void bf() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}
	@Test(enabled = false)
	public void tc1() {
		WebElement uname=driver.findElement(By.name("userName"));
		uname.sendKeys("user");
		driver.findElement(By.name("userName")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		//System.out.println("hello");password submit
	}
	@Test(enabled = false, priority = 0)
	public void tc2() throws InterruptedException {
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(1000);
		WebElement fname=driver.findElement(By.name("firstName"));
		fname.sendKeys("abcd");
		Thread.sleep(1000);
		WebElement lname=driver.findElement(By.name("lastName"));
		lname.sendKeys("wxyz");
		Thread.sleep(1000);
		WebElement pnum=driver.findElement(By.name("phone"));
		pnum.sendKeys("123456789");
		Thread.sleep(1000);
		WebElement email=driver.findElement(By.name("userName"));
		email.sendKeys("abc@example.com");
		Thread.sleep(2000);//address1
	}
	@Test(enabled = false, priority = 1)
	public void tc3() throws InterruptedException {
		WebElement add=driver.findElement(By.name("address1"));
		add.sendKeys("qwerty");
		WebElement city=driver.findElement(By.name("city"));
		city.sendKeys("chennai");
		WebElement state=driver.findElement(By.name("state"));
		state.sendKeys("TN");
		WebElement pcode=driver.findElement(By.name("postalCode"));
		pcode.sendKeys("654852");//country
		WebElement country=driver.findElement(By.name("country"));
		//country.click();
		//country.sendKeys("INDIA"); for dropdown box we use select method
		Select drop=new Select(country);
		drop.selectByIndex(107);
		Thread.sleep(1000);
		WebElement name=driver.findElement(By.name("email"));
		name.sendKeys("hjkl");
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys("password");
		WebElement cpass=driver.findElement(By.name("confirmPassword"));
		cpass.sendKeys("password");
		Thread.sleep(2000);//submit
		driver.findElement(By.name("submit")).click();
		
	}
	@Test(enabled = false, priority = 0)
	public void links() {
        List<WebElement> link= driver.findElements(By.tagName("a"));  //all links in a tag
        link.size();
        for(int i=0;i<link.size();i++)
        {
           String ab=link.get(i).getAttribute("href");
           String c="https://demo.guru99.com/test/newtours/support.php";
           if(ab.equals(c)) {
               System.out.println("LINKS ARE UNDER CONSTRUCTION"+link.get(i).getText());
           }
           else {
               System.out.println("Links are working"+link.get(i).getText());
           }
        }
	}
	@Test(enabled = false)
	public void acts() {
    	// Actions are of two types 1.Mouse over actions  2.Keyboard actions
    	// Mouse over actions
    	Actions act=new Actions(driver);
    	WebElement us=driver.findElement(By.name("userName"));
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //alternative to thread.sleep
    	//web driver waits for a specified time and it will not find the element again
    	act.contextClick(us).click().build().perform();
    	//driver.close();
    }
	@Test
	public void res() {
    	String expected= driver.getTitle();
    	WebElement usr=driver.findElement(By.name("userName"));
        usr.sendKeys("user");
        WebElement pass=driver.findElement(By.name("password"));
        pass.sendKeys("user");
        driver.findElement(By.name("submit")).click();
        String actual=driver.getTitle();
        //Assert.assertEquals(expected, actual);
        if(expected.equalsIgnoreCase(actual)) {
        	System.out.println("Titles are same");
        }
        else {
        	System.out.println("Titles are not same, expected: "+expected+". But found: "+actual);
        }
    }
	/*
	@AfterSuite
	public void as() {
		
	}
	@AfterTest
	public void at() {
		
	}*/
}
