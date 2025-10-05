Feature: Add new Candidate and validate its behaviour 

@trail @Candidates_Suite @Recruitement_Suite
Scenario Outline: Validate user trying to upload different types of files with valid format in Resume field of Add Candidate form
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
And Uploads file of format "<format_name>"
Then Validate if the file gets loaded successfully for the file format: "<format_name>"
Examples:
          |format_name|
           |PDF|
           |DOCX|
           |ODT|
           |RTF|
           |TXT|
           |DOC|
          
@Candidates_Suite @Recruitement_Suite
Scenario Outline: Validate if user gets appropriate error message when uploading an invalid file in Resume field 
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
And Uploads invalid "<format_name>" file
Then Validate if user gets appropriate error message for uploading a "<format_name>" file
Examples:
           |format_name|
           |PNG        |
           |HTML       |
           |JPG        |
           |JAVA       |
           |PDF        |
           |JPG        |

@Candidates_Suite @Recruitement_Suite
Scenario Outline: Validate if user gets appropriate error message when entering email in invalid format
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User enters Email of format: "<format_type>" and validates if error message is displayed if the entered email is invalid

Examples:
           |format_type|
           |email_1     |
           |email_2     |
           |email_3     |
           |email_4     |
           |email_5     |
           |email_6     |

@Candidates_Suite @Recruitement_Suite
Scenario: Validate if user gets appropriate error message when Mandaotry fields are not filled
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
And Saves the Add Candidate form
Then Validate if Mandatory field error is displayed under all Mandatory fields of Add Candidate form
And User fill all Mandatory fields for user with first name as "<first_name>"
And Clears each of the Mandatory fields to check if Mandatory error is thrown again for the respective Add Candidate form field
Examples:
           |first_name|
           |Walter|

@Candidates_Suite @Recruitement_Suite
Scenario: User Validates adding a New Candidate and deleting thenewly added candidate
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
#And Validate if details in the screen are as per the form filled
And Validate the Candidate History for the newly added candidate in Application Initiated stage
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Validate if the newly added candidate is displayed in Candidate list table
#And User clicks view icon
#And Validate if Candidate details screen is visible
#And Navigate to Candidates section
#And Filter Candidate list by newly added candidate name
And Delete the Newly added candidate
And Check if Newly added candidate name no longer appears in Candidate filter
Examples:
           |first_name|
           |Michael|

@Candidates_Suite @Recruitement_Suite
Scenario: Validate candidate rejection from Application Initiated stage and Candidate History
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
#And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Dwight|

@Candidates_Suite @test1 @Recruitement_Suite
Scenario: Validate if user can Shortlist a candidate, reject the candidate from shortlisted stage and validate the candidate History
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
#And User clicks view icon
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And Validate the Candidate History for "Shortlisted" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Shortlisted"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |James|

@Candidates_Suite @Recruitement_Suite
Scenario: Validate if user can Schedule Interview for a candidate, reject the candidate from Interview Scheduled stage and validate the candidate History
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
#And Validate the Candidate History for "Interview Scheduled" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Interview Scheduled"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Michael|

@Candidates_Suite @Recruitement_Suite        
Scenario: Validate the candidate to interview feature in Dashboard screen
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And Navigate to Dashboard screen
And Check if candidate to interview is dsiplayed and click on it
And Check if user can see the candidate in the list of Interview Scheduled candidates and delete the candidate
Examples:
           |first_name|
           |Andrew|

@Candidates_Suite @Recruitement_Suite
Scenario: Validate if user can mark Interview failed for a candidate, reject the candidate from Interview Failed stage and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Failed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Failed"
#And Validate the Candidate History for "Interview Failed" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Interview Failed"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Andrew|

@Candidates_Suite @Recruitement_Suite
Scenario: Validate if user can mark Interview Passed for a candidate, reject the candidate from Interview Passed stage and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
#And Validate the Candidate History for "Interview Passed" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Interview Passed"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Pamela|
@Candidates_Suite @Recruitement_Suite
Scenario: Validate if user can Schedule another Interview for the candidate from Interview Passed stage, again reject the candidate from Interview Scheduled stage and validate the candidate History
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And Schedule another Interview for the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
#And Validate the Candidate History for "Interview Scheduled" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Interview Scheduled"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Kelly|

@Candidates_Suite @Recruitement_Suite
Scenario: Validate if user can mark Interview failed for a candidate in the second round of interview, then reject the candidate from Interview Failed stage and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And Schedule another Interview for the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Failed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Failed"
#And Validate the Candidate History for "Interview Failed" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Interview Failed"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Kelly|
           
@Candidates_Suite @Recruitement_Suite          
Scenario: Validate if user can mark Interview passed for a candidate in the second round of interview, then reject the candidate from Interview passed stage and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And Schedule another Interview for the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
#And Validate the Candidate History for "Interview Passed" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Interview Passed"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Angella|
           
@Candidates_Suite @Recruitement_Suite           
Scenario: Validate if user can Offer job for candidate who passed second round of interview, then reject the candidate from Job Offered stage and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And Schedule another Interview for the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And "Offer Job" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Job Offered"
#And Validate the Candidate History for "Job Offered" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Job Offered"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Ryan|
           
@Candidates_Suite @Recruitement_Suite           
Scenario: Validate if user can Decline Job Offer for candidate who was offered the Job, then reject the candidate from Offer Declined stage and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And Schedule another Interview for the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And "Offer Job" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Job Offered"
And "Offer Declined" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Offer Declined"
#And Validate the Candidate History for "Offer Declined" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Offer Declined"
And User clicks view icon
And "Reject" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Rejected"
#And Validate the Candidate History for "Rejected" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Rejected"
And Delete the Newly added candidate
Examples:
           |first_name|
           |Ryan|
           
@Candidates_Suite @Recruitement_Suite @test       
Scenario: Validate if user can Hire the candidate who was offered the Job and validate the candidate history
Given User Logs in with Credentials and Navigates to Recruitment Section
When User Navigates to Add Candidate form
Then User fill all Mandatory fields for user with first name as "<first_name>"
And User fill all Non-Mandatory fields for user with first name as "<first_name>"
And Saves the Add Candidate form
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Application Initiated"
And "Shortlist" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Shortlisted"
And "Schedule Interview" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And Schedule another Interview for the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Scheduled"
And "Mark Interview Passed" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Interview Passed"
And "Offer Job" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Job Offered"
And "Hire" the Candidate
And Validate if Candidate details screen is visible
And Validate if the status is "Status: Hired"
#And Validate the Candidate History for "Hired" candidate
And Navigate to Candidates section
And Check if candidate name appears in Candidate filter
And Filter Candidate list by newly added candidate name
And Check if the status of the candidate is "Hired"
#And Delete the Newly added candidate

Examples:
           |first_name|
           |Gabriel|