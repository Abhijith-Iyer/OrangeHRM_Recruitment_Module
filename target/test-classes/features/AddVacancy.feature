Feature: Add a new Vacancy 

@trail
Scenario Outline: Validate adding and deleting of vacancy
Given User Logs in with Credentials and Navigates to Recruitment Section
When Clicks on Vacancy
And Fills the Job Vacancy form for "<jobtitle>" position with Hiring Manager as "<HiringManager>"
And Saves the form
And Navigates back to Vacancies to see the vacancy table
Then The newly added Job Vacancy for "<jobtitle>" position with Hiring Manager as "<HiringManager>" should be visible in the table
Then Delete the newly added vacancy for "<jobtitle>" position with Hiring Manager as "<HiringManager>" and validate if the deleted vacancy is removed from the vacancy table
Examples: 
      | jobtitle        | HiringManager |
      | QA Lead         | Radha         |


@trail
Scenario: Validate whether user can create duplicate vacancy
Given User Logs in with Credentials and Navigates to Recruitment Section
When Clicks on Vacancy
And Capture an existing vacancy from the vacancy table
And Navigates to fill Vacancy form and enters the captured vacancy in vacancy name
Then Already exists error message should be displayed under the text box
