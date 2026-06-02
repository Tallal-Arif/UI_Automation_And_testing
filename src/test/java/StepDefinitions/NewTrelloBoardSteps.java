package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.BoardsPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewTrelloBoardSteps {

	WebDriver driver = null;
	WebDriverWait wait;
	String boardTitle = null;

	public NewTrelloBoardSteps() {
		// TODO Auto-generated constructor stub
	}

	@Given("^user is log in using (.*) and (.*)$")
	public void user_is_logged_in_trello(String username, String password) {
//		driver.get("https://trello.com/w/userworkspace78357212/home");
//
//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		try {
//			driver.getPageSource().contains("Trello Workspace");
////            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home"))); 
//			System.out.println("User is on the Trello homepage.");
//		} catch (Exception e) {
//			System.out.println("User is NOT on the Trello homepage.");
//			throw e;
//		}
		System.out.println("Inside Step : user is logged in");
		driver = Drivers.get_chrome_driver();
		driver.navigate().to("https://trello.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	    LoginPage lp = new LoginPage(driver);
	    lp.loginValidUser(username, password);
	}

	@When("user clicks create button")
	public void user_clicks_create_button() {
		HomePage hp = new HomePage(driver);
		hp.clickCreateBoard();
	}

	@And("^user enters Board Title (.*)$")
	public void user_enters_board_title(String boardTitle) {
		this.boardTitle = boardTitle;
		HomePage hp = new HomePage(driver);
		hp.enterBoardTitle(boardTitle);
	}

	@And("user clicks create")
	public void user_clicks_create() {
		HomePage hp = new HomePage(driver);
		hp.clickCreateNewBoard();
	}

	@Then("User should see the new board")
	public void user_should_see_the_new_board() {
		BoardsPage bp = new BoardsPage(driver);
		bp.contains(boardTitle);
	}

}
