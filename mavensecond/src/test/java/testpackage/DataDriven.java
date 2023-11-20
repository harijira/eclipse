package testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	public String user,pass;
	@BeforeSuite
	public void bf() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test
	public void dd() throws IOException, InterruptedException, InvalidFormatException {
//		File ddriven=new File("C://Users//Hariharamanikandan K//Desktop//Moolya//datadriven.xlsx/");
		FileInputStream stream=new FileInputStream("C://Users//Hariharamanikandan K//Desktop//Moolya//datadriven.xlsx/");  //getting the data from excel
		XSSFWorkbook book=new XSSFWorkbook(stream);  //my excel sheet is in xssf workbook format
		XSSFSheet sheet=book.getSheet("Sheet1");   //taking the input from the sheet1 present in xssf format
		int rowcount=sheet.getLastRowNum();
		System.out.println("rowcount: "+rowcount);
		for(int i=0; i<=rowcount; i++) {
			String user=sheet.getRow(i).getCell(0).getStringCellValue();
			String pass=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(user);
			System.out.println(pass);
			driver.findElement(By.name("userName")).sendKeys(user);
			
			driver.findElement(By.name("password")).sendKeys(pass);
			
			driver.findElement(By.name("submit")).click();
			Thread.sleep(2000);
			}
	}
}