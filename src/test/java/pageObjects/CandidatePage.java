package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatePage extends BasePage {

	// WebElement names updated to follow Java naming conventions (camelCase)

	public CandidatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//li/a[text() = 'Candidates']")
	public WebElement candidates;
	@FindBy(xpath ="(//div/div[contains(text(),'Select')])[2]")
	public WebElement vacancyDropdown;
	@FindBy(xpath ="//button[normalize-space()='Add']")
	public WebElement addButton;
	@FindBy(xpath ="//input[@type='file']")
	public WebElement resumeUpload;
	@FindBy (xpath ="//div[contains(@class, 'oxd-file-input-div')]")
	public WebElement uploadedFileName;
	@FindBy (xpath ="//span[contains(@class, 'oxd-input-field-error-message')]")
	public WebElement fieldErrorMessage;
	@FindBy (xpath="//input[@name='firstName']")
	public WebElement firstNameTextbox;
	@FindBy (xpath="//input[@name='middleName']")
	public WebElement middleNameTextbox;
	@FindBy (xpath="//input[@name='lastName']")
	public WebElement lastNameTextbox;
	@FindBy (xpath="//div[@class='oxd-select-text-input']")
	public WebElement vacancyInputField;
	@FindBy (xpath="//div[@role='listbox']/div/span")
	public WebElement vacancyList;  //div[@role='listbox']/div/span[contains(text(), '')]
	@FindBy (xpath="//label[contains(text(), 'Email')]/parent::div/following-sibling::div/input")
	public WebElement emailTextbox;
	@FindBy (xpath="//label[contains(text(), 'Contact Number')]/parent::div/following-sibling::div/input")
	public WebElement contactNumberTextbox;
	@FindBy (xpath="//label[contains(text(), 'Keywords')]/parent::div/following-sibling::div/input")
	public WebElement keywordsTextbox;
	@FindBy (xpath="//label[contains(text(), 'Date')]/parent::div/following-sibling::div/div/div/input")
	public WebElement calendarTextbox;
	@FindBy (xpath="//i[contains(@class, 'calendar')]")
	public WebElement calendarIcon;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-month')]/div/p")
	public WebElement calendarCurrentMonth;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-month')]/div/i")
	public WebElement calendarMonthDropdown;
	@FindBy (xpath="//ul[@role='menu']/li")
	public List<WebElement> calendarMonthList;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-year')]/div/p")
	public WebElement calendarCurrentYear;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-year')]/div/i")
	public WebElement calendarYearDropdown;
	@FindBy (xpath="//ul[@role='menu']/li")
	public List<WebElement> calendarYearList;
	@FindBy (xpath="//div[contains(@class, 'calendar-dates-grid')]/div/div")
	public List<WebElement> calendarDatesList;
	@FindBy (xpath="//label[contains(text(), 'Notes')]/parent::div/following-sibling::div/textarea")
	public WebElement notesTextbox;
	@FindBy (xpath="//input[@type=\"checkbox\"]/following-sibling::span/i")
	public WebElement consentCheckbox;
	@FindBy (xpath="//button[@type='submit']")
	public WebElement saveButton;
	@FindBy (xpath="//button[normalize-space()='Cancel']")
	public WebElement cancelButton;
	
	//*************Filter_elements*******///////////
	//div[@role='listbox']/div //div[@role='listbox']/div/span
	@FindBy(xpath="//label[contains(text(), 'Status')]/parent::div/following-sibling::div/div/div/div/following-sibling::div")
	public WebElement statusDropdown;
	@FindBy(xpath="//div[@role='listbox']/div")
	public List<WebElement> dropdownElements;
	@FindBy(xpath="//label[contains(text(), 'Candidate Name')]/parent::div/following-sibling::div/div/div/input")
	public WebElement candidateFilter;
	@FindBy (xpath="//button[@type='submit']")
	public WebElement searchButton;
	@FindBy (xpath="//div[@role='listbox']/div/span")
	public WebElement firstSearchOption;
	@FindBy (xpath="//i[contains(@class, 'eye')]/parent::button")
	public WebElement firstCandidateView;
	@FindBy (xpath="//i[contains(@class, 'trash')]/parent::button")
	public WebElement firstCandidateDelete;
	@FindBy (xpath="(//div[@role='row'])[2]/div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/div")
	public WebElement candidateStatusFromTable;
	@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
	public WebElement confirmDeleteOps;

	@FindBy(xpath = "//button[normalize-space()='No, Cancel']")
	public WebElement cancelDeleteOps;
	@FindBy(xpath ="//div[@role='document']")
	public WebElement confirmDeletePopup;
	@FindBy(xpath ="//div/span[text()[contains(.,'Records Found')]]")
	public WebElement numberOfFilterRecords;
	//*************Candidate_view_elements*******///////////
	@FindBy (xpath ="//span[contains(@class, 'oxd-switch-input oxd-switch')]")
	public WebElement editSwitch;
	@FindBy (xpath="//div[contains(@class, 'status')]/p")
	public WebElement candidateStatusFromView;
	@FindBy (xpath="//div/h6[text()='Candidate History']")
	public WebElement candidateHistorySection;
	@FindBy (xpath="//div[@class='oxd-table-body']/div")
	public List<WebElement> candidateHistoryRecords;
	//((//div[@class='oxd-table-body']/div)[rowcount]/div/div/div)[1-3]
	@FindBy (xpath="//form/h6")
	public WebElement candidateDetailsScreen;
	@FindBy (xpath="(//div/p)[3]")
	public WebElement hiringManagerName;
	@FindBy (xpath="(//div/p)[2]")
	public WebElement vacancyName;
	@FindBy (xpath="//button[normalize-space()='Reject']")
	public WebElement rejectButton;
	@FindBy (xpath="//button[normalize-space()='Shortlist']")
	public WebElement shortlistButton;
	@FindBy (xpath="//h6[text()='Reject Candidate']")
	public WebElement rejectScreen;
	@FindBy (xpath="//label[normalize-space()='Interview Title']/parent::div/following-sibling::div/input")
	public WebElement interviewTitleTextbox;
	@FindBy (xpath="//label[text()='Time']/parent::div/following-sibling::div/div/div/input")
	public WebElement timeTextbox;
	@FindBy(xpath="//input[contains(@class, 'time-hour-input-text')]")
	public WebElement hourTextbox;
	@FindBy(xpath="//input[contains(@class, 'time-minute-input-text')]")
	public WebElement minuteTextbox;
	@FindBy(xpath="//input[@name= 'am']")
	public WebElement amButton;
	@FindBy(xpath="//input[@name= 'pm']")
	public WebElement pmButton;
	@FindBy(xpath="//i[contains(@class, 'clock')]")
	public WebElement clockIcon;
	@FindBy(xpath="//i[contains(@class, 'minute-input-up')]")
	public WebElement minuteUpButton;
	@FindBy(xpath="//i[contains(@class, 'minute-input-down')]")
	public WebElement minuteDownButton;
	@FindBy(xpath="//i[contains(@class, 'hour-input-up')]")
	public WebElement hourUpButton;
	@FindBy(xpath="//i[contains(@class, 'hour-input-down')]")
	public WebElement hourDownButton;
	@FindBy(xpath="//button[normalize-space()='Add Another']")
	public WebElement addInterviewerButton;
	@FindBy(xpath="//div[contains(@class, 'interviewer-input')]/div/div/following-sibling::div/div/div/input")
	public WebElement interviewer1;
	@FindBy(xpath="//button[normalize-space()='Mark Interview Passed']")
	public WebElement markInterviewPassButton;
	@FindBy(xpath="//button[normalize-space()='Mark Interview Failed']")
	public WebElement markInterviewFailButton;
	@FindBy(xpath="//p[text()[contains(.,'Confirmation Required')]]")
	public WebElement editConfirmationPopup;
	@FindBy(xpath="//button[normalize-space()='Yes, Confirm']")
	public WebElement confirmEdit;
	
	

}
