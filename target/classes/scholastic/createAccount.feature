Feature: Create account

  Scenario Outline: Verify user can create account in taxable and non-taxable state using zip code
    Given I am on scholastic homepage
    When I click on Create an Account as a teacher/administrator
        And I enter firstname "<firstname>" lastname "<lastname>" email "<emailAddress>" and password "<password>"
        And I search by zipcode "<zipcode>"
        And I enter schoolname "<schoolname>"
        And I select autosuggestion "<suggestion>"
        And I select role teacher by 12th grade
        And I select guided reading level
    Then I verify there is a CLASS CODE allocated to the teacher, present on Home-Page and MyAccount-Page
    Then I verify same school address is present as selected while creating the account
    Examples:
    |firstname|lastname|emailAddress         |password  |zipcode|schoolname           |suggestion         |
    |first    |last    |firstlast@gmail.com|password123!|10012  |Scholastic+Book+Clu|Scholastic+Book+Clubs|
    |  third  | fourth |thirdfourth@gmail.com|passwor   |99518  | AdakScho        |AdakSchool             |

  Scenario: User can create a new teacher account in taxable state using School Search
    Given I am on scholastic homepage
    When I click on Create an Account as a teacher/administrator
    And I enter firstname lastname emailAddress and password
        And I search by state and city
        And I enter schoolname
        And I select role teacher by 12th grade
        And I select guided reading level
    Then I verify there is a CLASS CODE allocated to the teacher, present on Home-Page and MyAccount-Page
    Then I verify same school address is present as selected while creating the account

