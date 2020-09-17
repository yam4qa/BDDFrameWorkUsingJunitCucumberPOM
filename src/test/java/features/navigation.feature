Feature:  Navigation Unit testing
	As a User I want a Navigation Menu where all links provided and should be working
 
# Scenario: All navigation links should be working
# Given a Valid user credentials "techfiosdemo@gmail.com" and "abc123"
# When user able to login and go to DashBoard page
# Then On left navigation panel should show Dashbord Menu
# When user access CRM Tab and add contact
# Then User should get New contact Add form  
# When user access List contacts under CRM Tab
# Then User should get List of all contacts
# When User access Transactions tab and New Deposit
# Then User should get New deposit form
# When User access New Expense under Transactions tab
# Then User should get New Expense form
# When User Access Sales tab and New Invoice
# Then User should get new Invoice form 
# When User access Invoices under Sales Tab
# Then User can get to see list of invoices
# When User access Bank & Cash and New Account
# Then User should be able to see new account form
# When User access List Accounts under Band&Cash tab
# Then User should get to see Accounts list
# When user navigates to Products&Services and go to New product
# Then New product Page should display
# When User access Products link Under Products&Services tab
# Then User should get to see Products list
#
# 
#Scenario Outline: Under Bank & Cash User should be able to add new account
# Given a Valid user credentials "<username>" and "<password>"
# When user able to login and go to DashBoard page
# Then On left navigation panel should show Dashbord Menu
# When User access Bank & Cash and New Account
# Then User able to add newBankAccount details "<title>" , "<description>" , "<balance>"
# And submit the newBankAccount form
#
# 
#Examples: 
#	| username				|password	| title		|description	|  balance 	|
#	|techfiosdemo@gmail.com	|abc123		| laptop 	| 25 inch 		|   200		|
#	|techfiosdemo@gmail.com	|abc123		| laptop 	| 27 inch 		|   175		|
#	

 Scenario: All navigation links should be working
 Given a Valid user credentials from database
 When user able to login and go to DashBoard page
 Then On left navigation panel should show Dashbord Menu
