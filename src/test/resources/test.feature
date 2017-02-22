Feature: open google and search for Version 1

@version1
Scenario: test if we version1.com is the top result when
 searching for version 1 on google.ie

Given I open the website "www.google.ie"
And I enter "version1" into the search box
And I click Search
And I select the top search
Then I should be on "www.version1.com"