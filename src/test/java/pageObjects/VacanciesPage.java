package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacanciesPage extends BasePage {

	// WebElement names updated to follow Java naming conventions (camelCase)

	public VacanciesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	        @FindBy(xpath ="//li/a[text() = 'Vacancies']")
	        public WebElement vacancies;

			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[1]")
			public WebElement jobTitleDropdown;
			
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[2]")
			public WebElement vacancyDropdown;
			//div[@role='listbox']/div[@role='option']/span[contains(text(), 'Junior')]
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[3]")
			public WebElement hiringManagerDropdown;
			
			@FindBy(xpath ="(//div/div[contains(text(),'Select')])[4]")
			public WebElement statusDropdown;
			
			@FindBy(xpath ="//div[@role='listbox']")
			public List <WebElement> jobTitles;
			
			@FindBy(xpath = "//div[contains(@class, 'oxd-form-actions')]/button[@type='button']")
			public WebElement resetButton;
			
			@FindBy(xpath = "//div[contains(@class, 'oxd-form-actions')]/button[@type='submit']")
			public WebElement searchButton;
			
			@FindBy(xpath = "//div[contains(@class, 'header')]/button[@type='button']")
			public WebElement addButton;
			
			@FindBy(xpath = "//div/span[contains(normalize-space(),'Records Found')]")
			public WebElement recordCount;
			
			@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
			public WebElement confirmDeleteOps;
			
			@FindBy(xpath = "//button[normalize-space()='No, Cancel']")
			public WebElement cancelDeleteOps;
			
			
			
			//div/span[contains(text(), 'QA Lead')]
			

}
