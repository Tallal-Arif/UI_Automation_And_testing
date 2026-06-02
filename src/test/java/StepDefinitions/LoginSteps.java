package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		
		driver = Drivers.get_chrome_driver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//    driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://trello.com/login");
	}
	
	@When("hits enter")
	public void hits_enter() {
	    System.out.println("Inside Step - hits enter");
	    LoginPage lp = new LoginPage(driver);
	    lp.clickLogin();
	}

	@When("^user enters username (.*)$")
	public void user_enters_username(String username) {
	    System.out.println("Inside Step - user enters username");
	    LoginPage lp = new LoginPage(driver);
	    lp.enterUsername(username);
	}
	
	@And("^user enters password (.*)$")
	public void user_enters_password(String password) {
	    System.out.println("Inside Step - user enters password");
	    LoginPage lp = new LoginPage(driver);
	    lp.enterPassword(password);
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    LoginPage lp = new LoginPage(driver);
	    lp.checkUserOnLogin();
	    System.out.println("Inside Step - user is navigated to the home page");
	}
}
