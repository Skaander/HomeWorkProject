Feature: Login to Authentication Menu

Scenario Outline: Login with Username and Wrong password

Given I access to Orange  login site

When I enter "<username>" and "<password>" 

Then I want to see an error message

Examples: 
| username  | password    |
| tomsmith  | admin12 |

Scenario Outline: Login with correct Username and Password

Given I access to Orange  login site

When User enter "<username>" and "<password>" 

Then I want to land on my Homepage


Examples: 
| username  | password    |
| tomsmith  | SuperSecretPassword! |


Scenario Outline: Login with Username and Wrong password and logout

Given I access to Orange  login site

When User enter "<username>" and "<password>" 

Then I want to land on my Homepage

And I want to logout

Examples: 
| username  | password    |
| tomsmith  | SuperSecretPassword! |

