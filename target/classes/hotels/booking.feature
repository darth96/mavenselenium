Feature: Booking
  Scenario: Verify changes dates button is displayed at the end of search results
    Given I am on hotels homepage
    When Enter "bora" in destination
     And Select "Bora Bora, French Polynesia" from auto suggestion
     And Select October 10, 2021 as Check-in
     And Select October 31,2021 as Check-out
     And Click apply
     And Click on Search button
   Then I verify at the end of search results changes dates is displayed and enabled

    Scenario:
      Given I am on hotels homepage
      When I Click on Guests
         And Select Adults as "4"
         And Select Children as "2"
         And Select first child age "4"
         And Select second child age "<1"
      Then I verify on rooms pop-up, number of adults and children same as selected on step #3 and #4
         And Click apply
         And I verify total number of guests in sum of adults and children same as selected on steps #3 and #4

