package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MemberPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InviteMemberSteps {
	
	WebDriver driver = null;

//	By btn_add_member = By.className("oTmCsFlPhDLGz2 undefined RPa_ezCLkUNX1W RdqZOPHqhCnasP QHWKJUQWR9USLJ");
//	By btn_add_member = By.cssSelector(".DD3DlImSMT6fgc.XQSLFE3ZZrvms3");
	By btn_add_member = By.cssSelector("[data-testid='home-team-members-tab']");
	
	@Given("^user is logged in using (.*) and (.*)$")
	public void user_is_logged_in(String username, String password) {
		System.out.println("Inside Step : user is logged in");
		driver = Drivers.get_chrome_driver();
		driver.navigate().to("https://trello.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	    LoginPage lp = new LoginPage(driver);
	    lp.loginValidUser(username, password);
	}

	@And("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("Inside Step : user is on home page");
	    LoginPage lp = new LoginPage(driver);
	    lp.checkUserOnLogin();
	}

	@And("user click add member")
	public void user_click_add_member() {
		System.out.println("Inside Step : user click add member");
		HomePage hp = new HomePage(driver);
		hp.clickAddmembers();
	}

	@When("user click Invite Workspace members")
	public void user_click_invite_workspace_members() {
		System.out.println("Inside Step : user click Invite Workspace members");
		MemberPage mp = new MemberPage(driver);
		mp.clickInviteWorkspaceMembers();
	}

	@And("^user enters new member email or name (.*)$")
	public void user_enters_new_member_email_or_name(String email) {
		MemberPage mp = new MemberPage(driver);
		mp.enterEmailToBeInvited(email);
	}

	@And("hits enter on invite member to workspace text box")
	public void hits_enter_on_invite_member_to_workspace_text_box() {
		MemberPage mp = new MemberPage(driver);
		mp.clickEnterToEmailToBeInvited();
	}
	
	@Then("new member is invited")
	public void new_member_is_invited() {
		MemberPage mp = new MemberPage(driver);
		mp.clickSendInvite();
	}
}
