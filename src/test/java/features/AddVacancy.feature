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

@trail
Scenario: Validate whether user can search newly added vacancy using vacancy name
Given User Logs in with Credentials and Navigates to Recruitment Section
When Clicks on Vacancy
And Fills the Job Vacancy form for "<jobtitle>" position with Hiring Manager as "<HiringManager>"
And Saves the form
And Navigates back to Vacancies to see the vacancy table
And Search for the vacancy by vacancy name
Then Check if the newly added vacancy is filtered and displayed in the vacancy table
Then Delete the newly added vacancy for "<jobtitle>" position with Hiring Manager as "<HiringManager>" and validate if the deleted vacancy is removed from the vacancy table
Examples: 
      | jobtitle        | HiringManager |
      | QA Lead         | Radha         |

@smoke
Scenario: Validate whether user can edit a Vacancy detail
Given User Logs in with Credentials and Navigates to Recruitment Section
When Clicks on Vacancy
And Fills the Job Vacancy form for "<jobtitle>" position with Hiring Manager as "<HiringManager>"
And Saves the form
And Navigates back to Vacancies to see the vacancy table
And Search for the vacancy by vacancy name
And Click on Edit Icon for "<jobtitle>" position with Hiring Manager as "<HiringManager>"
And Update the Job title field to "Content Specialist"
And Saves the form
And Navigates back to Vacancies to see the vacancy table
And Search for the vacancy by vacancy name
Then Validate if the Job title is updated for the Vacancy to "Content Specialist"
Then Delete the newly added vacancy for "Content Specialist" position with Hiring Manager as "<HiringManager>" and validate if the deleted vacancy is removed from the vacancy table
Examples: 
      | jobtitle        | HiringManager |
      | QA Lead         | Radha         |