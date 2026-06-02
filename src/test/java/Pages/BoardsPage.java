package Pages;

import org.openqa.selenium.WebDriver;

public class BoardsPage {
	WebDriver driver = null;

	public BoardsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void contains(String content)
	{
		driver.getPageSource().contains(content);
	}

}
