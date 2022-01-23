Feature: Login Page Validations

Scenario: Validate LandingTitle
Given user is on Landing page
When user gets the title of page
Then user validates the title of the page "Facebook - Log In or Sign Up"

Scenario: Validate Create new account button
Given user is on Landing page
Then user valdates that Create new account button is enabled and visible

