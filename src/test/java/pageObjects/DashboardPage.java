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
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	public WebElement current_user;
	@FindBy(xpath="//p[text()[contains(.,'Candidate')]]")
	public WebElement candidate_interview_link;

}
