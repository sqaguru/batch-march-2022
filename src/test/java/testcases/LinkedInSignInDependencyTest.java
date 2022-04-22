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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import framework.Base;

public class LinkedInSignInDependencyTest extends Base{
	@Test(description = "Linked in Login test case for valid credentials",priority=1)
	public void linkedInLoginWithValidCredentials() throws IOException {

		captureSnapshot(driver, "launchPage");

		// click on sign-in button
		WebElement signInButton1 = driver.findElement(By.xpath("/html/body/nav/div/a[2]"));

		signInButton1.isDisplayed();

		File srcFile = signInButton1.getScreenshotAs(OutputType.FILE);

		Files.copy(srcFile, new File(projectPath + "\\resources\\screenshots\\signInButton.png"));

		signInButton1.click();

		captureSnapshot(driver, "SignInPage");
		// enter user name
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("guru@sqaguru.co.in");
		// enter password
		// driver.findElement(By.name("session_password")).sendKeys("Password@123");
		// click on sign-in button

		captureSnapshot(driver, "SignInDetailsPage");

		int totalLinks = driver.findElements(By.tagName("a")).size();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			Reporter.log("linkText: " + link.getText());
		}

		Reporter.log("totalLinks: " + totalLinks);

		int totalInputElements = driver.findElements(By.tagName("input")).size();

		Reporter.log("totalInputElements: " + totalInputElements);

		driver.findElement(By.partialLinkText("Join")).click();

		// verify user has sign=
		// driver.findElement(By.id("organic-otp-link-in-error-message")).isDisplayed();

		// close the browser

	}

	@Test(groups= {"SmokeGroup"},description = "Linked in Login test case for valid user name and invalid password",priority=2)
	public void linkedInLoginWithValidUserInvalidPassword() throws IOException {

		Reporter.log("executing test case linkedInLoginWithValidUserInvalidPassword ",true);
		
		captureSnapshot(driver, "launchPage");

		// click on sign-in button
		WebElement signInButton1 = driver.findElement(By.xpath("/html/body/nav/div/a[2]"));

		signInButton1.isDisplayed();

		File srcFile = signInButton1.getScreenshotAs(OutputType.FILE);

		Files.copy(srcFile, new File(projectPath + "\\resources\\screenshots\\signInButton.png"));

		signInButton1.click();

		captureSnapshot(driver, "SignInPage");
		// enter user name
		WebElement userName = driver.findElement(By.id("username1"));
		userName.sendKeys("guru@sqaguru.co.in");
		// enter password
		// driver.findElement(By.name("session_password")).sendKeys("Password@123");
		// click on sign-in button

		captureSnapshot(driver, "SignInDetailsPage");

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

	@Test(dependsOnMethods= {"linkedInLoginWithValidUserInvalidPassword"},description = "test case with no user details",priority=3)
	public void linkedInLoginWithNoUserDetails() {
		Reporter.log("running method linkedInLoginWith",true);
	}


	@Test(dependsOnMethods= {"linkedInLoginWithValidUserInvalidPassword"},description = "test case with no user details",priority=3,alwaysRun=true)
	public void linkedInLoginWithNoUserDetails4() {
		Reporter.log("running method method 4",true);
	}
	
	public static void captureSnapshot(WebDriver driver, String fileName) throws IOException {
		File signInpage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(signInpage, new File(projectPath + "\\resources\\screenshots\\" + fileName + ".png"));

	}
}
