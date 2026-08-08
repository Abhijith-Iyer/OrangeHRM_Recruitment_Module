package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	// WebElement names updated to follow Java naming conventions (camelCase)

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//a/span[text() = 'Recruitment']")
	public WebElement recruitment;
	
	@FindBy(xpath ="//a/span[text() = 'Dashboard']")
	public WebElement dashboard;
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	public WebElement currentUser;
	@FindBy(xpath="//p[text()[contains(.,'Candidate')]]")
	public WebElement candidateInterviewLink;

}
