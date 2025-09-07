Feature: logout from the current user
Scenario: how to logout
Given first open bstack website
Then login into account
Then logout 
Then close that window 