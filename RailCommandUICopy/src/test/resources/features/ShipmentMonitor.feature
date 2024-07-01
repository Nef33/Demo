Feature: ShipmentMonitor

  Background:
    Given Open Rail Command application
    When user enters valid credentials
    And user is on the Shipment Tab
    Then user navigates to the shipment monitor page



  Scenario: [Shipment Monitor Edit Transaction]

    Given user selects the first shipment to edit
    When user makes edits to the first shipment
    Then the first shipment is updated successfully

  Scenario: [Shipment Monitor Batch Edit]

    Given the user turns on the Batch Mode toggle from the Batch/Inline tab on Shipment Monitor Page
    When the user selects the first 3 shipments and proceeds to batch update on Shipment Monitor Page
    And the user edits the waybillNumber, error handle value, and error category
    Then the first 3 shipments from Shipment Monitor page should be updated with the new values on the shipment list