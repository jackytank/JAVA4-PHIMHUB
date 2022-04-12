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

public class TestChangePassword {
	String url = "http://localhost:8080/assm-user/ChangePassword";
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

	@Test(dataProvider = "ChangePasswordDataProvider")
	public void testChangePassword(String username, String password, String newPass, String retype) throws Exception {
		try {
			Thread.sleep(500);
			System.out.println("testChangePassword1 running...");
			// sending test input data to login page
			driver.findElement(By.name("userId")).sendKeys(username);
			System.out.println(username);
			driver.findElement(By.name("password")).sendKeys(password);
			System.out.println(password);
			driver.findElement(By.name("loginBtn")).click();
			driver.get(url);

			// sending test Input data
			driver.findElement(By.name("userId")).sendKeys(username);
			System.out.println(username);
			driver.findElement(By.name("currentPassword")).sendKeys(password);
			System.out.println(password);
			driver.findElement(By.name("newPass")).sendKeys(newPass);
			System.out.println(newPass);
			driver.findElement(By.name("retype")).sendKeys(retype);
			System.out.println(retype);
			driver.findElement(By.name("changeBtn")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] ChangePasswordDataProvider() throws Exception {
		String excelFilePath = Paths.get("src", "resources", "ChangePasswordData.xlsx").toFile().getAbsolutePath();
		Object[][] arr = ExcelUtil.getTableArray(excelFilePath, "Sheet1", 4);
		return arr;
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}
}
