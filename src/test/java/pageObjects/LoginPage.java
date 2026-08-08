package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	// WebElement names updated to follow Java naming conventions (camelCase)

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//input[@name ='username']")
	public
	WebElement username;
	
	@FindBy(xpath ="//input[@name ='password']")
	public WebElement password;
	
	@FindBy(xpath ="//button[@type ='submit']")
	public WebElement loginButton;
}
