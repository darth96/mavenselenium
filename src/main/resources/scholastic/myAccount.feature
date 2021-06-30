Feature: My account

  Scenario: Teacher can add books in Recommendations List from Quick View
    Given I login on Scholastic
    When I search Harry
        And Click on Quick Look on a book from results
        And Click on Recommend
        And Select Recommendations to Students from options
    Then Verify the item is added in Recommendations to Students Lists under My Lists

