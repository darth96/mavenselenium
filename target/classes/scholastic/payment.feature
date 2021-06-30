Feature: Payments Order
  Scenario: Verify user get error message when adding a 4th credit card
    Given I login on Scholastic
    When I click on Payment Methods from My Account
    Then I verify user get error msg 'You can only store three credit cards' when adding a 4th credit card

  Scenario: Verify user can delete item on Cart page
    Given I login on Scholastic
    When I click on 'Enter Orders'
    And Select Student Flyer Orders
    And Enter student name "Harry" Items "2S8" Quantity '5' Items "11S8" Quantity '1'
    And Enter student name "John" Items "2G8" Quantity '2' Items "14G8" Quantity '2'
    And Enter student name "Michael" Items "4G8" Quantity '4' Items "1G8" Quantity '10'
    And Click on review cart
    And Click on 'X button corresponding to 2S8 item for Harry'
    And Click on 'Yes'
    Then I verify For Harry, item 2S8 gets deleted
    And I verify Respective amounts and quantities get updated

    Scenario: Verify YTO-By Flyer jumper
      Given I login on Scholastic
      When I click on 'Enter Orders'
           And Select 'Your teacher Order'
           And Click on Price-QTY box
      Then I verify Teacher sees a jumper right above the box with message: Heading - IMPORTANT Message - All student paper flyer orders MUST be entered in the Student Flyer Orders tab
      And Enter data in the clicked Price-QTY box and click on X on the Jumper
          And I verify Teacher does NOT see any jumper

      Scenario: Verify teacher gets error for invalid item number in SFO (Student Flyer Order)
        Given I login on Scholastic
        When I click on 'Enter Orders'
            And Select Student Flyer Orders
            And Enter student name 'Harry' Items '111'
            And Click on 'Add Button'
        Then I verify Expected error msg Please enter a valid item number

  Scenario: Verify zero tax for only SFO order in the checkout
    Given I login on Scholastic
    When I click on 'Enter Orders'
        And Select Student Flyer Orders
        And Enter student name "Harry" Items "1G8" Quantity '5' Items "4G8" Quantity '1'
        And Enter student name "John" Items "3S8" Quantity '2'
        And Enter student name "Michael" Items "11S8" Quantity '4' Items "2S8" Quantity '10'
        And Click on review cart
        And click on proceed to check out and again click proceed to checkout
    Then I verify tax amount is "$0.00"

    Scenario: Verify non-zero tax is present for SFO-YTO orders in the checkout for teacher with tax state school
      Given I login on Scholastic on non taxable state
      When I click on 'Enter Orders'
        And Select Student Flyer Orders
        And Enter student name "Harry" Items "3S8" Items "11G8" Items "4S8" Items "1G8"
        And I click on 'Enter Orders'
        And Select 'Your teacher Order'
        And I type on Price-QTY box
        And Click on review cart
        And click on proceed to check out and again click proceed to checkout
    Then I verify tax amount is "$0.00"



