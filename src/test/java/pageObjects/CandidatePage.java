package pageObjects;

import java.util.List;

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
	@FindBy(xpath ="//button[normalize-space()='Add']")
	public WebElement addbtn;
	@FindBy(xpath ="//input[@type='file']")
	public WebElement resumeupload;
	@FindBy (xpath ="//div[contains(@class, 'oxd-file-input-div')]")
	public WebElement uploadedfilename;
	@FindBy (xpath ="//span[contains(@class, 'oxd-input-field-error-message')]")
	public WebElement field_errormsg;
	@FindBy (xpath="//input[@name='firstName']")
	public WebElement firstname_textbox;
	@FindBy (xpath="//input[@name='middleName']")
	public WebElement middlename_textbox;
	@FindBy (xpath="//input[@name='lastName']")
	public WebElement lastname_textbox;
	@FindBy (xpath="//div[@class='oxd-select-text-input']")
	public WebElement vacancy_dropdown;
	@FindBy (xpath="//div[@role='listbox']/div/span")
	public WebElement vacancy_list;  //div[@role='listbox']/div/span[contains(text(), '')]
	@FindBy (xpath="//label[contains(text(), 'Email')]/parent::div/following-sibling::div/input")
	public WebElement email_textbox;
	@FindBy (xpath="//label[contains(text(), 'Contact Number')]/parent::div/following-sibling::div/input")
	public WebElement contactnumber_textbox;
	@FindBy (xpath="//label[contains(text(), 'Keywords')]/parent::div/following-sibling::div/input")
	public WebElement keywords_textbox;
	@FindBy (xpath="//label[contains(text(), 'Date')]/parent::div/following-sibling::div/div/div/input")
	public WebElement calendar_textbox;
	@FindBy (xpath="//i[contains(@class, 'calendar')]")
	public WebElement calendar_icon;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-month')]/div/p")
	public WebElement calendar_current_month;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-month')]/div/i")
	public WebElement calendar_month_dropdown;
	@FindBy (xpath="//ul[@role='menu']/li")
	public List<WebElement> calendar_month_list;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-year')]/div/p")
	public WebElement calendar_current_year;
	@FindBy (xpath="//li[contains(@class, 'calendar-selector-year')]/div/i")
	public WebElement calendar_year_dropdown;
	@FindBy (xpath="//ul[@role='menu']/li")
	public List<WebElement> calendar_year_list;
	@FindBy (xpath="//div[contains(@class, 'calendar-dates-grid')]/div/div")
	public List<WebElement> calendar_dates_list;
	@FindBy (xpath="//label[contains(text(), 'Notes')]/parent::div/following-sibling::div/textarea")
	public WebElement notes_textbox;
	@FindBy (xpath="//input[@type=\"checkbox\"]/following-sibling::span/i")
	public WebElement consent_checkbox;
	@FindBy (xpath="//button[@type='submit']")
	public WebElement save_btn;
	@FindBy (xpath="//button[normalize-space()='Cancel']")
	public WebElement cancel_btn;
	
	//*************Filter_elements*******///////////
	//div[@role='listbox']/div //div[@role='listbox']/div/span
	@FindBy(xpath="//label[contains(text(), 'Status')]/parent::div/following-sibling::div/div/div/div/following-sibling::div")
	public WebElement status_dropdown;
	@FindBy(xpath="//div[@role='listbox']/div")
	public List<WebElement> dropdown_elements;
	@FindBy(xpath="//label[contains(text(), 'Candidate Name')]/parent::div/following-sibling::div/div/div/input")
	public WebElement candidate_filter;
	@FindBy (xpath="//button[@type='submit']")
	public WebElement search_btn;
	@FindBy (xpath="//div[@role='listbox']/div/span")
	public WebElement first_search_option;
	@FindBy (xpath="//i[contains(@class, 'eye')]/parent::button")
	public WebElement first_candidate_view;
	@FindBy (xpath="//i[contains(@class, 'trash')]/parent::button")
	public WebElement first_candidate_delete;
	@FindBy (xpath="(//div[@role='row'])[2]/div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/div")
	public WebElement candidate_status_from_table;
	@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
	public WebElement confirmdeleteops;
	
	@FindBy(xpath = "//button[normalize-space()='No, Cancel']")
	public WebElement canceldeleteops;
	@FindBy(xpath ="//div[@role='document']")
	public WebElement confirm_delete_popup;
	@FindBy(xpath ="//div/span[text()[contains(.,'Records Found')]]")
	public WebElement numberoffilterrecords;
	//*************Candidate_view_elements*******///////////
	@FindBy (xpath="//div[contains(@class, 'status')]/p")
	public WebElement candidate_status_from_view;
	@FindBy (xpath="//div/h6[text()='Candidate History']")
	public WebElement candidate_history_section;
	@FindBy (xpath="//div[@class='oxd-table-body']/div")
	public List<WebElement> candidate_history_records;
	//((//div[@class='oxd-table-body']/div)[rowcount]/div/div/div)[1-3]
	@FindBy (xpath="//form/h6")
	public WebElement candidate_details_screen;
	@FindBy (xpath="(//div/p)[3]")
	public WebElement hiringmanger_name;
	@FindBy (xpath="//button[normalize-space()='Reject']")
	public WebElement reject_btn;
	@FindBy (xpath="//button[normalize-space()='Shortlist']")
	public WebElement shortlist_btn;
	@FindBy (xpath="//h6[text()='Reject Candidate']")
	public WebElement reject_screen;
	@FindBy (xpath="//label[normalize-space()='Interview Title']/parent::div/following-sibling::div/input")
	public WebElement interviewtitle_textbox;
	@FindBy (xpath="//label[text()='Time']/parent::div/following-sibling::div/div/div/input")
	public WebElement time_textbox;
	@FindBy(xpath="//input[contains(@class, 'time-hour-input-text')]")
	public WebElement hour_textbox;
	@FindBy(xpath="//input[contains(@class, 'time-minute-input-text')]")
	public WebElement minute_textbox;
	@FindBy(xpath="//input[@name= 'am']")
	public WebElement am_btn;
	@FindBy(xpath="//input[@name= 'pm']")
	public WebElement pm_btn;
	@FindBy(xpath="//i[contains(@class, 'clock')]")
	public WebElement clock_icon;
	@FindBy(xpath="//i[contains(@class, 'minute-input-up')]")
	public WebElement minuteup_btn;
	@FindBy(xpath="//i[contains(@class, 'minute-input-down')]")
	public WebElement minutedown_btn;
	@FindBy(xpath="//i[contains(@class, 'hour-input-up')]")
	public WebElement hourup_btn;
	@FindBy(xpath="//i[contains(@class, 'hour-input-down')]")
	public WebElement hourdown_btn;
	@FindBy(xpath="//button[normalize-space()='Add Another']")
	public WebElement addinterviewer_btn;
	@FindBy(xpath="//div[contains(@class, 'interviewer-input')]/div/div/following-sibling::div/div/div/input")
	public WebElement Interviewer1;
	@FindBy(xpath="//button[normalize-space()='Mark Interview Passed']")
	public WebElement markinterviewpass_btn;
	@FindBy(xpath="//button[normalize-space()='Mark Interview Failed']")
	public WebElement markinterviewfail_btn;
	
	

}
