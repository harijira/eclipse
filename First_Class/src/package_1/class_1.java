package package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class class_1 {
	public static String ur1_1="https://demo.guru99.com/test/newtours/login.php";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//Hariharamanikandan K//Downloads//chromedriver-win32//chromedriver-win32//chromedriver.exe/");
		WebDriver driver=new ChromeDriver();
		driver.get(ur1_1);
		driver.findElement(By.name("userName")).sendKeys("user");
		//driver.findElement(By.xpath("//*[@maxlength='60']")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
