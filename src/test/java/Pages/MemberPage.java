package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MemberPage {
	WebDriver driver;
	
	By btn_invite_workspace_members = By.xpath("//button[text()='Invite Workspace members']");
	By txt_email = By.cssSelector("input[data-testid='add-members-input']");
	By btn_send_invite = By.xpath("//button[text()='Send invite']");

	
	public MemberPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickInviteWorkspaceMembers() {
		driver.findElement(btn_invite_workspace_members).click();
	}
	
	public void enterEmailToBeInvited(String email) {
		driver.findElement(txt_email).sendKeys(email);
	}
	
	public void clickEnterToEmailToBeInvited() {
		driver.findElement(txt_email).sendKeys(Keys.ENTER);
	}
	
	public void clickSendInvite() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement sendInviteButton = wait.until(ExpectedConditions.elementToBeClickable(btn_send_invite));
        sendInviteButton.click();
	}
}
