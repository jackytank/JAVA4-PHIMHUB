package test;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtil;

public class TestUserManager {
	String url = "http://localhost:8080/assm-user/user/index";
	public WebDriver driver;
	Map<String, Object[]> res;
	int index;

	@BeforeClass
	public void initiateStep() {
		res = new LinkedHashMap<String, Object[]>();
		index = 0;
		res.put("" + index, new Object[] { "Test ID", "Action", "Input data", "Expected", "Actual", "Result" });
	}

	@AfterClass
	public void finalizeStep() {
		res.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
		});
		try {
			ExcelUtil.exportTestResultExcel(Paths.get("src", "resources", "UserManagerData.xlsx").toFile(), res);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

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

	@Test(dataProvider = "UpdateDataProvider", priority = 1)
	public void testRegistration(String username, String password, String fullname, String email) throws Exception {
		try {
			Thread.sleep(500);
			System.out.println("test is running...");
			// sending test Input data
			driver.findElement(By.name("userId")).sendKeys(username);
			System.out.println(username);
			driver.findElement(By.name("password")).sendKeys(password);
			System.out.println(password);
			driver.findElement(By.name("fullname")).sendKeys(fullname);
			System.out.println(fullname);
			driver.findElement(By.name("email")).sendKeys(email);
			System.out.println(email);
			driver.findElement(By.name("update")).click();
			Thread.sleep(500);
			// check login result by checking page title
			String expectedTitle = "User Management";
			String actualTitle = driver.getTitle();
			assertEquals(expectedTitle, actualTitle);
			boolean result = expectedTitle.equals(actualTitle);
			index++;
			res.put("" + index,
					new Object[] { index, "Test Change password",
							String.format("%s, %s, %s, %s", username, password, fullname, email), expectedTitle,
							actualTitle, result ? "Passed" : "Fail" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] UpdateDataProvider() throws Exception {
		String excelFilePath = Paths.get("src", "resources", "UserManagerData.xlsx").toFile().getAbsolutePath();
		Object[][] arr = ExcelUtil.getTableArray(excelFilePath, "LOGIN_DATA", 4);
		return arr;
	}

	@Test(dataProvider = "DeleteDataProvider", priority = 2)
	public void testdelete(String username, String password, String fullname, String email) throws Exception {
		try {
			Thread.sleep(500);
			System.out.println("test is running...");
			// sending test Input data
			driver.findElement(By.name("userId")).sendKeys(username);
			System.out.println(username);
			driver.findElement(By.name("password")).sendKeys(password);
			System.out.println(password);
			driver.findElement(By.name("fullname")).sendKeys(fullname);
			System.out.println(fullname);
			driver.findElement(By.name("email")).sendKeys(email);
			System.out.println(email);
			driver.findElement(By.name("delete")).click();
			Thread.sleep(500);
			// check login result by checking page title
			String expectedTitle = "User Management";
			String actualTitle = driver.getTitle();
			assertEquals(expectedTitle, actualTitle);
			boolean result = expectedTitle.equals(actualTitle);
			index++;
			res.put("" + index,
					new Object[] { index, "Test Change password",
							String.format("%s, %s, %s, %s", username, password, fullname, email), expectedTitle,
							actualTitle, result ? "Passed" : "Fail" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] DeleteDataProvider() throws Exception {
		String excelFilePath = Paths.get("src", "resources", "UserManagerData.xlsx").toFile().getAbsolutePath();
		Object[][] arr = ExcelUtil.getTableArray(excelFilePath, "RESULT", 4);
		return arr;

	}

	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}
}
