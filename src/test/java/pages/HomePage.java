package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import framework.Base;
import framework.SeleniumUtils;

public class HomePage extends BasePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	By btnSignIn = By.xpath("/html/body/nav/div/a[2]");

	By txtSignIn = By.id("12");

	By lstSignIn = By.id("12");

	By lblSignIn = By.id("12");

	SoftAssert softAssert = new SoftAssert();

	String expectedTitle = "LinkedIn: Log In or Sign Up1";

	public void linkedInSignIn() throws IOException {

		softAssert.assertEquals(getPageTitle(), expectedTitle, "Verify application default title ");

		SeleniumUtils.captureSnapshot(driver, "launchPage");

		// click on sign-in button

		isSignInButtonDisplayed();

		typeUserName();

		typePassword();

		clickSignInButton();
	}

	private void typePassword() {
		System.out.println("type password");
	}

	private void typeUserName() {
		System.out.println("type user name");
	}

	private void clickSignInButton() throws IOException {
		WebElement signInButton1 = driver.findElement(btnSignIn);

		File srcFile = signInButton1.getScreenshotAs(OutputType.FILE);

		Files.copy(srcFile, new File(Base.projectPath + "\\src\\test\\resources\\screenshots\\signInButton.png"));

		signInButton1.click();
	}

	private void isSignInButtonDisplayed() {
		WebElement signInButton1 = driver.findElement(btnSignIn);

		signInButton1.isDisplayed();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
