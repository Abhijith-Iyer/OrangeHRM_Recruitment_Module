package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacanciesPage extends BasePage {

	public VacanciesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[1]")
			public WebElement jobtitledrpdwn;
			
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[2]")
			public WebElement vacancydrpdwn;
			
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[3]")
			public WebElement hmdwn;
			
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[4]")
			public WebElement statusdrpdwn;
			
			@FindBy(xpath ="//div[@role='listbox']")
			public List <WebElement> jobtitles;
			
			@FindBy(xpath = "//div[contains(@class, 'oxd-form-actions')]/button[@type='button']")
			public WebElement resetbtn;
			
			@FindBy(xpath = "//div[contains(@class, 'oxd-form-actions')]/button[@type='submit']")
			public WebElement searchbtn;
			
			@FindBy(xpath = "//div[contains(@class, 'header')]/button[@type='button']")
			public WebElement addbtn;
			
			@FindBy(xpath = "//div/span[contains(normalize-space(),'Records Found')]")
			public WebElement Recordcount;
			
			@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
			public WebElement confirmdeleteops;
			
			@FindBy(xpath = "//button[normalize-space()='No, Cancel']")
			public WebElement canceldeleteops;
			
			
			
			//div/span[contains(text(), 'QA Lead')]
			

}
