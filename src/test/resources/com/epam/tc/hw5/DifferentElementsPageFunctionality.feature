Feature: Inner Page check

  Scenario: Check Web elements on Different Elements Page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then I expect username to be 'ROMAN IOVLEV'
    And  I Open through the header menu Service and select Different Elements Page
    When I select 'Water' and 'Wind' in checkboxes on Different Element Page
    Then 'Water' and 'Wind' checkboxes are selected
    And  I select radio 'Selen'
    Then 'Selen' radio is selected
    And  I select 'Yellow' in dropdown
    Then 'Yellow' is selected in dropdown
    Then Log rows are displayed for each selected web elements containing selected items
