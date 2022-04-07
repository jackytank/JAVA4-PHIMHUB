package test;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtil;

public class TestLoginServlet {
	String url = "http://localhost:8080/assm-user/Login";
	public WebDriver driver;

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

	@Test(dataProvider = "loginDataProvider")
	public void testLogin1(String username, String password) {
		try {
			Thread.sleep(500);
			System.out.println("testLogin1 running...");
			// sending test Input data
			driver.findElement(By.name("userId")).sendKeys(username);
			System.out.println(username);
			driver.findElement(By.name("password")).sendKeys(password);
			System.out.println(password);
			driver.findElement(By.name("loginBtn")).click();
			Thread.sleep(500);
			// check login result by checking page title
			String expectedTitle = "Home";
			String actualTitle = driver.getTitle();
			assertEquals(expectedTitle, actualTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] loginDataProvider() throws Exception {
		String excelFilePath = Paths.get("src", "resources", "LoginData.xlsx").toFile().getAbsolutePath(); 
		Object[][] arr  = ExcelUtil.getTableArray(excelFilePath, "Sheet1");
		return arr;
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}
}
