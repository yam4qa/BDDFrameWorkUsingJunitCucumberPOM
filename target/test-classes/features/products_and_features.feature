Feature: as a user I want a Products & Services page so that i can manage the products and services

Scenario Outline:
 Given a Valid user credentials "<username>" and "<password>"
 	When user able to login and go to DashBoard page
	Then On left navigation panel should show Dashbord Menu
	When user navigates to Products&Services and go to New product 
	Then New product Page should display
	And user able to enter product details "<productName>", "<salesPrice>" , "<description>"
	And user submits New Product Form
	When User access Products link Under Products&Services tab
	Then User should get to see Products list
	When user want to see created product in the list
	Then user able to search the product in the list
	
	
	Examples:
		| username				|password	| productName 	|salesPrice	| description	|
		|techfiosdemo@gmail.com	|abc123		| Ypen1			|	87		|	dfsdf 		|
		|techfiosdemo@gmail.com	|abc123		| Ypen2			|	77		|	dfuii 		|
		
# if we have two feature file having few same steps then system raising duplication of steps
# if we want to use same existing steps then driver should carry forward between steps.java files
# So question is can we have multiple feature files in same project ??