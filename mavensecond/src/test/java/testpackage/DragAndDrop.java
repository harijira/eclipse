package testpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	WebDriver driver;
	public static String url="https://jqueryui.com/droppable/";
	
	@BeforeTest
	public void linkopen() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
	}
	@Test
	public void dgdrop() throws InterruptedException {
		//System.out.println("drag and drop");
		int nframes=driver.findElements(By.tagName("iframe")).size();
		List<WebElement> frame=driver.findElements(By.tagName("iframe"));
		frame.get(0).getText();
		System.out.println("frame: "+frame);
		System.out.println("number of frames: "+nframes);
		WebElement frametext=driver.findElement(By.xpath("//*[@class='demo-frame']"));
		//To change the border of a web element.
		//JavascriptExecutor js= ((JavascriptExecutor)driver);
        //js.executeScript("arguments[0].style.border = '3px solid red '", frametext);
        Thread.sleep(3000);
		driver.switchTo().frame(frametext);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions mact=new Actions(driver);
		mact.dragAndDrop(drag, drop).build().perform();
	}
	
}
