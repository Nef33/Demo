
Feature: Diversion

  This feature is creating,editing and canceling diversions

  Background:

    Given Open Rail Command application
    When user enters valid credentials
    Then user is able to login
    Then user selects RSI TEST CLIENT account

  Scenario: Create Diversion

    Given user opens diversion page
    When user creates a diversion
    Then new diversion appears on the first row of Diversions page

  Scenario: Edit Diversion

    Given user opens diversion page
    When user selects first diversion to edit
    And user edits shipment from Edit Diversion tab
    Then updated diversion appears with new values on the first row of Diversions page