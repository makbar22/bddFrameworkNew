package basics.selenium06042020;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {

	public static void main(String[] args) {

	}

	// Create a static method outside main method that doesn't return any value
	/**
	 * 
	 * @param driver
	 * @param location
	 * @param fileName
	 */
	public static void screenShot(WebDriver driver, String location, String fileName) {

		// Take Screenshot
		// Store Screenshot in a folder or location

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // takes screenshot

		try {
			FileUtils.copyFile(file, new File(location + fileName + ".png"));	//executes the code
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in execution");
		}

	}
}
