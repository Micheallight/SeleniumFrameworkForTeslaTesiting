package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
	private static WebDriver driver;

	private DriverSingleton() {}

	public static WebDriver getDriver() {
		if (null == driver) {
			if (System.getProperty("browser") == null) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments(
						"--window-size=3840,2160",
						"--headless",
						"--no-sandbox",
						"--disable-dev-shm-usage",
						"--disable-extensions",
						"--proxy-server='direct://'",
						"--proxy-bypass-list=*",
						"--start-maximized",
						"--disable-gpu",
						"--ignore-certificate-errors",
						"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
								"AppleWebKit/537.36 (KHTML, like Gecko) " +
								"Chrome/107.0.0.0 Safari/537.36"
				);
				driver = new ChromeDriver();
			} else {
				switch (System.getProperty("browser")) {
					case "firefox": {
						WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
					}
					default: {
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
					}
				}
			}
			driver.manage().window().setSize(new Dimension(3840,2160));
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}
}