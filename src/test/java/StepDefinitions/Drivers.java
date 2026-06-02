package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

abstract public class Drivers {
	
	public static WebDriver get_chrome_driver() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		return new ChromeDriver();
	}
	
	public WebDriver get_firefox_driver() {
		return null;
	}
	
	public WebDriver get_internet_explorer_driver() {
		return null;
	}
}
