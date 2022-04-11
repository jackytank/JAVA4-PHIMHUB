package test;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtil;

public class TestForgotPassword {
	String url = "http://localhost:8080/assm-user/ForgotPassword";
	public ChromeDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void launchBrowser() throws Exception {
		System.out.println("Launching Chrome browser...");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test(dataProvider = "ForgotPasswordDataProvider")
	public void testForgotPassword(String username, String email) throws Exception {
		try {
			Thread.sleep(500);
			System.out.println("testForgotPassword1 running...");
			// sending test Input data
			driver.findElement(By.name("userId")).sendKeys(username);
			System.out.println(username);
			driver.findElement(By.name("email")).sendKeys(email);
			System.out.println(email);
			driver.findElement(By.name("btnRetrieve")).click();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] ForgotPasswordDataProvider() throws Exception {
		String excelFilePath = Paths.get("src", "resources", "TestForgotPassword.xlsx").toFile().getAbsolutePath(); 
		Object[][] arr  = ExcelUtil.getTableArray(excelFilePath, "Sheet1", 2);
		return arr;
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}
}
