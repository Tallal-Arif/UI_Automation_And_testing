package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	By txt_username = By.name("username");
	By txt_password = By.name("password");
	By txt_home = By.name("password");
	By btn_login = By.id("login-submit");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void checkUserOnLogin() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://trello.com/"), "User is not on the home page.");
		
	}
	
	public void loginValidUser(String username, String password) {
		enterUsername(username);
		clickLogin();
		enterPassword(password);
		clickLogin();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
