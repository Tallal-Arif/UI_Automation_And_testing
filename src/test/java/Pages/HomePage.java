package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	
	By btn_add_member = By.cssSelector("[data-testid='home-team-members-tab']");
	By btn_create_board = By.cssSelector("li[data-testid='create-board-tile']");
	By txt_board_title = By.cssSelector("input[data-testid='create-board-title-input']");
	By btn_create_new_board = By.cssSelector("button[data-testid='create-board-submit-button']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddmembers() {
		driver.findElement(btn_add_member).click();
	}
	
	public void clickCreateBoard() {
		driver.findElement(btn_create_board).click();
	}
	
	public void enterBoardTitle(String boardTitle) {
		driver.findElement(txt_board_title).sendKeys(boardTitle);;
	}
	
	public void clickCreateNewBoard() {
		driver.findElement(btn_create_new_board).click();
	}
}
