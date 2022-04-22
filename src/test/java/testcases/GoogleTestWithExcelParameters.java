package testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.Base;
import framework.ExcelReader;

public class GoogleTestWithExcelParameters extends Base {

	@Test(dataProvider = "GoogleSearchExcel")
	public void googleSearchTest(HashMap<String, String> testData) {

		String url = "https://www.google.com/";

		driver.get(url);// navigate to linked in sign-in page

		String googleTitle = driver.getTitle();

		Assert.assertEquals(googleTitle, testData.get("GoogleTitle"), "Google Title validation");

		driver.findElement(By.name("q")).sendKeys(testData.get("SearchGoogleByText"));

		driver.findElement(By.name("q")).submit();

		String googleSearchResultTitle = driver.getTitle();

		Assert.assertEquals(googleSearchResultTitle, testData.get("SearchResultTitle"),
				"google search result title validation");

	}

	@DataProvider(name = "GoogleSearch")
	public Object[][] googleSearchDP() {
		return new Object[][] { { "Google", "selenium test", "selenium test - Google Search" },
				{ "Google", "testng test", "testng test - Google Search" },
				{ "Google", "java test", "java test - Google Search" } };
	}

	@DataProvider(name = "GoogleSearchExcel")
	public Object[] googleSearchDPExcel() {
		return ExcelReader.readExcelData();
	}

}
