package testpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitAnnotations {
	WebDriver driver;
	@Before
	public void bef() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}
	@Test
	public void tc1() {
		String title=driver.getTitle();
		System.out.println("Title: "+title);
	}
	@Test
	public void tc2() {
		System.out.println(driver.getCurrentUrl());
	}
	@After
	public void cl() {
		driver.close();
	}
}
