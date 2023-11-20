package makeMyTripProject;

import java.awt.AWTException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMTrip {
	public static String url = "https://www.makemytrip.com/";
    WebDriver driver;
    //WebDriverWait exwait=new WebDriverWait(driver, 10);
    ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
    
    @BeforeTest
    public void open() throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    	
    	htmlreporter=new ExtentHtmlReporter("extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
    }
    @Test(priority = 0)
    public void Holiday_pack() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
    	Thread.sleep(3000);
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	test=extent.createTest("This is a MakeMyTrip project/test");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
    	test.pass("closed the popup");
    	driver.findElement(By.xpath("//*[@class='commonModal__close']")).click();	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	test.pass("closed the account popup");
    	driver.findElement(By.xpath("//*[@href='https://www.makemytrip.com/holidays-india/']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	test.pass("clicked on holiday packages");
    }
    @Test(priority = 1)
    public void package_search() throws AWTException, InterruptedException {
    	Thread.sleep(3000);
    	WebElement inputElement = driver.findElement(By.id("fromCity"));
        String value = inputElement.getAttribute("value");
        System.out.println(value);
    	inputElement.click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	Actions mact=new Actions(driver);
    	//mact.doubleClick(inputElement).build().perform();
    	mact.click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	//Robot rc = new Robot();
    	//rc.keyPress(MenuKeyEvent.VK_BACK_SPACE);
    	driver.findElement(By.xpath("//*[@data-testid='Hyderabad']")).click();
    	test.pass("selected the 'from city'");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.xpath("//*[@data-cy='toCity']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("(//*[@class='dest-city-name'])[4]")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	test.pass("selected the 'to city'");
    	
    	driver.findElement(By.xpath("//*[@aria-label='Fri Nov 24 2023']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	test.pass("selected the 'date'");
    	
    	driver.findElement(By.xpath("//*[@class='applyBtn']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	test.pass("selected the 'number of guests'");
    	
    	driver.findElement(By.className("action")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("search_button")).click();
    	test.pass("clicked the 'search button'");
    	Thread.sleep(3000);
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void select_package() throws InterruptedException {
    	//skip button
    	if (driver.findElements(By.className("guideContentWrapper")).size() > 0) {
    	    WebElement closeButton = driver.findElement(By.id("skip-btn"));
    	    if (closeButton.isDisplayed() && closeButton.isEnabled()) {
    	        closeButton.click();//(//*[@class='imageSlider'])[2]
    	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//(//*[@class='silderCardImage  active '])[2]
    	    	WebElement pack=driver.findElement(By.xpath("(//*[@class='imageSlider'])[2]"));
    	    	WebDriverWait exwait=new WebDriverWait(driver, 10);
    	    	exwait.until(ExpectedConditions.visibilityOf(pack));
    	    	pack.click();
    	    	test.pass("clicked a 'package'");
    	    }
    	}
    	else {
    		JavascriptExecutor scroll=(JavascriptExecutor)driver;
    		scroll.executeScript("window.scrollBy(0,300)");
    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//(//*[@class='silderCardImage  active '])[2]
        	WebElement pack=driver.findElement(By.xpath("(//*[@class='silderCardImage  active '])[2]"));
        	WebDriverWait exwait=new WebDriverWait(driver, 10);
        	exwait.until(ExpectedConditions.visibilityOf(pack));
        	pack.click();
        	test.pass("clicked a 'package'");
    	}
    	//skip button end
    	
    	JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,200)");
		//driver.findElement(By.className("skipBtn")).click();
		
    	Thread.sleep(3000);
    	
    	Set<String> s = driver.getWindowHandles();
    	System.out.println(s);
    	Iterator<String> it = s.iterator();
    	String child=it.next();
    	child=it.next();
    	System.out.println(child);
    	driver.switchTo().window(child);
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	scroll.executeScript("window.scrollBy(0,300)");
    	Thread.sleep(2000);
    	driver.navigate().refresh();
    	scroll.executeScript("window.scrollBy(0,300)");
    	scroll.executeScript("window.scrollBy(0,300)");
    	
    	WebElement chbutton=driver.findElement(By.xpath("(//*[@id='change'])[3]"));//"arguments[0].scrollIntoView(true);", element
    	chbutton.click();
    	test.pass("clicked on button to change hotel");
    	driver.findElement(By.xpath("//*[@class='primaryBtn fill selectBtn']")).click();//updateHotelBtnClick
    	test.pass("selected a 'new hotel'");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	WebElement mhotel=driver.findElement(By.xpath("//*[@class='hotelHeading'][1]"));
    	String mhotelname=mhotel.getText();
    	System.out.println("\nnew hotel selected: "+mhotelname+"\n");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.id("updateHotelBtnClick")).click();
    	test.pass("updated the 'package'");
    	
    	WebElement numact=driver.findElement(By.xpath("(//*[@class='appendRight3'])[5]"));
    	String activ=numact.getText();
    	int oactivity=Integer.parseInt(activ);
    	System.out.println("original number of activities: "+oactivity);
    	WebElement activity=driver.findElement(By.xpath("(//*[@id='chooseAndAddBtn'])[2]"));
    	scroll.executeScript("arguments[0].scrollIntoView(true)", activity);
    	WebDriverWait exwait=new WebDriverWait(driver, 10);
    	exwait.until(ExpectedConditions.visibilityOf(activity));
    	driver.findElement(By.xpath("(//*[@data-testid='add-activity-button'])[3]")).click();
    	test.pass("clicked on 'add activity'");
    	driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click();
    	test.pass("selected a 'new activity'");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//*[@class='updatePackageBtnText font10 btn btn-primary btn-sm']")).click();
    	test.pass("updated the 'package'");
    	Thread.sleep(2000);
    	String mactiv=driver.findElement(By.xpath("(//*[@class='appendRight3'])[5]")).getText();
    	int mactivity=Integer.parseInt(mactiv);
    	System.out.println("modified number of activities: "+mactivity);
    	driver.findElement(By.xpath("(//*[@class='appendRight3'])[3]")).click();
    	Thread.sleep(2000);
    	WebElement vhotel=driver.findElement(By.xpath("(//*[@class='hotel-row-details-title'])[4]"));
    	String vhotelname=vhotel.getText();
    	System.out.println("\nverify hotel name: "+vhotelname+"\n");
    	
    	if (oactivity < mactivity) {
    		System.out.println("\nProject Success!\n");
    		test.pass("checked the 'updated package' and the updates are reflected");
    	}
    	extent.flush();
    	Thread.sleep(3000);
    }
    @AfterTest
    public void closing() {
    	driver.quit();
    	//System.out.println("hi");
    }
}
