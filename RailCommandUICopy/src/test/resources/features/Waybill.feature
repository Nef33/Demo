Feature: Waybill feature

  Testing waybill page

  Background:
    Given Open Rail Command application
    When user enters valid credentials
    And user selects Diamond Green Diesel user
    Then user is on waybill page


  Scenario: [Shipment creation from waybill]
    Given user creates a shipment from the first waybill of the waybills list

    Then new shipment displays on shipment page

  Scenario: Inactivating waybill
    Given user selects to inactivate the first row of waybill list
    Then user is able to inactivate the waybill


  Scenario: Batch Create Shipments from Waybill
    Given the user opens the Configure tab and adds Shipment as an additional column
    When the user defines shipment values as "No"
    And the user turns on the Batch Mode toggle from the Batch/Inline tab and selects the first 2 shipments, then proceeds to batch create Shipments
    When the user creates new shipments
    Then the new shipments should display on the shipment page