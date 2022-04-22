package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {
	public static String projectPath;
	protected WebDriver driver;
	String url;

	@BeforeGroups("SmokeGroup")
	public void beforeGroup() {
		System.out.println("before group");
	}

	@AfterGroups("SmokeGroup")
	public void afterGroups() {
		System.out.println("after group");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite method");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}

	// @Parameters("browser")
	@BeforeClass /* ( groups = "SmokeGroup" ) */
	public void beforeClass(/* String browser */) {
		Reporter.log("before class method: ");
		Reporter.log("project path: " + System.getProperty("user.dir"));

		projectPath = System.getProperty("user.dir");

		String browser = "edge";

		url = "https://www.linkedin.com/";

		if (browser.equals("chrome")) {
			/* Chrome Browser Case */
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\driver\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			/* Edge Browser */
			System.setProperty("webdriver.edge.driver",
					projectPath + "\\src\\test\\resources\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\src\\test\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@AfterClass(groups = "SmokeGroup")
	public void afterClass() {
		driver.quit();// close all the session windows
		Reporter.log("After class method execution");
	}

	@BeforeMethod(groups = "SmokeGroup")
	public void beforeMethod() {

		driver.get(url);// navigate to linked in sign-in page

		driver.manage().window().maximize();// to maximize the browser
	}

	@AfterMethod(groups = "SmokeGroup")
	public void afterMethod() {
		Reporter.log("After method");
	}

}
