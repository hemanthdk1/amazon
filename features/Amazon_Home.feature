Feature: Amazon Home Page Scenarios

  Scenario Outline: Shop Samsung TV under TV Appliances and Electronics Section
    Given I am on Amazn Home Page
    When I click on Main  menu
    And I select TV Appliances and Electronics Section from Submenu and Click Televisions
    And I should be selecting '<brand>' from the list and see Specific brand Tv Reesults
    Then I should be able to Select based on '<price>'
    And I should be able to validate the selected item

    Examples: 
      | brand   | price              |
      | Samsung | Price: High to Low |
      | Samsung | Price: Low to High |
      | OnePlus | Price: High to Low |
      | OnePlus | Price: Low to High |
