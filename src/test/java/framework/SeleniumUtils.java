package framework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class SeleniumUtils {

	public static void captureSnapshot(WebDriver driver, String fileName) throws IOException {
		File signInpage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(signInpage, new File(Base.projectPath + "\\src\\test\\resources\\screenshots\\" + fileName + ".png"));

	}
}
