package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandling {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
	WebDriver cdriver;
	WebDriver edriver;
	WebDriver fdriver;
	WebDriver odriver;
	@Parameters("{mybrowser}")
	
	@BeforeTest
	public void openBrowser(@Optional("chrome") String mybrowser) {  //String mybrowser
		if(mybrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			cdriver=new ChromeDriver();
			cdriver.get(url);
		}
		else if (mybrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			edriver=new EdgeDriver();
			edriver.get(url);
		}
		
		/*WebDriverManager.edgedriver().setup();
		edriver=new EdgeDriver();
		edriver.get(url);*/
		
		/*WebDriverManager.firefoxdriver().setup();
		fdriver=new FirefoxDriver();
		fdriver.get(url);*/
		
		/*WebDriverManager.operadriver().setup();
		odriver=new OperaDriver();
		odriver.get(url);*/
	}
	@Test
	public void tc1() {
		System.out.println("hi");
	}
}
