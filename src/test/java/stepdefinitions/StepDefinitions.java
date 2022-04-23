package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	public static String projectPath;
	protected WebDriver driver;
	String url;

	@Before /* ( groups = "SmokeGroup" ) */
	public void beforeClass(/* String browser */) {
		Reporter.log("before class method: ");
		Reporter.log("project path: " + System.getProperty("user.dir"));

		String projectPath = System.getProperty("user.dir");

		String browser = "edge";

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

	@Given("User should be on linked in page")
	public void user_should_be_on_linked_in_page() {
		url = "https://www.linkedin.com/";
		driver.get(url);
	}

	@When("User enter user name")
	public void user_enter_user_name() {
		// Write code here that turns the phrase above into concrete actions
		WebElement weUserName = driver.findElement(By.id("session_key"));
		weUserName.sendKeys("guru@sqaguru.co.in");
	}

	@When("User enter password")
	public void user_enter_password() {
		driver.findElement(By.name("session_password")).sendKeys("Password@123");
		// click on sign-in button
	}

	@When("User click on signin button")
	public void user_click_on_signin_button() {
		System.out.println("click on sign-in button");
	}

	@Then("Should display home page")
	public void should_display_home_page() {
		System.out.println("verify home page");
	}

	@Then("verify search edit box")
	public void verify_search_edit_box() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("verify people search box");
	}
}
