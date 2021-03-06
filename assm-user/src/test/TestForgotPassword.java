package test;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class TestForgotPassword {
	String url = "http://localhost:8080/assm-user/ForgotPassword";
	public ChromeDriver driver;
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
			ExcelUtil.exportTestResultExcel(Paths.get("src", "resources", "ForgotPasswordData.xlsx").toFile(), res);
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
			// check forgot password result by checking page title
			String expectedTitle = "Phimkhongmoi";
			String actualTitle = driver.getTitle();
			assertEquals(expectedTitle, actualTitle);
			boolean result = expectedTitle.equals(actualTitle);
			index++;
			res.put("" + index, new Object[] { index, "Test Change password", username + ", " + email, expectedTitle,
					actualTitle, result ? "Passed" : "Fail" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] ForgotPasswordDataProvider() throws Exception {
		String excelFilePath = Paths.get("src", "resources", "ForgotPasswordData.xlsx").toFile().getAbsolutePath();
		Object[][] arr = ExcelUtil.getTableArray(excelFilePath, "Sheet1", 2);
		return arr;
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}
}
