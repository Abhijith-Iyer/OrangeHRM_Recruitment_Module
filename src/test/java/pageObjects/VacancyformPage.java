package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VacancyformPage extends BasePage {

	public VacancyformPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	public WebElement vacancyname;
	//@FindBy(xpath ="//div/input[contains(@class, 'oxd-input oxd-input--focus')]")
	
	@FindBy(xpath ="//div[@class='oxd-select-text-input']")
	public WebElement jobtitledrpdwn;
	
	@FindBy(xpath ="//div[@role='listbox']")
	public List <WebElement> jobtitles;
	//div[@role='listbox']/div/span[contains(text(), 'QA Lead')]  //instead of QA Lead, get the input from feature file and use this xpath in step definition to select the value
	
	@FindBy(xpath ="//div/textarea[contains(@class, 'textarea')]")
	public WebElement vacancydesc;
	
	@FindBy(xpath ="//input[@placeholder='Type for hints...']")
	public WebElement HMinputbox;
	
	@FindBy(xpath ="//div[@role='listbox']")
	public List <WebElement> HMlist;
	
	//div[@role='listbox']/div/span[contains(text(), 'Mac')]     //instead of Mac, get the input from feature file and use this xpath in step definition to select the value
	
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	public WebElement posnumber;
	
	@FindBy(xpath ="(//label/span[contains(@class,'active')])[1]")
	public WebElement switchtoactivate;
	
	@FindBy(xpath ="(//label/span[contains(@class,'active')])[2]")
	public WebElement switchtopublish;
	
	@FindBy(xpath ="//button[normalize-space()='Cancel']")
	public WebElement cancelbtn;
	
	@FindBy(xpath ="//button[normalize-space()='Save']")
	public WebElement savebtn;
	
	
	
}
