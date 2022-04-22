package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo11LinkedInTitleTest {

	public static void main(String[] args) {

		String url = "https://www.linkedin.com/";

		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-mar-2022-7pm\\sqaguru-automation\\resources\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);// navigate to linked in sign-in page

		String linkedInTitleActual = driver.getTitle();
		String linkedInTitleExpected = "LinkedIn: Log In or Sign Up Page";

		// validation, assertion => Verifying something on test application, which is as
		// per expected or not
		if (linkedInTitleActual.equals(linkedInTitleExpected)) {
			System.out.println("LinkedIn Sign-In Page title validation: PASSED");
			System.out.println("Expected linkedIn title: " + linkedInTitleExpected + "\nActual LinkedIn title: "
					+ linkedInTitleActual);
		} else {
			System.out.println("LinkedIn Sign-In Page title validation: FAILED");
			System.out.println("Expected linkedIn title: " + linkedInTitleExpected + "\nActual LinkedIn title: "
					+ linkedInTitleActual);
		}
	}

}
