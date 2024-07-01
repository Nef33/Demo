Feature: JJ is doing practice on web elements

  Background:

    Given Open Rail Command application
    When user enters valid credentials
    Then user is able to login
    Then user selects RSI TEST CLIENT account

  Scenario: Web element practice
    Given JJ is on shipment dropdown
    When she clicks on Shipment option
    Then she can click on some web elements