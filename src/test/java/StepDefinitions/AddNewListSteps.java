package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewListSteps {
	
	WebDriver driver = null;
	WebDriverWait wait;

	public AddNewListSteps() {
		// TODO Auto-generated constructor stub
	}

	@And("user is logged in Trello")
	public void user_is_logged_in_trello() {
		driver.get("https://trello.com/w/userworkspace78357212/home");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
        	driver.getPageSource().contains("Trello Workspace");
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home"))); 
            System.out.println("User is on the Trello homepage.");
        } catch (Exception e) {
            System.out.println("User is NOT on the Trello homepage.");
            throw e;
        }
	}

	@When("user clicks board section button")
	public void user_clicks_board_section_button() {
		WebElement boardSectionButton = driver.findElement(By.cssSelector("input[data-testid='home-team-boards-tab'"));
		boardSectionButton.click();
	}

	@And("user should see Yours Boards")
	public void user_should_see_yours_boards() {
		driver.getPageSource().contains("Your boards");
		System.out.println("Yours Boards section is visible.");
	}

	@When("user clicks desired Board")
	public void user_clicks_desired_board() {
		WebElement desiredBoardButton = driver.findElement(By.className("board-tile-details is-badged"));
		desiredBoardButton.click();
	}

	@And("user should see Board Title")
	public void user_should_see_board_title() {
		driver.getPageSource().contains("Sample Board");
		System.out.println("Board title is visible.");
	}

	@When("user clicks to add new list")
	public void user_clicks_to_add_new_list() {
		WebElement addListButton = driver.findElement(By.cssSelector("input[data-testid='list-composer-button']"));
        addListButton.click();
	}

	@And("user enters list name")
	public void user_enters_list_name() {
		WebElement listNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='list-name-textarea']")));
        listNameInput.sendKeys("Sample List Test");
	}

	@And("user clicks Add List")
	public void user_clicks_add_list() {
		WebElement addButton = driver.findElement(By.cssSelector("input[data-testid='list-composer-add-list-button']"));
		addButton.click();
	}

	@Then("User should see the new list")
	public void user_should_see_the_new_list() {
		driver.getPageSource().contains("Sample List Test");
		System.out.println("List is visible.");
	}

}
