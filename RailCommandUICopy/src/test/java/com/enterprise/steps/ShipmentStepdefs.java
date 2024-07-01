package com.enterprise.steps;

import com.enterprise.pages.BasePage;
import com.enterprise.pages.LoginPage;
import com.enterprise.pages.ShipmentPage;
import com.enterprise.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShipmentStepdefs extends BasePage {
    public ShipmentStepdefs() {

        this.login = new LoginPage();
        this.driver = Driver.getDriver();
        this.shipment = new ShipmentPage();
    }

    private WebDriver driver;
    ShipmentPage shipment;
    LoginPage login;
    String expectedBolValue;
    String expectedEquipmentBoxValue;
    String expectedShippedDate;
    String expectedShippedTime;
    String expectedShipmentDateTime;
    String expectedSCACValue;
    String expectedHistoryTabComment;
    int expectedTotalNumberOfShipments;
    List<String> expectedShipmentDateTimes;
    List<String> expectedOriginCityValues;
    List<String> expectedOriginStateValues;
    List<String> expectedDestinationCityValues;
    List<String> expectedDestinationStateValues;
    List<String> expectedBOLValues;
    int actualTotalRecordsOfShipments;
 int numberOfShipments;


    @Then("user selects RSI TEST CLIENT account")
    public void user_selects_rsi_test_client_account() throws InterruptedException {


        login.selectRsiTestClientUser();


    }

    @Given("user starts to create a shipment from shipment page")
    public void user_starts_to_create_a_shipment_from_shipment_page() {
        jsClick(driver, shipment.shipmentDropdown);
        jsClick(driver, shipment.shipmentOption);
        jsClick(driver, shipment.createTab);
    }

    @When("user put {string},{string},{string},")
    public void user_put(String expectedWeightBoxValue, String expectedBolValue, String federalTaxIdNumber) {

        jsClick(driver, shipment.originStation);
        jsClick(driver, shipment.firstOriginStation);
        jsClick(driver, shipment.destinationStation);
        jsClick(driver, shipment.firstDestinationStation);
        jsClick(driver, shipment.patternBox);
        jsClick(driver, shipment.patternOption);
      /*  jsClick(driver,shipment.extendedReferenceTextBox);
        shipment.extendedReferenceTextBox.sendKeys(expectedBolValue);*/
        jsClick(driver, shipment.equipmentBox);
        jsClick(driver, shipment.equipmentSelection);

        expectedEquipmentBoxValue = shipment.equipmentBox.getAttribute("value");
        shipment.weightBox.sendKeys(expectedWeightBoxValue);
        expectedShippedDate = shipment.shippedDateBox.getAttribute("value");
        expectedShippedTime = shipment.shippedTimeBox.getAttribute("value");
        expectedShipmentDateTime = expectedShippedDate + " " + expectedShippedTime;
        System.out.println("expected shipment date and time: " + expectedShipmentDateTime);

        click(driver, shipment.detailsTab);

      /*  expectedSCACValue = shipment.lineHaul.getAttribute("value");
        click(driver, shipment.federalTaxIdNumber);
        shipment.federalTaxIdNumber.sendKeys(federalTaxIdNumber);*/

        click(driver, shipment.reviewBOL);

    }

    @Then("is able to create a shipment")
    public void is_able_to_create_a_shipment() throws InterruptedException {
        click(driver, shipment.createShipmentTab);
        click(driver, shipment.refreshButton);

        Thread.sleep(2000);

        String actualBolValue = shipment.bolBoxShipments.getText();


        String actualEquipmentBoxValue = shipment.equipmentBoxShipments.getText();

        String actualShipmentDateTime = shipment.shippedDateBoxShipments.getText();
        System.out.println("before formatting actual shipment date and time: " + actualShipmentDateTime);

        String actualSCACValue = shipment.scacBoxShipments.getText();


        String formattedActualShipmentDateTime = formatDate(actualShipmentDateTime);
        System.out.println("after formatting actual shipment date and time: " + formattedActualShipmentDateTime);
    }

    //Edit Shipment scenario

    @Given("user opens shipment page")
    public void user_opens_shipment_page() {
        click(driver, shipment.shipmentDropdown);
        click(driver, shipment.shipmentOption);
        numberOfShipments= shipment.NumberOfShipments();
    }

    @When("user selects first shipment to edit")
    public void user_selects_first_shipment_to_edit() {
        click(driver, shipment.firstShipment);
        click(driver, shipment.editShipment);

    }

    @When("user edits shipment from Shipment and Details tab")
    public void user_edits_shipment_from_shipment_and_details_tab() {
        click(driver, shipment.weightQualifierToggleButton);
        click(driver, shipment.weightQualifierSecondOption);

        click(driver, shipment.weightUnitBox);
        click(driver, shipment.weightUnitSecondOption);

        click(driver, shipment.timeZoneBox);
        click(driver, shipment.timeZoneSecondOption);

        click(driver, shipment.editCommentTextBox);
        expectedHistoryTabComment = "Automated test text to validate comment in History section";
        shipment.editCommentTextBox.sendKeys(expectedHistoryTabComment);

        click(driver, shipment.detailsTab);
        click(driver, shipment.shipmentTypeDetailsBox);
        click(driver, shipment.shipmentTypeDetailsBoxSecondOption);
        click(driver, shipment.reviewBOL);
        click(driver, shipment.saveChangesButton);
    }

    @Then("updated shipment appears under History tab")
    public void updated_shipment_appears_under_history_tab() throws InterruptedException {
        click(driver, shipment.firstShipment);
        click(driver, shipment.editShipment);
        click(driver, shipment.historyTab);
        Thread.sleep(4000);
        String actualHistoryTabComment = shipment.firstCommentColumnHistoryTab.getText();
        Assert.assertEquals("History tab comment validation is successful", actualHistoryTabComment, expectedHistoryTabComment);
    }

    //Cancel shipment Scenario
    @When("user selects first shipment from <totalNumberOfShipments> to cancel")
    public void userSelectsFirstShipmentFromTotalNumberOfShipmentsToCancel() {

       numberOfShipments= shipment.NumberOfShipments();
        click(driver, shipment.firstShipment);
        click(driver, shipment.cancelShipment);

    }

    @When("user fill out required fields on Cancel Shipment page")
    public void user_fill_out_required_fields_on_cancel_shipment_page() {
        click(driver, shipment.shipmentCancelationReasonBox);
        click(driver, shipment.shipmentCancelationFourthReason);
        click(driver, shipment.cancelationCommentBox);
        shipment.cancelationCommentBox.sendKeys("Cancellation Automation Test");
        click(driver, shipment.sendCancelationEmailYesCheckBox);

    }

    @Then("canceled shipment does not appear in the shipment list")
    public void canceled_shipment_does_not_appear_in_the_shipment_list() throws InterruptedException {
        click(driver, shipment.cancelShipmentButton);
        int expectedTotalRecordsOfShipments=numberOfShipments-1;
        click(driver,shipment.refreshButton);
        Thread.sleep(1000);
        actualTotalRecordsOfShipments=shipment.NumberOfShipments();
        Assert.assertEquals("Shipment is not cancelled from Shipment Page",expectedTotalRecordsOfShipments,actualTotalRecordsOfShipments);

        System.out.println("Shipment is cancelled successfully from Shipment page");

    }

    //Batch Update Test

    @Given("the user turns on the Batch Mode toggle from the Batch\\/Inline tab")
    public void theUserTurnsOnTheBatchModeToggleFromTheBatchInlineTab() {
        click(driver, shipment.shipmentDropdown);
        click(driver, shipment.shipmentOption);
        click(driver, shipment.batchInlineButton);
        click(driver, shipment.batchModeToggle);
    }

    @When("the user selects the first {int} shipments and proceeds to batch update")
    public void theUserSelectsTheFirstShipmentsAndProceedsToBatchUpdate(int arg0) {
        shipment.selectShipments(3);
        click(driver, shipment.proceedToBatchUpdate);
    }

    @And("the user edits the weight, volume, and shipped date")
    public void theUserEditsTheWeightVolumeAndShippedDate() throws InterruptedException {
        click(driver, shipment.weightCheckBox);
        click(driver, shipment.weightBox);
        shipment.weightBox.sendKeys("5000");
        click(driver, shipment.shippedDateCheckBox);
        click(driver, shipment.shippedCalendarToggle);
        click(driver, shipment.shippedYesterdaysDate);
        expectedShippedDate = shipment.shippedDateBox.getAttribute("value");
        expectedShippedTime = shipment.shippedTimeBox.getAttribute("value");
        expectedShipmentDateTime = expectedShippedDate + " " + expectedShippedTime;

        System.out.println(expectedShipmentDateTime);

        click(driver, shipment.saveChangesButton);
        Thread.sleep(3000);
    }

    @Then("the first {int} shipments should be updated with the new values on the shipment list")
    public void theFirstShipmentsShouldBeUpdatedWithTheNewValuesOnTheShipmentList(int arg0) throws InterruptedException {
        click(driver, shipment.refreshButton);


        List<String> formattedActualShipmentDateTime = shipment.selectActualShippedDates(3);


        for (String actualShipmentDateTime : formattedActualShipmentDateTime) {
            System.out.println("actual shipment date and time in order " + actualShipmentDateTime);

            // Assert that the actual shipment date and time matches the expected shipment date and time
            Assert.assertEquals("Batch edit validation is not successful", actualShipmentDateTime, expectedShipmentDateTime);

        }
    }
    //Batch cancellation scenario

    @When("the user selects the first {int} shipments and proceeds to batch cancellation")
    public void theUserSelectsTheFirstShipmentsAndProceedsToBatchCancellation(int i) {

        expectedTotalNumberOfShipments = shipment.NumberOfShipments();

        shipment.selectShipments(i);

        List<String> listOfSelectedShipments = shipment.selectExpectedShippedDates(3);

        for (String item : listOfSelectedShipments) {
            System.out.println(item);
        }

        click(driver, shipment.proceedToBatchCancellation);
    }


    @Then("the total number of shipments recorded decreases by {int} on the shipments page")
    public void theTotalNumberOfShipmentsRecordedDecreasesByOnTheShipmentsPage(int i) throws InterruptedException {

        click(driver, shipment.cancelShipmentsBatch);
        click(driver, shipment.refreshButton);
        Thread.sleep(5000);
        int actualNumberOfShipments = shipment.NumberOfShipments();
        Assert.assertEquals((expectedTotalNumberOfShipments - i), actualNumberOfShipments);
        System.out.println("Shipment batch cancellation is successful");


    }

    //Inline Edit
    @Given("the user turns on the Inline Edit toggle from the Batch\\/Inline tab")
    public void theUserTurnsOnTheInlineEditToggleFromTheBatchInlineTab() {
        click(driver, shipment.shipmentDropdown);
        click(driver, shipment.shipmentOption);
        click(driver, shipment.batchInlineButton);
        click(driver, shipment.inlineEditingToggle);
    }

    @When("the user selects the first {int} shipments and updates shipped date, BOL, origin city, origin state, destination city,destination state for selected shipments")
    public void theUserSelectsTheFirstShipmentsAndUpdatesShippedDateBOLOriginCityOriginStateDestinationCityDestinationStateForSelectedShipments(int arg0) {
        shipment.selectShipments(3);
        expectedShipmentDateTimes = shipment.fillOutExpectedShippedDates(3);

        expectedBOLValues = shipment.fillOutExpectedBOLValues("inline edit", 3);
        expectedOriginCityValues = shipment.fillOutExpectedOriginCityValues("Atlanta", 3);
        expectedOriginStateValues = shipment.fillOutExpectedOriginStateValues("GA", 3);
        expectedDestinationCityValues = shipment.fillOutExpectedDestinationCityValues("Chicago", 3);
        expectedDestinationStateValues = shipment.fillOutExpectedDestinationStateValues("IL", 3);
    }

    @And("submits inline edit")
    public void submitsInlineEdit() {
        click(driver, shipment.submitInlineEditButton);
        click(driver, shipment.submitButton);
    }

    @Then("the first {int} shipments values should be updated with the new values on the shipment list")
    public void theFirstShipmentsValuesShouldBeUpdatedWithTheNewValuesOnTheShipmentList(int arg0) {

        // Get formatted actual shipment date times
        List<String> formattedActualShipmentDateTimes = shipment.selectActualShippedDates(3);

        for (String each : formattedActualShipmentDateTimes) {
            System.out.println(each);
        }

// Assert each actual shipment date time against each expected shipment date time
        for (String actualItem : formattedActualShipmentDateTimes) {
            for (String expectedItem : expectedShipmentDateTimes) {

                Assert.assertEquals("Inline edit is not successful.DateTime is not matching", expectedItem, actualItem);
            }
        }

        // Get actual BOL values
        List<String> actualBOLValues = new ArrayList<>();

        for (int i = 1; i <= expectedBOLValues.size(); i++) {
            actualBOLValues.add(shipment.shipmentBOLValueList.get(i).getText());
        }

// Assert each actual BOL value against each expected BOL value
        for (String actualItem : actualBOLValues) {
            for (String expectedItem : expectedBOLValues) {
                Assert.assertEquals("Inline edit is not successful.BOLValue is not matching", expectedItem, actualItem);
            }
        }

        // Get actual origin city values
        List<String> actualOriginCityValues = new ArrayList<>();
        for (int i = 1; i <= expectedOriginCityValues.size(); i++) {
            actualOriginCityValues.add(shipment.shipmentOriginCityValueList.get(i).getText());
        }

// Assert each actual origin city value against each expected origin city value
        for (String actualItem : actualOriginCityValues) {
            for (String expectedItem : expectedOriginCityValues) {
                Assert.assertEquals("Inline edit is not successful.OriginCity is not matching", expectedItem, actualItem);
            }
        }


    }


  // Download NOL Action/Process from Shipment page

    @When("the user selects the first shipment to download BOL")
    public void theUserSelectsTheFirstShipmentToDownloadBOL() throws InterruptedException {
        click(driver, shipment.firstShipment);
        click(driver, shipment.downloadBOLasPDF);
        Thread.sleep(3000);

    }


    @Then("the user is able to download the file in pdf format")
    public void theUserIsAbleToDownloadTheFileInPdfFormat() throws Exception {
        Assert.assertTrue("Downloaded file is not pdf format",downladPDFfile(".pdf"));
    }

    @Then("the downloaded file is deleted from download folder")
    public void theDownloadedFileIsDeletedFromDownloadFolder() throws Exception {
        Thread.sleep(3000);
        deleteDownloadFile();
    }
}
