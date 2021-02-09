Feature:Login
As a user, I can able to sign in

@login
Scenario:user can login with valid credentials
Given user is on the login page
And user logs in with valid credentials
Then user verify that pageTitle is "Swag Labs"
