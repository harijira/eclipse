package definitionguru;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GuruStepD {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
//	public WebDriver driver=new ChromeDriver();
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	@Given("User should be in the signon page of guru99 mercurytours")
	public void user_should_be_in_the_signon_page_of_guru99_mercurytours() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		
		/*htmlreporter=new ExtentHtmlReporter("extent_report.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		test=extent.createTest("first cucumber project-test");*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@And("Enter the user name {string}")
	public void enter_the_user_name(String string) throws InterruptedException {
		htmlreporter=new ExtentHtmlReporter("extent_report.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		test=extent.createTest("first cucumber project-test");
		driver.findElement(By.name("userName")).sendKeys(string);
		Thread.sleep(2000);
		test.pass("user name entered");
	}

	@And("Enter the Password {string}")
	public void enter_the_password(String string) throws InterruptedException {
		driver.findElement(By.name("password")).sendKeys(string);
		test.pass("password entered");
		Thread.sleep(2000);
	}

	@When("click on the submit button")
	public void click_on_the_submit_button() {
		driver.findElement(By.name("submit")).click();
		test.pass("clicked the submit button");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User should be in the {string}")
	public void user_should_be_in_the(String string) {
	    String etitle=string;
	    String atitle=driver.getTitle();
	    Assert.assertEquals(etitle, atitle);
	    test.pass("Sign-on is successful");
	    System.out.println("Sign-on is successful");
	}

	@And("Click on the register")
	public void click_on_the_register() throws InterruptedException {
		driver.findElement(By.linkText("REGISTER")).click();
		test.pass("click on register");
		Thread.sleep(7000);
	}

	@And("Enter the first name {string}")
	public void enter_the_first_name(String string) {
		driver.findElement(By.name("firstName")).sendKeys(string);
		test.pass("entered the first name");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@And("Enter the last name {string}")
	public void enter_the_last_name(String string) {
		driver.findElement(By.name("lastName")).sendKeys(string);
		test.pass("entered the last name");
	}

	@And("Enter the phone number {string}")
	public void enter_the_phone_number(String string) {
		driver.findElement(By.name("phone")).sendKeys(string);
		test.pass("entered the phone number");
	}

	@And("Enter the email id {string}")
	public void enter_the_email_id(String string) throws InterruptedException {
		driver.findElement(By.name("userName")).sendKeys(string);
		test.pass("entered the email id");
		Thread.sleep(2000);
	}

	@And("Enter the address {string}")
	public void enter_the_address(String string) {
		driver.findElement(By.name("address1")).sendKeys(string);
		test.pass("entered the address");
	}

	@And("Enter the city {string}")
	public void enter_the_city(String string) {
		driver.findElement(By.name("city")).sendKeys(string);
		test.pass("entered the city name");
	}

	@And("Enter the state or province {string}")
	public void enter_the_state_or_province(String string) {
		driver.findElement(By.name("state")).sendKeys(string);
		test.pass("entered the state name");
	}

	@And("Enter the postal code {string}")
	public void enter_the_postal_code(String string) {
		driver.findElement(By.name("postalCode")).sendKeys(string);
		test.pass("entered the postalcode");
	}

	@And("Select the country from drop down list")
	public void select_the_country_from_drop_down_list() throws InterruptedException {
		WebElement country=driver.findElement(By.name("country"));
		Select drop=new Select(country);
		drop.selectByIndex(107);
		test.pass("selected the country name");
		Thread.sleep(2000);
	}

	@And("Enter the username {string}")
	public void enter_the_username(String string) {
		driver.findElement(By.name("email")).sendKeys(string);
		test.pass("entered the username for registration");
	}

	@And("Enter the password for this user {string}")
	public void enter_the_password_for_this_user(String string) {
		driver.findElement(By.name("password")).sendKeys(string);
		test.pass("entered the password for registration");
	}

	@And("Enter the password again to confirm {string}")
	public void enter_the_password_again_to_confirm(String string) throws InterruptedException {
		driver.findElement(By.name("confirmPassword")).sendKeys(string);
		test.pass("entered the conformation password for registration");
		Thread.sleep(2000);
	}

	@When("Click on the submit button to register")
	public void click_on_the_submit_button_to_register() throws InterruptedException {
		driver.findElement(By.name("submit")).click();
		test.pass("clicked the submit button for registration");
		Thread.sleep(2000);
	}

	@Then("User should be in {string}")
	public void user_should_be_in(String string) {
	    String rtitle=string;
	    String currenttitle=driver.getTitle();
	    Assert.assertEquals(rtitle, currenttitle);
	    test.pass("Registeration is successful");
	    System.out.println("Registeration is successful");
	    extent.flush();
	    driver.close();
	    
	}

	@Given("User should be in the guru99 mercurytours signon page")
	public void user_should_be_in_the_guru99_mercurytours_signon_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@And("Enter the invalid user name {string}")
	public void enter_the_invalid_user_name(String string) {
		driver.findElement(By.name("userName")).sendKeys(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@And("Enter the invalid password {string}")
	public void enter_the_invalid_password(String string) {
		driver.findElement(By.name("password")).sendKeys(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("click on the submit button with invalid inputs")
	public void click_on_the_submit_button_with_invalid_inputs() {
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("User should remain in signon page")
	public void user_should_remain_in_signon_page() {
	    String signtitle="Sign-on: Mercury Tours";
	    String logtitle=driver.getTitle();
	    Assert.assertEquals(signtitle, logtitle);
	    System.out.println("Enter Valid Credentials");
	}
}
