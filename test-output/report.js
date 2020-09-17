$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/java/features/navigation.feature");
formatter.feature({
  "line": 1,
  "name": "Navigation Unit testing",
  "description": "As a User I want a Navigation Menu where all links provided and should be working",
  "id": "navigation-unit-testing",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5793815600,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 4,
      "value": "# Scenario: All navigation links should be working"
    },
    {
      "line": 5,
      "value": "# Given a Valid user credentials \"techfiosdemo@gmail.com\" and \"abc123\""
    },
    {
      "line": 6,
      "value": "# When user able to login and go to DashBoard page"
    },
    {
      "line": 7,
      "value": "# Then On left navigation panel should show Dashbord Menu"
    },
    {
      "line": 8,
      "value": "# When user access CRM Tab and add contact"
    },
    {
      "line": 9,
      "value": "# Then User should get New contact Add form"
    },
    {
      "line": 10,
      "value": "# When user access List contacts under CRM Tab"
    },
    {
      "line": 11,
      "value": "# Then User should get List of all contacts"
    },
    {
      "line": 12,
      "value": "# When User access Transactions tab and New Deposit"
    },
    {
      "line": 13,
      "value": "# Then User should get New deposit form"
    },
    {
      "line": 14,
      "value": "# When User access New Expense under Transactions tab"
    },
    {
      "line": 15,
      "value": "# Then User should get New Expense form"
    },
    {
      "line": 16,
      "value": "# When User Access Sales tab and New Invoice"
    },
    {
      "line": 17,
      "value": "# Then User should get new Invoice form"
    },
    {
      "line": 18,
      "value": "# When User access Invoices under Sales Tab"
    },
    {
      "line": 19,
      "value": "# Then User can get to see list of invoices"
    },
    {
      "line": 20,
      "value": "# When User access Bank \u0026 Cash and New Account"
    },
    {
      "line": 21,
      "value": "# Then User should be able to see new account form"
    },
    {
      "line": 22,
      "value": "# When User access List Accounts under Band\u0026Cash tab"
    },
    {
      "line": 23,
      "value": "# Then User should get to see Accounts list"
    },
    {
      "line": 24,
      "value": "# When user navigates to Products\u0026Services and go to New product"
    },
    {
      "line": 25,
      "value": "# Then New product Page should display"
    },
    {
      "line": 26,
      "value": "# When User access Products link Under Products\u0026Services tab"
    },
    {
      "line": 27,
      "value": "# Then User should get to see Products list"
    },
    {
      "line": 28,
      "value": "#"
    },
    {
      "line": 29,
      "value": "#"
    },
    {
      "line": 30,
      "value": "#Scenario Outline: Under Bank \u0026 Cash User should be able to add new account"
    },
    {
      "line": 31,
      "value": "# Given a Valid user credentials \"\u003cusername\u003e\" and \"\u003cpassword\u003e\""
    },
    {
      "line": 32,
      "value": "# When user able to login and go to DashBoard page"
    },
    {
      "line": 33,
      "value": "# Then On left navigation panel should show Dashbord Menu"
    },
    {
      "line": 34,
      "value": "# When User access Bank \u0026 Cash and New Account"
    },
    {
      "line": 35,
      "value": "# Then User able to add newBankAccount details \"\u003ctitle\u003e\" , \"\u003cdescription\u003e\" , \"\u003cbalance\u003e\""
    },
    {
      "line": 36,
      "value": "# And submit the newBankAccount form"
    },
    {
      "line": 37,
      "value": "#"
    },
    {
      "line": 38,
      "value": "#"
    },
    {
      "line": 39,
      "value": "#Examples:"
    },
    {
      "line": 40,
      "value": "#\t| username\t\t\t\t|password\t| title\t\t|description\t|  balance \t|"
    },
    {
      "line": 41,
      "value": "#\t|techfiosdemo@gmail.com\t|abc123\t\t| laptop \t| 25 inch \t\t|   200\t\t|"
    },
    {
      "line": 42,
      "value": "#\t|techfiosdemo@gmail.com\t|abc123\t\t| laptop \t| 27 inch \t\t|   175\t\t|"
    },
    {
      "line": 43,
      "value": "#"
    }
  ],
  "line": 45,
  "name": "All navigation links should be working",
  "description": "",
  "id": "navigation-unit-testing;all-navigation-links-should-be-working",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 46,
  "name": "a Valid user credentials from database",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "user able to login and go to DashBoard page",
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "On left navigation panel should show Dashbord Menu",
  "keyword": "Then "
});
formatter.match({
  "location": "SideNavigationSteps.a_Valid_user_credentials_from_database()"
});
formatter.result({
  "duration": 2408875200,
  "status": "passed"
});
formatter.match({
  "location": "SideNavigationSteps.user_able_to_login_and_go_to_DashBoard_page()"
});
formatter.result({
  "duration": 945907600,
  "status": "passed"
});
formatter.match({
  "location": "SideNavigationSteps.on_left_navigation_panel_should_show_Dashbord_Menu()"
});
formatter.result({
  "duration": 40382400,
  "status": "passed"
});
formatter.after({
  "duration": 5706615100,
  "status": "passed"
});
});