Feature: Acknowledgements feature

  Testing acknowledgements page

  Background:

    Given Open Rail Command application
    When user enters valid credentials



  Scenario Outline: Outline: Acknowledgements Edit Shipment

    And user selects RSI TEST CLIENT account
    Then user is on acknowledgement page

    Given user selects the first shipment to edit on acknowledgement page
    When user edits <weight>,<originState>,<originCity>,shipped date, commentBox
    Then the first shipment is updated successfully on History Tab in acknowledgement page

    Examples:
      | weight   | originState | originCity    |
      | "909"    | "IL" | "PARK RIDGE"  |
      | "675889" | "MI"    | "GRAND RAPIS" |


  Scenario: Acknowledgements Cancel Shipment

    And user selects RICHARDSON INTERNATIONAL account
    Then user is on acknowledgement page

    Given the user selects Shipment Status Type as "Shipped"
    When user selects first shipment from <totalNumberOfShipments> to cancel
    And user fill out required fields on Cancel Shipment page
    Then shipment is cancelled and the total record of shipments is updated



