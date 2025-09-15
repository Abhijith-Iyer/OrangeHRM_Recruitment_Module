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
import pageObjects.VacanciesPage;
import pageObjects.VacancyformPage;

public class AddVacancytest extends Commons {
	
	AddVacancytest Avt;
	LoginPage lp;
	DashboardPage dp;
	CandidatePage cp;
	VacanciesPage vp;
	VacancyformPage vfp;
	String temp;
	String vacancyname = "Test Automation Genius";


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
	    vp = new VacanciesPage(Commons.getDriver());
	    //Commons.waitandclick(rp.vacancies, 30);
	    //Commons.clickop(rp.vacancies);
	    Commons.forceclick(vp.vacancies);
	    Thread.sleep(3000);
	}
	@When("Navigate to Vacancy form")
	public void navigateto_vacancyform() throws InterruptedException {
		Commons.getLogger().info("Navigating to Vacancy form");
	    vp = new VacanciesPage(Commons.getDriver());
	    Commons.forceclick(vp.addbtn);
	    Thread.sleep(3000);
	}
	@When("Fills the Job Vacancy form for {string} position with Hiring Manager as {string}")
	public void fills_the_job_vacancy_form(String jobtlt, String HM) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   try {
	    Commons.getLogger().info("Starting to fill the form...");
	    vfp = new VacancyformPage(Commons.getDriver());
	    //Commons.forcesendkeys(vfp.vacancyname, "Test Automation Genius" );
	    Commons.sendkeys(vfp.vacancyname, vacancyname);
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
	public void navigate_to_vacancytable() throws InterruptedException {
		 Commons.getLogger().info("Navigating back to vacancy list...");
			vp = new VacanciesPage(Commons.getDriver());
		    Commons.forceclick(vp.vacancies);
		    Thread.sleep(3000);
	}
	
	@Then("The newly added Job Vacancy for {string} position with Hiring Manager as {string} should be visible in the table")
	public void Is_jobvacancy_visible_in_vacancytable(String jobtlt, String HM) throws InterruptedException {
		Commons.getLogger().info("Checking for the added vacancy...");
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
	public void enterduplicatevacancyinvacancyform() throws InterruptedException {
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
	@When("Search for the vacancy by vacancy name")
	public void search_vacancy() throws InterruptedException {
		Commons.getLogger().info("Search for vacancy started...");
		vp = new VacanciesPage(Commons.getDriver());
		Commons.clickop(vp.vacancydrpdwn);
		Commons.clickop(driver.findElement(By.xpath("//div[@role='listbox']/div[@role='option']/span[contains(text(), '"+vacancyname+"')]")));
		Thread.sleep(3000);
		Commons.clickop(vp.searchbtn);
		Thread.sleep(3000);
	}
	@When("Click on Edit Icon for {string} position with Hiring Manager as {string}")
	public void edit_vacancy(String jobtlt,String HM) throws InterruptedException {
		Commons.getLogger().info("Performing Delete...");
		Commons.scrolltoelement(driver.findElement(By.xpath("//div[contains(text(),'"+jobtlt+"')]")));
		Commons.clickop(driver.findElement(By.xpath("//div[contains(text(),'"+jobtlt+"')]/parent::div/following-sibling::div/div[contains(text(),'"+HM+"')]/parent::div/following-sibling::div/following-sibling::div/div/button/i[contains(@class, 'pencil')]")));
	}
	@When("Update the Job title field to {string}")
	public void update_vacancy_form(String jobtlt) throws InterruptedException {
		Commons.getLogger().info("Updating Job Title...");
		vfp = new VacancyformPage(Commons.getDriver());
		Thread.sleep(3000);
		Commons.clickop(vfp.jobtitledrpdwn);
		Commons.clickop(driver.findElement(By.xpath("//div[@role='listbox']/div/span[contains(text(), '"+jobtlt+"')]")));
	}
	@When("Navigate to Candidates section")
	public void navigateto_Candidates_section() throws InterruptedException {
		Commons.getLogger().info("Navigating to Candidates section");
	    cp = new CandidatePage(Commons.getDriver());
	    Commons.forceclick(cp.candidates);
	    Thread.sleep(3000);
	}
	@Then("Validate if the Job title is updated for the Vacancy to {string}")
	public void confirm_vacancy_update(String jobtlt) {
		
		String actual_jobtlt=driver.findElement(By.xpath("//div[@role='cell']/div[contains(text(), '"+vacancyname+"')]/parent::div/following-sibling::div/div")).getText();
		if(actual_jobtlt.equalsIgnoreCase(jobtlt)){
			Commons.getLogger().info("Successfully Updated...");
			Assert.assertTrue(true);
		}
		else{
			Commons.getLogger().info("Update operation failed...");
			Assert.assertTrue(false);
		}
	}
	@Then("Check if the newly added vacancy is filtered and displayed in the vacancy table")
	public void search_confirmation() {
		if(driver.findElement(By.xpath("//div[@role='cell']//div[contains(text(),'"+vacancyname+"')]")).isDisplayed()) {
			Commons.getLogger().info("Search Successfull...");
			Assert.assertTrue(true);
		}
		else {
			Commons.getLogger().info("Search Unsuccessfull...");
			Assert.fail();
		}
	}
	@Then("Validate if Mandatory field error is displayed under all Mandatory fields")
	public void Mandatoryerrorcheck_allfields() {
		String Errormsg = "Required";
		Commons.getLogger().info("Starting to check error messages");
		for(int i=1;i<=3;i++) {
			if(Errormsg.equalsIgnoreCase(driver.findElement(By.xpath("(//label[contains(@class, 'field-required')])["+i+"]/parent::div/following-sibling::span")).getText())) {
				
				Commons.getLogger().info("Error Message displayed for Field" + i +"...");
			}
			else {
				Commons.getLogger().info("Error message is not displayed or appropriate");
				Assert.fail();
			}
		}
	}
	@Then("Clears each of the Mandatory fields to check if Mandatory error is thrown again for the respective field")
	public void Mandatoryerrorcheck_afterclear() throws InterruptedException {
		String Errormsg = "Required";
		vfp = new VacancyformPage(Commons.getDriver());
		Commons.getLogger().info("Starting to check error messages");
		for(int i=1;i<=3;i++) {
			switch (i) {
			case 1:
				Commons.clearWebField(vfp.vacancyname);
				//Commons.clickop(vfp.savebtn);
				//Thread.sleep(5000);
				if(Errormsg.equalsIgnoreCase(driver.findElement(By.xpath("(//label[contains(@class, 'field-required')])["+i+"]/parent::div/following-sibling::span")).getText())) {
					Commons.getLogger().info("Error Message displayed for Field" + i +"...");
					vfp.vacancyname.sendKeys(vacancyname);
				}
				else {
					Commons.getLogger().info("Error message is not displayed or appropriate");
					Assert.fail();
				}
				break;
			case 2:
				//vfp.jobtitledrpdwn.clear();
				Commons.clickop(vfp.jobtitledrpdwn);
			    Commons.clickop(driver.findElement(By.xpath("(//div[@role='listbox']/div)[1]")));
			    //Commons.clickop(vfp.savebtn);
				//Thread.sleep(2000);
				if(Errormsg.equalsIgnoreCase(driver.findElement(By.xpath("(//label[contains(@class, 'field-required')])["+i+"]/parent::div/following-sibling::span")).getText())) {
					Commons.getLogger().info("Error Message displayed for Field" + i +"...");
					Commons.clickop(vfp.jobtitledrpdwn);
				    Commons.clickop(driver.findElement(By.xpath("//div[@role='listbox']/div/span[contains(text(), 'QA Lead')]")));
				}
				else {
					Commons.getLogger().info("Error message is not displayed or appropriate");
					Assert.fail();
				}
				break;
			case 3:
				Commons.clearWebField(vfp.HMinputbox);
				Commons.clickop(vfp.savebtn);
				Thread.sleep(2000);
				if(Errormsg.equalsIgnoreCase(driver.findElement(By.xpath("(//label[contains(@class, 'field-required')])["+i+"]/parent::div/following-sibling::span")).getText())) {
					Commons.getLogger().info("Error Message displayed for Field" + i +"...");
				}
				else {
					Commons.getLogger().info("Error message is not displayed or appropriate");
					Assert.fail();
				}
				break;
			}
	}


}
	@Then("Validate if the vacancy name is displayed in the respective dropdown")
	public void validate_vacancydropdown() {
		cp = new CandidatePage(Commons.getDriver());
		cp.vacancydrpdwn.click();
		if(driver.findElement(By.xpath("//div[@role='listbox']/div/span[contains(text(), '"+vacancyname+"')]")).isDisplayed()) {
			Commons.getLogger().info("Newly added vacancy is displayed...");
			Assert.assertTrue(true);
		}
		else {
			Commons.getLogger().info("Newly added vacancy is not displayed...");
			Assert.assertTrue(false);
		}
	}
}
