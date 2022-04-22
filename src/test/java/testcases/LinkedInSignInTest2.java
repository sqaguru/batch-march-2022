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
import pages.HomePage;
import pages.SignInPage;

public class LinkedInSignInTest2 extends Base {
	@Test()
	public void linkedInLoginWithValidCredentials() throws IOException {
		SignInPage signInPage = new SignInPage(driver);

		signInPage.linkedInSignIn();

	}

}
