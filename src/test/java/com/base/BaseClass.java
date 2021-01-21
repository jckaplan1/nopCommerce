package com.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();

	// Integrating data from ReadConfig
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass()
	public void setup() {
		// Initialization // Logger initiated within the setup method
		logger = Logger.getLogger("Jombone");// Project Name
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chrome\\chromedriver.exe");// "C:\\Program
		// Files\\eclipse\\chrome\\chromedriver.exe"
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();

	}

//	@AfterClass()
//	public void tearDown() {
//		driver.quit();
//	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty(("user.dir") + "/Screenshots/" + tname + ".png"));
		FileUtils.copyFile(src, trg);
	}

	public static String randomSring() {
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return generateString1;
	}

	public static String randomNum() {
		String generateString2 = RandomStringUtils.randomNumeric(5);
		return generateString2;
	}

}
