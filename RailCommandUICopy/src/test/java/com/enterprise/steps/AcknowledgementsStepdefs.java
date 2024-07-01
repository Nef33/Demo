package com.enterprise.steps;

import com.enterprise.pages.*;
import com.enterprise.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class AcknowledgementsStepdefs extends BasePage {

    public AcknowledgementsStepdefs() {

        this.login = new LoginPage();
        this.driver = Driver.getDriver();
        this.shipment = new ShipmentPage();
        this.waybill = new WaybillPage();
        this.acknowledgements= new AcknowledgementsPage();
    }

    private WebDriver driver;
    ShipmentPage shipment;
    LoginPage login;
    WaybillPage waybill;

    AcknowledgementsPage acknowledgements;
    String actualComment="Acknowledgement edit shipment test";
    String expectedOriginState;
    String expectedOriginCity;
    int actualTotalRecordsOfShipments;
    int numberOfShipments;


    @Then("user is on acknowledgement page")
    public void user_is_on_acknowledgement_page() {

        click(driver,shipment.shipmentDropdown);
        click(driver,acknowledgements.acknowledgementsOption);
    }

    @Given("user selects the first shipment to edit on acknowledgement page")
    public void user_selects_the_first_shipment_to_edit_on_acknowledgement_page() {
            click(driver, shipment.firstShipment);
            click(driver,acknowledgements.editShipment);

    }

    @When("user edits {string},{string},{string},shipped date, commentBox")
    public void user_edits_shipped_date_comment_box(String expectedWeight, String expectedOriginState, String expectedOriginCity) throws InterruptedException {
    this.expectedOriginCity=expectedOriginCity;
    this.expectedOriginState=expectedOriginState;

        click(driver,shipment.weightBox);
        sendKeys(shipment.weightBox,expectedWeight);


        click(driver, shipment.shippedCalendarToggle);
        jsClick(driver, shipment.shippedTodaysDate);

        click(driver,shipment.editCommentTextBox);
        sendKeys(shipment.editCommentTextBox,actualComment);

        click(driver,shipment.detailsTab);
        click(driver,shipment.originCityBox);
        jsClear(driver,shipment.originCityBox);
        sendKeys(shipment.originCityBox,expectedOriginCity);



        click(driver,shipment.reviewBOL);
        click(driver,shipment.saveChangesButton);

    }

    @Then("the first shipment is updated successfully on History Tab in acknowledgement page")
    public void the_first_shipment_is_updated_successfully_on_history_tab_in_acknowledgement_page() throws InterruptedException {

        click(driver, waybill.configureTab);
        click(driver,waybill.removeAllButton);
        click(driver,waybill.applyButton);
        click(driver,waybill.searchColumnBox);
        waybill.searchColumnBox.sendKeys("Origin City", Keys.ENTER);


        click(driver,waybill.addSelectedButton);
        click(driver,waybill.applyButton);
        click(driver,waybill.configureTab);
        Thread.sleep(2000);

        String actualOriginCity=shipment.firstOriginCityColumn.getText();


        Assert.assertEquals(expectedOriginCity,actualOriginCity);



        click(driver, shipment.firstShipment);
        click(driver,acknowledgements.editShipment);
        click(driver,shipment.historyTab);
        click(driver,shipment.firstCommentColumnHistoryTab);
        String expectedComment=shipment.firstCommentColumnHistoryTab.getText();

        Assert.assertEquals("Shipment edit from acknowledgement page is not successful",expectedComment,actualComment);


    }

 //Cancel shipment from Acknowledgement page
    @And("user selects RICHARDSON INTERNATIONAL account")
    public void userSelectsRICHARDSONINTERNATIONALAccount() throws InterruptedException {
       login.selectRichardsonInternationalTestClientUser();
    }

    @Given("the user selects Shipment Status Type as {string}")
    public void theUserSelectsShipmentStatusTypeAs(String arg0) throws InterruptedException {
        scrollIntoView(driver,shipment.shipmentStatusTypeFilterButton);
        click(driver,shipment.shipmentStatusTypeFilterButton);
        click(driver,shipment.shipmentStatusTypeShippedOption);

        Thread.sleep(1000);
        numberOfShipments=shipment.NumberOfShipments();

    }


    @Then("shipment is cancelled and the total record of shipments is updated")
    public void shipmentIsCancelledAndTheTotalRecordOfShipmentsIsUpdated() throws InterruptedException {
        click(driver,shipment.cancelShipmentButton);

        int expectedTotalRecordsOfShipments=numberOfShipments-1;
        click(driver,shipment.refreshButton);
        Thread.sleep(3000);
        actualTotalRecordsOfShipments=shipment.NumberOfShipments();
        Assert.assertEquals("Shipment is not cancelled from Acknowledgement Page",expectedTotalRecordsOfShipments,actualTotalRecordsOfShipments);

        System.out.println("Shipment is cancelled successfully from Acknowledgement page");
    }
}
