package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CandidatePage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RecruitementPage;
import pageObjects.VacanciesPage;
import pageObjects.VacancyformPage;

public class AddVacancytest extends Commons {
	
	AddVacancytest Avt;
	LoginPage lp;
	DashboardPage dp;
	RecruitementPage rp;
	CandidatePage cp;
	VacanciesPage vp;
	VacancyformPage vfp;
	String temp;

	@Given("User Logs in with Credentials and Navigates to Recruitment Section")
	public void user_logs_in_with_credentials_and_navigates_to_recruitment_section() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		Commons.getLogger().info("Logging in and Navigating to Recruitment");
		try {
	    lp = new LoginPage(Commons.getDriver());
	    dp = new DashboardPage(Commons.getDriver());
	    Thread.sleep(3000);
	    Commons.waittillvisible(lp.username, 5000);
	    Commons.sendkeys(lp.username, "Admin");
	    Commons.sendkeys(lp.password, "admin123");
	    Commons.clickop(lp.loginbtn);
	    Thread.sleep(3000);
	    //Commons.waitandclick(dp.recruitment, 30);
	    Commons.clickop(dp.recruitment);
	    Thread.sleep(3000);
		}
		catch(Exception e) {
			Commons.getLogger().info("Navigation to recruitment failed...");
			Assert.fail();
		}
	}
	@When("Clicks on Vacancy")
	public void clicks_on_vacancy() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    Commons.getLogger().info("Navigating to Vacancy section");
	    rp = new RecruitementPage(Commons.getDriver());
	    //Commons.waitandclick(rp.vacancies, 30);
	    //Commons.clickop(rp.vacancies);
	    Commons.forceclick(rp.vacancies);
	    Thread.sleep(3000);
	}
	@When("Fills the Job Vacancy form for {string} position with Hiring Manager as {string}")
	public void fills_the_job_vacancy_form(String jobtlt, String HM) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    Commons.getLogger().info("clicking on Add button");
	   try {
	    vp = new VacanciesPage(Commons.getDriver());
	    Commons.clickop(vp.addbtn);
	    Thread.sleep(3000);
	    Commons.getLogger().info("Starting to fill the form...");
	    vfp = new VacancyformPage(Commons.getDriver());
	    //Commons.forcesendkeys(vfp.vacancyname, "Test Automation Genius" );
	    Commons.sendkeys(vfp.vacancyname, "Test Automation Genius");
	    Commons.clickop(vfp.jobtitledrpdwn);
	    Commons.clickop(driver.findElement(By.xpath("//div[@role='listbox']/div/span[contains(text(), '"+jobtlt+"')]")));
	    Commons.sendkeys(vfp.vacancydesc, "Candidate should be automation genius");
	    Commons.sendkeys(vfp.HMinputbox, HM);
	    Thread.sleep(3000);
	    Commons.clickop(driver.findElement(By.xpath("//div[@role='listbox']/div/span[contains(text(), '"+HM+"')]")));
	    Commons.sendkeys(vfp.posnumber, "5");
	   }
	   catch(Exception e) {
		   Commons.getLogger().info("Failed to fill the form");
		   Assert.fail();	   }
	}
	@When("Saves the form")
	public void saves_the_form() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 vfp = new VacancyformPage(Commons.getDriver());
		 Commons.getLogger().info("Saving the form");
		 Commons.clickop(vfp.savebtn);
		 Thread.sleep(3000);
		 
	}
	@When("Navigates back to Vacancies to see the vacancy table")
	public void navigate_to_vacancytable() {
		 Commons.getLogger().info("Navigating back to vacancy list...");
			rp = new RecruitementPage(Commons.getDriver());
		    Commons.forceclick(rp.vacancies);
	}
	
	@Then("The newly added Job Vacancy for {string} position with Hiring Manager as {string} should be visible in the table")
	public void Is_jobvacancy_visible_in_vacancytable(String jobtlt, String HM) throws InterruptedException {
		Commons.getLogger().info("Checking for the added vacancy...");
		vp = new VacanciesPage(Commons.getDriver());
		Commons.scrolltoelement(driver.findElement(By.xpath("//div[contains(text(),'"+jobtlt+"')]/parent::div/following-sibling::div/div[contains(text(),'"+HM+"')]")));
		Thread.sleep(3000);//div[contains(text(),'Junior Account Assistant')]
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'"+jobtlt+"')]/parent::div/following-sibling::div/div[contains(text(),'"+HM+"')]")).isDisplayed());
		
	}
	@Then("Delete the newly added vacancy for {string} position with Hiring Manager as {string} and validate if the deleted vacancy is removed from the vacancy table")
	public void delete_vacancy(String jobtlt, String HM) {
		Commons.getLogger().info("Performing Delete...");
		Commons.scrolltoelement(driver.findElement(By.xpath("//div[contains(text(),'"+jobtlt+"')]")));
		Commons.clickop(driver.findElement(By.xpath("//div[contains(text(),'"+jobtlt+"')]/parent::div/following-sibling::div/div[contains(text(),'"+HM+"')]/parent::div/following-sibling::div/following-sibling::div/div/button/i[contains(@class, 'trash')]")));
		vp = new VacanciesPage(Commons.getDriver());
		Commons.waitandclick(vp.confirmdeleteops, 3000); 
	}
	@When("Capture an existing vacancy from the vacancy table")
	public void capture_vacancyname() throws InterruptedException {
		Commons.getLogger().info("Capturing Vacancy name...");
		//Commons.scrolltoelement(driver.findElement(By.xpath("(//div[@role='row'])[3]")));
		Thread.sleep(3000);
		temp = driver.findElement(By.xpath("((//div[@role='row'])[2]/div/following-sibling::div/div)[1]")).getText();
		
	}
	@When("Navigates to fill Vacancy form and enters the captured vacancy in vacancy name")
	public void navigateto_vacancyform() throws InterruptedException {
		Commons.getLogger().info("Navigating to filling the form...");
		vp = new VacanciesPage(Commons.getDriver());
		//Commons.scrolltoelement(vp.addbtn);
	    Commons.clickop(vp.addbtn);
	    Thread.sleep(3000);
		Commons.getLogger().info("Starting to fill the form...");
	    vfp = new VacancyformPage(Commons.getDriver());
	    //Commons.forcesendkeys(vfp.vacancyname, "Test Automation Genius" );
	    Commons.sendkeys(vfp.vacancyname, temp);
	    Thread.sleep(3000);
	}
	@Then("Already exists error message should be displayed under the text box")
	public void duplicatevacancy_check() {
		if(driver.findElement(By.xpath("//span[contains(@class, 'error-message')]")).getText().equalsIgnoreCase("Already Exists"))
		{
			Commons.getLogger().info("Test success");
			Assert.assertTrue(true);
		}
		else {
			Commons.getLogger().info("No error message displayed...");
			Assert.fail();
		}
	}
	


}
