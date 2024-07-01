Feature: Shipment

  This feature is creating,editing and canceling shipments

  Background:

    Given Open Rail Command application
    When user enters valid credentials
    Then user is able to login
    Then user selects RSI TEST CLIENT account

  Scenario: 01 Cancel Shipment

    Given user opens shipment page
    When user selects first shipment from <totalNumberOfShipments> to cancel
    And user fill out required fields on Cancel Shipment page
    Then canceled shipment does not appear in the shipment list


  Scenario: 02 Edit Shipment


    Given user opens shipment page
    When user selects first shipment to edit
    And user edits shipment from Shipment and Details tab
    Then updated shipment appears under History tab


  Scenario Outline: 03 Shipment Creation


    Given user starts to create a shipment from shipment page
    When user put <weightBoxValue>,<bolValue>,<federalTaxIdNumber>,
    Then is able to create a shipment
    Examples:
      | weightBoxValue | bolValue | federalTaxIdNumber |
      | "5000"         | "text1"  | "787890"           |
      | "8900"         | "TEXT2!" | "0973480"          |


  Scenario:04 Batch Update

    Given the user turns on the Batch Mode toggle from the Batch/Inline tab
    When the user selects the first 3 shipments and proceeds to batch update
    And the user edits the weight, volume, and shipped date
    Then the first 3 shipments should be updated with the new values on the shipment list

  Scenario: 05 Batch Cancellation

    Given the user turns on the Batch Mode toggle from the Batch/Inline tab
    When the user selects the first 3 shipments and proceeds to batch cancellation
    And user fill out required fields on Cancel Shipment page
    Then  the total number of shipments recorded decreases by 3 on the shipments page


  Scenario:06 Inline Edit

    Given the user turns on the Inline Edit toggle from the Batch/Inline tab
    When the user selects the first 3 shipments and updates shipped date, BOL, origin city, origin state, destination city,destination state for selected shipments
    And submits inline edit
    Then the first 3 shipments values should be updated with the new values on the shipment list

  Scenario: Download BOL Action/Process from Shipment page

    Given user opens shipment page
    When the user selects the first shipment to download BOL
    Then the user is able to download the file in pdf format
    Then the downloaded file is deleted from download folder