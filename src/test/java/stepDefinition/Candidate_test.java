package stepDefinition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;

//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CandidatePage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
//import pageObjects.VacancyformPage;
import utilities.DataReader;

public class Candidate_test extends Commons {
	LoginPage lp;
	DashboardPage dp= new DashboardPage(Commons.getDriver());;
	CandidatePage cp = new CandidatePage(Commons.getDriver());
	List<HashMap<String, String>> datamap;
	String temp;
	Map<String, String> candidate;
	Map<String,String> candidate_fields;
	List<String> candidate_field_list = new ArrayList<>();
	String fullName;
	
	
	//Properties p;
	
	/*@Given("User Logs in with Credentials and Navigates to Recruitment Section")
	public void user_logs_in_with_credentials_and_navigates_to_recruitment_section() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		Commons.getLogger().info("Logging in and Navigating to Recruitment");
		try {
	    lp = new LoginPage(Commons.getDriver());
	    dp = new DashboardPage(Commons.getDriver());
	    //Thread.sleep(5000);
	    //p=Commons.getProperties();
	    Commons.waittillvisible(lp.username, 5000);
	    //Commons.sendkeys(lp.username, Commons.getProperties().getProperty("username"));
	    //Commons.sendkeys(lp.password, Commons.getProperties().getProperty("password"));
	    Commons.sendkeys(lp.username, "Admin");
	    Commons.sendkeys(lp.password, "admin123");
	    lp.loginbtn.click();
	    Thread.sleep(3000);
	    //Commons.waitandclick(dp.recruitment, 30);
	    dp.recruitment.click();
	    Thread.sleep(3000);
		}
		catch(Exception e) {
			Commons.getLogger().info("Navigation to recruitment failed...");
			Assert.fail();
		}
	}*/
	public String getcurrentdate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date dt = new Date();
		String currentdate = df.format(dt);
		return currentdate;
	}
	public String getAdjustedDate() {
        LocalDate today = LocalDate.now();
        LocalDate adjusted = today.plusDays(2);

        // If the month has changed after adding 2 days
        if (adjusted.getMonthValue() != today.getMonthValue()) {
            adjusted = adjusted.plusMonths(1);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return adjusted.format(formatter);
    }
	public String getcandidatelogxpath(int i, int j) {
		String xpath = "((//div[@class='oxd-table-body']/div)["+i+"]/div/div/div)["+j+"]";
		switch(j) {
		case 1:
			String DOE=driver.findElement(By.xpath(xpath)).getText();
			return DOE;
		case 2:
			String desc=driver.findElement(By.xpath(xpath)).getText();
			return desc;
		/*case 3:
			String desc=driver.findElement(By.xpath(xpath)).getText();
			return desc;*/
		default:
	        System.out.println("No matching browser");
	        return null;
			
		}
		//return xpath;
	}
	public void getcandidatefields() {
		//candidate_fields = new Map<String,WebElement>();
		candidate_fields.put("First Name", cp.firstname_textbox.getText());
		candidate_fields.put("Middle Name",cp.middlename_textbox.getText());
		candidate_fields.put("Last Name",cp.lastname_textbox.getText());
		candidate_fields.put("Email ID",cp.email_textbox.getText());
		candidate_fields.put("Contact Number",cp.contactnumber_textbox.getText());
		candidate_fields.put("Vacancy",cp.vacancy_dropdown.getText());
		candidate_fields.put("DOA",cp.calendar_textbox.getText());
		candidate_fields.put("Keywords",cp.keywords_textbox.getText());
		candidate_fields.put("Notes",cp.notes_textbox.getText());
		
		for (String key : candidate_fields.keySet()) {
		    candidate_field_list.add(key);
		}

		
	}
	public void getrownumber(String first_name) throws IOException {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Candidate_List");
		int temp = 0;
		for(int i=0;i<datamap.size();i++) {
			if(datamap.get(i).get("First Name").equalsIgnoreCase(first_name)) {
				temp = i;
				//return;
			}
		}
		candidate = datamap.get(temp);
		fullName = candidate.get("First Name")+" "+candidate.get("Middle Name")+" "+candidate.get("Last Name");
		
	}
	@When("User Navigates to Add Candidate form")
	public void navigateto_add_candidateform() throws InterruptedException {
		Commons.waitandclick(cp.addbtn, 3000);
		Thread.sleep(3000);
	}
	@When("Uploads file of format {string}")
	public void resumeupload(String format) throws IOException, InterruptedException {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Resume_File_Paths_One");
		for(int i=0;i<datamap.size();i++) {
			if(format.equalsIgnoreCase(datamap.get(i).get("Format"))) {
				cp.resumeupload.sendKeys(datamap.get(i).get("File Path"));
				Thread.sleep(3000);
				return;
			}
		}
	}
	@Then("Validate if the file gets loaded successfully for the file format: {string}")
	public void validate_fileupload(String format) throws InterruptedException, IOException {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Resume_File_Paths_One");
		for(int i=0;i<datamap.size();i++) {
			if(format.equalsIgnoreCase(datamap.get(i).get("Format"))) {
				Assert.assertEquals(true, cp.uploadedfilename.getText().equalsIgnoreCase(datamap.get(i).get("File Name")));
				return;
			}
		}
	}
	@When("Uploads invalid {string} file")
	public void resumeinvalidupload(String format) throws IOException, InterruptedException {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Resume_File_Paths_Two");
		for(int i=0;i<datamap.size();i++) {
			if(format.equalsIgnoreCase(datamap.get(i).get("Format"))) {
				cp.resumeupload.sendKeys(datamap.get(i).get("File Path"));
				//Thread.sleep(3000);
				//Commons.forcesendkeys(cp.resumeupload, datamap.get(i).get("File Path"));
				Thread.sleep(3000);
				//Assert.assertEquals(true, cp.uploadedfilename.getText().equalsIgnoreCase(datamap.get(i).get("File Name")));
				return;
			}
		}
	}
	@Then("Validate if Candidate details screen is visible")
	public void validate_candidate_details_screen() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(cp.candidate_details_screen.isDisplayed()) {
			Commons.getLogger().info("User has been auto navigated to Candidate details screen");
		}
		else {
			Commons.getLogger().info("User has not been auto navigated to Candidate details screen");
			Assert.fail();
		}
		
	}
	@Then("Validate if the status is {string}")
	public void validate_status_candidate_details_screen(String status) {
		Commons.getLogger().info("Checking the current status...");
		if(status.equalsIgnoreCase(cp.candidate_status_from_view.getText())) {
			Commons.getLogger().info("Status is as expected...");
		}
		else {
			Commons.getLogger().info("Status is not as expected");
			Assert.fail();
		}
	}
	@Then("Validate if details in the screen are as per the form filled")
	public void validate_candidate_details_screen_fields() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(10000);
		Map<String,String> candidate_fields_filled = new HashMap<String,String>();
		/*for(int i =0; i<candidate_field_list.size();i++) {
			String keyToCheck = candidate_field_list.get(i);
			if(candidate.containsKey(keyToCheck) && candidate_fields.containsKey(keyToCheck)) {
				if(keyToCheck.equals("DOA")) {
					candidate_fields_filled.put(keyToCheck, getcurrentdate());
				}
				else {
					candidate_fields_filled.put(keyToCheck, candidate.get(keyToCheck));
				}
			}
			//Commons.getLogger().info(keyToCheck+" "+"field is as per filled form");
		}*/
		for (String keyToCheck : candidate_field_list) {
		    if (candidate.containsKey(keyToCheck) && candidate_fields.containsKey(keyToCheck)) {
		        String value = keyToCheck.equals("DOA") ? getcurrentdate() : candidate.get(keyToCheck);
		        candidate_fields_filled.put(keyToCheck, value);
		    }
		    else if (!candidate_fields_filled.containsKey(keyToCheck) || 
		            !candidate_fields_filled.get(keyToCheck).equals(candidate_fields.get(keyToCheck))) {
		            Commons.getLogger().info("Mismatch in field: " + keyToCheck + 
		                " | Expected: " + candidate_fields.get(keyToCheck) + 
		                " | Actual: " + candidate_fields_filled.get(keyToCheck));
		            Assert.fail();
		        }

		}

		if(candidate_fields_filled.equals(candidate_fields)) {
			Commons.getLogger().info("Fields values match the filled values");
		}
		else {
			Commons.getLogger().info("Fields values didn't match the filled values");
			Assert.fail();
		}
		
	}
	@Then("Navigate to Dashboard screen")
	public void navigate_to_dashboard() {
		dp.dashboard.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Then("Check if candidate to interview is dsiplayed and click on it")
	public void click_on_candidate_interview() {
		if(dp.candidate_interview_link.isDisplayed()) dp.candidate_interview_link.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Then("Check if user can see the candidate in the list of Interview Scheduled candidates and delete the candidate")
	public void validate_candidate_interview_filter() {
		Commons.scrolltolast();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean iscandidatedisplayed = driver.findElement(By.xpath("//div[contains(text(),'"+candidate.get("Vacancy")+"')]/parent::div/following-sibling::div/div[contains(text(), '"+candidate.get("First Name")+"')]/parent::div/following-sibling::div/following-sibling::div/div[contains(text(), '"+getcurrentdate()+"')]/parent::div/following-sibling::div/div[contains(text(), 'Interview Scheduled')]")).isDisplayed();
		if(iscandidatedisplayed) {
			driver.findElement(By.xpath("//div[contains(text(),'"+candidate.get("Vacancy")+"')]/parent::div/following-sibling::div/div[contains(text(), '"+candidate.get("First Name")+"')]/parent::div/following-sibling::div/following-sibling::div/div[contains(text(), '"+getcurrentdate()+"')]/parent::div/following-sibling::div/div[contains(text(), 'Interview Scheduled')]/parent::div/following-sibling::div/div/button[2]")).click();
			Commons.waittillvisible(cp.confirm_delete_popup, 5000);
			cp.confirmdeleteops.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			Commons.getLogger().info("Delete operation over...");
		}
		
	}
	@When("Saves the Add Candidate form")
	public void save_candidateform() throws InterruptedException {
		 Commons.getLogger().info("Saving the form");
		 cp.save_btn.click();
		 Thread.sleep(5000);
	}
	@Then("Validate if Mandatory field error is displayed under all Mandatory fields of Add Candidate form")
	public void mandatory_errorcheck_candidateform_allfields() {
		String Errormsg = "Required";
		Commons.getLogger().info("Starting to check error messages");
		for(int i=1;i<=3;i++) {
			if(Errormsg.equalsIgnoreCase(driver.findElement(By.xpath("(//span[contains(@class, 'oxd-input-field-error-message')])["+i+"]")).getText())) {
				
				Commons.getLogger().info("Error Message displayed for Field" + i +"...");
			}
			else {
				Commons.getLogger().info("Error message is not displayed or appropriate");
				Assert.fail();
			}
		}
	}
	@Then("User fill all Mandatory fields for user with first name as {string}")
	public void mandatory_fieldsfill_candidateform(String first_name) throws IOException {
		    getrownumber(first_name);
			//Map<String, String> candidate = datamap.get(rownum);
			cp.firstname_textbox.sendKeys(candidate.get("First Name"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			cp.lastname_textbox.sendKeys(candidate.get("Last Name"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			cp.email_textbox.sendKeys(candidate.get("Email ID"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			//temp = candidate.get("First Name");	
	}
	@Then("User fill all Non-Mandatory fields for user with first name as {string}")
	public void non_mandatory_fieldsfill_candidateform(String first_name) throws IOException {
		//datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Candidate_List");
		        getrownumber(first_name);
		        cp.middlename_textbox.sendKeys(candidate.get("Middle Name"));
				String vacancy_name = candidate.get("Vacancy");
				cp.vacancy_dropdown.click();
				Commons.waittillvisible(cp.vacancy_list, 3000);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				driver.findElement(By.xpath("//div[@role='listbox']/div/span[contains(text(), '"+vacancy_name+"')]")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				cp.resumeupload.sendKeys(candidate.get("Resume"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				cp.contactnumber_textbox.sendKeys(candidate.get("Contact Number"));
				cp.keywords_textbox.sendKeys(candidate.get("Keywords"));
				cp.notes_textbox.sendKeys(candidate.get("Notes"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				cp.consent_checkbox.click();
				
	}
	@Then("Check if candidate name appears in Candidate filter")
	public void candidate_filter_validation() throws IOException {
		String first_name = candidate.get("First Name");
		cp.candidate_filter.sendKeys(first_name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		if(cp.first_search_option.isDisplayed()) {
			Assert.assertTrue("Candidate name displayed", true);
		}
		else {
			Commons.getLogger().info("Candidate was not found in the filter");
			Assert.fail();
		}
		
	}
	@Then("Validate the Candidate History for {string} candidate from Initiated stage")
	public void rejected_candidate_history_from_initiated_stage(String status) {
		String candidateDescActual;
		String candidateDescExpected = getcandidatelogxpath(1,2).replaceAll("\\s+", " ").trim();
		Commons.scrolltoelement(cp.candidate_history_section);
		Commons.waittillvisible(cp.candidate_history_section, 3000);
		Commons.getLogger().info("Validating candidate history log for "+status+" candidate");
		if(status.equalsIgnoreCase("Rejected")) {
			candidateDescActual = (cp.hiringmanger_name.getText()+" rejected "+fullName+" from the "+ candidate.get("Vacancy")).replaceAll("\\s+", " ").trim();
		}
		else {
			candidateDescActual = (status+" for "+candidate.get("Vacancy")+" by "+cp.hiringmanger_name.getText()).replaceAll("\\s+", " ").trim();
		}
		
		for (int i = 0; i < Math.max(candidateDescExpected.length(), candidateDescActual.length()); i++) {
		    char expectedChar = i < candidateDescExpected.length() ? candidateDescExpected.charAt(i) : '-';
		    char actualChar = i < candidateDescActual.length() ? candidateDescActual.charAt(i) : '-';
		    if (expectedChar != actualChar) {
		        Commons.getLogger().info("Mismatch at index " + i + ": expected '" + expectedChar + "', actual '" + actualChar + "'");
		    }
		}
		if(!cp.candidate_history_records.isEmpty()) {
			String DOE = getcandidatelogxpath(1,1);
			if(DOE.equals(getcurrentdate()) && candidateDescExpected.equalsIgnoreCase(candidateDescActual)){
				Commons.getLogger().info("History log for "+status+" candidate is visible and as expected");
				Assert.assertTrue(true);
			}
			else {
				Commons.getLogger().info("History log for "+status+" candidate is not visible or not as expected");
				Commons.getLogger().info("Expected Add Desc: \"" + candidateDescExpected + "\"");
				Commons.getLogger().info("Actual Add Desc from UI: \"" + candidateDescActual + "\"");
				Assert.fail("Mismatch in candidate history log.\nExpected: \"" + candidateDescExpected + "\"\nActual: \"" + candidateDescActual + "\"");
			}
	}
		
		
}
	@Then("Validate the Candidate History for the newly added candidate in Application Initiated stage")
	public void candidate_history_from_initiated_stage() {
		Commons.getLogger().info("Validating if the history log for addition of candidate");
		String candidateAddDesc = cp.hiringmanger_name.getText()+" added "+fullName;
		String candidateAssignDesc= cp.hiringmanger_name.getText()+" assigned the job vacancy "+candidate.get("Vacancy");
		Commons.scrolltoelement(cp.candidate_history_section);
		Commons.waittillvisible(cp.candidate_history_section, 3000);
		if(!cp.candidate_history_records.isEmpty()) {
			String DOE = getcandidatelogxpath(2,1);
			String addDesc = getcandidatelogxpath(2,2);
			String assignDesc = getcandidatelogxpath(1,2);
			if(DOE.equals(getcurrentdate()) && addDesc.equalsIgnoreCase(candidateAddDesc)){
				Commons.getLogger().info("Candidate addition history log is visible and as expected");
			}
			else {
				Commons.getLogger().info("Candidate addition history log is not visible or not as expected");
				Commons.getLogger().info("Expected Add Desc: " + candidateAddDesc);
				Commons.getLogger().info("Actual Add Desc from UI: " + addDesc);
				Assert.fail();
			}
			if(DOE.equals(getcurrentdate()) && assignDesc.equalsIgnoreCase(candidateAssignDesc)){
				Commons.getLogger().info("Candidate assigned with Job Vacancy is logged in Candidate History and as expected");
			}
			else {
				Commons.getLogger().info("Candidate assigned with Job Vacancy is not logged in Candidate History or not as expected");
				Commons.getLogger().info("Expected Add Desc: " + candidateAssignDesc);
				Commons.getLogger().info("Actual Add Desc from UI: " + assignDesc);
				Assert.fail();
			}
			
		}
	}
	@Then("Delete the Newly added candidate")
	public void delete_filtered_candidate() {
		Commons.getLogger().info("Deleting the candidate...");
		cp.first_candidate_delete.click();
		Commons.waittillvisible(cp.confirm_delete_popup, 5000);
		cp.confirmdeleteops.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Commons.getLogger().info("Delete operation over...");
	}
	@Then("User clicks view icon")
	public void view_filtered_candidate() {
		Commons.getLogger().info("Viewing the candidate...");
		cp.first_candidate_view.click();
		Commons.waittillvisible(cp.candidate_details_screen, 5000);
		Commons.getLogger().info("User has been navigated to Candidate details screen...");
	}
	@Then("Check if Newly added candidate name no longer appears in Candidate filter")
	public void candidate_removal_filter_validation() {
		//String first_name = candidate.get("First Name");
		//cp.candidate_filter.sendKeys(first_name);
		Commons.waittillvisible(cp.search_btn, 5000);
		cp.search_btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			Commons.getLogger().info("Checking if candidate name is displayed in filter search...");
			String numberofRecords = cp.numberoffilterrecords.getText();
			if(numberofRecords.equalsIgnoreCase("No Records Found")) {
				Commons.getLogger().info("Candidate name didn't appear in filter search");
				Assert.assertTrue(true);
			}
			else {
				Commons.getLogger().info("Candidate name appeared in filter search");
				Assert.fail();
			}
			
			
	}
	@Then("Check if the status of the candidate is {string}")
	public void validate_candidate_status_in_table(String status) {
		Commons.scrolltolast();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if(driver.findElement(By.xpath("(//div[@role='row'])[2]/div/following-sibling::div/following-sibling::div/div[contains(text(), '"+fullName+"')]")).isDisplayed()) {
			
			String actualStatus = driver.findElement(By.xpath("(//div[@role='row'])[2]/div/following-sibling::div/following-sibling::div/div[contains(text(), '"+status+"')]")).getText();
			    //Assert.assertEquals(true, actualStatus.equals(status));
				Assert.assertEquals(true, actualStatus.equals(status));
		}
		else {
			Commons.getLogger().info("Status was not as expected");
			Assert.fail();
		}
	}
	@Then("{string} the Candidate")
	public void reject_candidate(String action) {
		//if(action.equalsIgnoreCase("Reject")) cp.reject_btn.click();
		//else cp.shortlist_btn.click();
		switch (action){
		case "Reject":
			driver.findElement(By.xpath("//button[normalize-space()='"+action+"']")).click();
			Commons.waittillvisible(driver.findElement(By.xpath("//h6[text()[contains(.,'"+action+"')]]")), 10000);
			cp.notes_textbox.sendKeys("Rejecting the candidate from "+action+"stage");
			break;
		case "Shortlist":
			driver.findElement(By.xpath("//button[normalize-space()='Shortlist']")).click();
			Commons.waittillvisible(driver.findElement(By.xpath("//h6[text()[contains(.,'"+action+"')]]")), 10000);
			cp.notes_textbox.sendKeys(action+"ing the candidate");
			break;
		case "Schedule Interview":
			driver.findElement(By.xpath("//button[normalize-space()='"+action+"']")).click();
			Commons.waittillvisible(driver.findElement(By.xpath("//h6[text()[contains(.,'"+action+"')]]")), 10000);
			cp.interviewtitle_textbox.sendKeys(candidate.get("Vacancy")+" Interview");
			cp.Interviewer1.sendKeys("Rahul");
			Commons.waitandclick(cp.first_search_option, 2000);
			cp.calendar_textbox.sendKeys(getAdjustedDate());
			cp.clock_icon.click();
			for(int i=0;i<10;i++) {
				cp.hourup_btn.click();
			}
			cp.minuteup_btn.click();
			Commons.scrolltolast();
			cp.notes_textbox.sendKeys("Scheduling Interview for the candidate");
			break;
		case "Mark Interview Failed":
			driver.findElement(By.xpath("//button[normalize-space()='"+action+"']")).click();
			Commons.waittillvisible(driver.findElement(By.xpath("//h6[text()[contains(.,'"+action+"')]]")), 10000);
			cp.notes_textbox.sendKeys("Markinging Interview Failed for the candidate");
		    break;
		case "Mark Interview Passed":
			driver.findElement(By.xpath("//button[normalize-space()='"+action+"']")).click();
			Commons.waittillvisible(driver.findElement(By.xpath("//h6[text()[contains(.,'"+action+"')]]")), 10000);
			cp.notes_textbox.sendKeys("Markinging Interview Passed for the candidate");
		    break;
		default:
			Commons.getLogger().info("Issue in finding the correct action");
			break;
		}
		
		//cp.notes_textbox.sendKeys(action+"ing the candidate");
		cp.save_btn.click();
	}
	@Then("Filter Candidate list by newly added candidate name")
	public void filterby_candidatename() {
		cp.first_search_option.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		cp.search_btn.click();
	}
	@Then("Validate if the newly added candidate is displayed in Candidate list table")
	public void validate_candidatelist_table() {
		Commons.scrolltolast();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if(driver.findElement(By.xpath("(//div[@role='row'])[2]/div/following-sibling::div/following-sibling::div/div[contains(text(), '"+fullName+"')]")).isDisplayed()) {
			
			    Commons.getLogger().info("Candidate is visible in the table");
				Assert.assertTrue("Candidate has been added", true);
			
		}
		else {
			Commons.getLogger().info("Candidate was not found in the table");
			Assert.fail();
		}
	}
	@Then("Clears each of the Mandatory fields to check if Mandatory error is thrown again for the respective Add Candidate form field")
	public void mandatory_errorcheck_candidateform_indvidual_field() throws IOException, InterruptedException {
		String Errormsg = "Required";
		//vfp = new VacancyformPage(Commons.getDriver());
		Commons.getLogger().info("Starting to check error messages");
		for(int i=1;i<=3;i++) {
			switch (i) {
			case 1:
				Commons.clearWebField(cp.firstname_textbox);
				Thread.sleep(5000);
				if(Errormsg.equalsIgnoreCase(cp.field_errormsg.getText())) {
					Commons.getLogger().info("Error Message displayed for Field" + i +"...");
					cp.firstname_textbox.sendKeys("test");
				}
				else {
					Commons.getLogger().info("Error message is not displayed or appropriate");
					Assert.fail();
				}
				break;
			case 2:
				//vfp.jobtitledrpdwn.clear();
				Commons.clearWebField(cp.lastname_textbox);
				Thread.sleep(2000);
				if(Errormsg.equalsIgnoreCase(cp.field_errormsg.getText())) {
					Commons.getLogger().info("Error Message displayed for Field" + i +"...");
					cp.lastname_textbox.sendKeys("test");
				}
				else {
					Commons.getLogger().info("Error message is not displayed or appropriate");
					Assert.fail();
				}
				break;
			case 3:
				Commons.clearWebField(cp.email_textbox);
				cp.save_btn.click();
				Thread.sleep(2000);
				if(Errormsg.equalsIgnoreCase(cp.field_errormsg.getText())) {
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
	@Then("User enters Email of format: {string} and validates if error message is displayed if the entered email is invalid")
	public void enter_differentemails(String format) throws IOException, InterruptedException {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Email_IDs");
		for(int i=0;i<datamap.size();i++) {
			if(format.equalsIgnoreCase(datamap.get(i).get("Format Type"))) {
				cp.email_textbox.sendKeys(datamap.get(i).get("Email ID"));
				Thread.sleep(3000);
				if("Valid".equals(datamap.get(i).get("Validity"))) {
					try {
					Commons.getLogger().info("Checking if error message is displayed...");
					boolean ismsgdisplayed = cp.field_errormsg.isDisplayed();
					Assert.assertEquals(false, ismsgdisplayed);
					}
					catch(NoSuchElementException e) {
					    Commons.getLogger().info("Error message not found in DOM.");
					    Assert.assertTrue(true);
					}

				}
				else {
					Commons.getLogger().info("Checking if error message is displayed...");
					boolean ismsgdisplayed = cp.field_errormsg.getText().equalsIgnoreCase("Expected format: admin@example.com");
					Assert.assertEquals(true, ismsgdisplayed);
				}
			}
		}
	}
	@Then("Validate if user gets appropriate error message for uploading a {string} file")
	public void validate_fileupload_error(String format) throws IOException {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\DDT_testdata.xlsx", "Resume_File_Paths_Two");
		for(int i=0;i<datamap.size();i++) {
			if(format.equalsIgnoreCase(datamap.get(i).get("Format"))) {
				Assert.assertEquals(true, cp.field_errormsg.getText().equalsIgnoreCase(datamap.get(i).get("Expected Error Message")));
				return;
			}
		}
	}
}
