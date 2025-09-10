package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitementPage extends BasePage {

	public RecruitementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//li/a[text() = 'Candidates']")
	public WebElement candidates;
	
	@FindBy(xpath ="//li/a[text() = 'Vacancies']")
	public WebElement vacancies;

}
