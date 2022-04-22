package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.Base;

public class GoogleTestWithParameters extends Base {

	@Test(dataProvider = "GoogleSearch")
	public void googleSearchTest(String defaultTitle, String searchBy, String searchResultTitle) {

		String url = "https://www.google.com/";

		driver.get(url);// navigate to linked in sign-in page

		String googleTitle = driver.getTitle();

		Assert.assertEquals(googleTitle, defaultTitle, "Google Title validation");

		driver.findElement(By.name("q")).sendKeys(searchBy);

		driver.findElement(By.name("q")).submit();

		String googleSearchResultTitle = driver.getTitle();

		Assert.assertEquals(googleSearchResultTitle, searchResultTitle, "google search result title validation");
	}

	@DataProvider(name = "GoogleSearch")
	public Object[][] googleSearchDP() {
		return new Object[][] { { "Google", "selenium test", "selenium test - Google Search" },
				{ "Google", "testng test", "testng test - Google Search" },
				{ "Google", "java test", "java test - Google Search" } };
	}

}
