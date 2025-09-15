package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatePage extends BasePage {

	public CandidatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//li/a[text() = 'Candidates']")
	public WebElement candidates;
	@FindBy(xpath ="(//div/div[contains(text(),'Select')])[2]")
	public WebElement vacancydrpdwn;

}
