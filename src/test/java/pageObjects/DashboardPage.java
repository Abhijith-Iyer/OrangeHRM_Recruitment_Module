package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//a/span[text() = 'Recruitment']")
	public WebElement recruitment;
	
	@FindBy(xpath ="//a/span[text() = 'Dashboard']")
	public WebElement dashboard;

}
