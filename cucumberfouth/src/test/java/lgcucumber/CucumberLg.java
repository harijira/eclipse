package lgcucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberLg {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	@Given("I should be in the login page of the OrangeHRM")
	public void i_should_be_in_the_login_page_of_the_orange_hrm() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@And("Enter the user name {string}")
	public void enter_the_user_name(String string) {
		driver.findElement(By.name("username")).sendKeys(string);
	}

	@And("Enter the Password {string}")
	public void enter_the_password(String string) throws InterruptedException {
		driver.findElement(By.name("password")).sendKeys(string);
		Thread.sleep(2000);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Then("I should see the title as {string}")
	public void i_should_see_the_title_as(String string) {
		String otitle="OrangeHRM";
		String ptitle=driver.getTitle();
		System.out.println("Page Title: "+ptitle);
		driver.close();
	}
}
