package test;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtil;

public class TestRegistrationServlet {
	String url = "http://localhost:8080/assm-user/Registration";
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
