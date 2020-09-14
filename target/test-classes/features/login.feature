Feature: Login Page
	As a User I want a login page so that only autherised users can have access
	
#Scenario Outline: Valid users should be able to login
Scenario: Valid users should be able to login
Given a valid user
When user goes to techfios site
Then techfios login page should displayed
When user provides credentials
Then Dashboard page should be displayed
And username should match

Scenario: Valid users should be able to login
Given an invalid user
When user goes to techfios site
Then techfios login page should displayed
When user provides credentials
Then login page should be displayed
And invalied credentials alert should be displayed

#	Examples:
#		|username				| password	|
#		|techfiosdemo@gmail.com	| abc123	|