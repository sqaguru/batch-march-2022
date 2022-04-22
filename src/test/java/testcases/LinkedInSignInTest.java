package testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import framework.Base;
import framework.SeleniumUtils;

public class LinkedInSignInTest extends Base {
	@Test(groups = { "SmokeGroup" }, description = "Linked in Login test case for valid credentials", priority = 1)
	public void linkedInLoginWithValidCredentials() throws IOException {

		SeleniumUtils.captureSnapshot(driver, "SignInPage");
		// enter user name
		WebElement weUserName = driver.findElement(By.id("username"));
		weUserName.sendKeys("guru@sqaguru.co.in");
		// enter password
		// driver.findElement(By.name("session_password")).sendKeys("Password@123");
		// click on sign-in button

		SeleniumUtils.captureSnapshot(driver, "SignInDetailsPage");

		int totalLinks = driver.findElements(By.tagName("a")).size();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			Reporter.log("linkText: " + link.getText());
		}

		Reporter.log("totalLinks: " + totalLinks);

		int totalInputElements = driver.findElements(By.tagName("input")).size();

		Assert.assertTrue(totalInputElements >= 1, "Verify total number of input tag elements are 1 or great");

		Reporter.log("totalInputElements: " + totalInputElements);

		driver.findElement(By.partialLinkText("Join")).click();

		// verify user has sign=
		// driver.findElement(By.id("organic-otp-link-in-error-message")).isDisplayed();

		// close the browser

	}

	@Test(description = "Linked in Login test case for valid user name and invalid password", priority = 2, enabled = false)
	public void linkedInLoginWithValidUserInvalidPassword() throws IOException {

		Reporter.log("executing test case linkedInLoginWithValidUserInvalidPassword ", true);

		SeleniumUtils.captureSnapshot(driver, "launchPage");

		// click on sign-in button
		WebElement signInButton1 = driver.findElement(By.xpath("/html/body/nav/div/a[2]"));

		signInButton1.isDisplayed();

		File srcFile = signInButton1.getScreenshotAs(OutputType.FILE);

		Files.copy(srcFile, new File(projectPath + "\\resources\\screenshots\\signInButton.png"));

		signInButton1.click();

		SeleniumUtils.captureSnapshot(driver, "SignInPage");
		// enter user name
		WebElement userName = driver.findElement(By.id("username1"));
		userName.sendKeys("guru@sqaguru.co.in");
		// enter password
		// driver.findElement(By.name("session_password")).sendKeys("Password@123");
		// click on sign-in button

		SeleniumUtils.captureSnapshot(driver, "SignInDetailsPage");

		int totalLinks = driver.findElements(By.tagName("a")).size();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			Reporter.log("linkText: " + link.getText());
		}

		Reporter.log("totalLinks: " + totalLinks);

		int totalInputElements = driver.findElements(By.tagName("input")).size();

		Reporter.log("totalInputElements: " + totalInputElements, true);

		driver.findElement(By.partialLinkText("Join")).click();

	}

	@Test(description = "test case with no user details", priority = 3, enabled = false)
	public void linkedInLoginWithNoUserDetails() {
		Reporter.log("running method linkedInLoginWith", true);
	}

}
