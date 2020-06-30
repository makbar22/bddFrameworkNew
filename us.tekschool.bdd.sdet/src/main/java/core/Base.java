package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
public class Base {

	public static WebDriver driver;

	public static Properties properties;

	private String userDirectory = System.getProperty("user.dir"); // will provide us this part of file:
																	// C:\\Users\murta\\eclipse-workspace\\us.tekschool.bdd.sdet

	private String ppfile = "\\src\\test\\resources\\InputData\\projectProperty.properties"; // remaining of
																								// projectProperty.properties

	private String pathToPP = userDirectory + ppfile; // concatenate to get the full path

	public static Logger logger;
	
	public Base() {
		// we write buffer reader
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(pathToPP));

			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		
			logger = logger.getLogger("Logger_File");
			PropertyConfigurator.configure(".\\src\\test\\resources\\InputData\\log4j.properties");
			
		
	}

	public static String getBrowserName() { // this is a method to get
		String browserName = properties.getProperty("browser");
		return browserName;

	}

	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	public static long getImpwait() {
		String impWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(impWait);

	}

	public static long getPLTimeout() {
		String pLTimeout = properties.getProperty("pageLoadTimeOut");
		return Long.parseLong(pLTimeout);

	}

	public static void initializeDriver() {
		driver.get(getURL());

	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
