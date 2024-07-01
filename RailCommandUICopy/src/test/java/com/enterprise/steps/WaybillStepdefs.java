package com.enterprise.steps;

import com.enterprise.pages.BasePage;
import com.enterprise.pages.LoginPage;
import com.enterprise.pages.ShipmentPage;
import com.enterprise.pages.WaybillPage;
import com.enterprise.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WaybillStepdefs extends BasePage {

    public WaybillStepdefs(){

       this.login=new LoginPage();
        this.driver= Driver.getDriver();
        this.shipment= new ShipmentPage();
        this.waybill=new WaybillPage();
    }
    private WebDriver driver;
    ShipmentPage shipment;
    LoginPage login;
    WaybillPage waybill;
    String expectedWaybillShipmentDateTime;
    String actualTotalRecordsOfWaybill;
    int numberOfShipments;




    @Given("user selects Diamond Green Diesel user")
    public void userSelectsDiamondGreenDieselUser() throws InterruptedException {
        System.out.println("selecting Diamond Green Diesel user");
        login.selectDiamondGreenDieselClientUser();
    }

    @And("user is on waybill page")
    public void userIsOnWaybillPage() {
        click(driver,shipment.shipmentDropdown);
        click(driver,waybill.waybillOption);

    }

    @When("user creates a shipment from the first waybill of the waybills list")
    public void userCreatesAShipmentFromTheFirstWaybillOfTheWaybillsList() {
        actualTotalRecordsOfWaybill=waybill.totalRecordOfWaybill.getText();
        click(driver,waybill.firstRowButtonWaybill);
       click(driver,waybill.viewWaybill);
       click(driver,waybill.createShipmentButtonWaybill);
       click(driver,waybill.patternBoxWaybill);
       click(driver,waybill.firstOptionPatternBoxWaybill);

       click(driver,waybill.commodityBoxWaybill);
       click(driver,waybill.firstOptionCommodityBoxWaybill);

        String expectedWaybillShippedDate = shipment.shippedDateBox.getAttribute("value");
        String expectedWaybillShippedTime = shipment.shippedTimeBox.getAttribute("value");
        expectedWaybillShipmentDateTime = expectedWaybillShippedDate + " " + expectedWaybillShippedTime;
        System.out.println("expected waybill shipment date and time =" +expectedWaybillShipmentDateTime);

        click(driver,shipment.reviewBOL);
        click(driver,shipment.createShipmentTab);
        }

    @Then("new shipment displays on shipment page")
    public void newShipmentDisplaysOnShipmentPage() {
        click(driver,shipment.shipmentOption);
        String actualShipmentDateTime = shipment.shippedDateBoxShipments.getText();
        System.out.println("before formatting actual shipment date and time: " + actualShipmentDateTime);
        String formattedActualShipmentDateTime=formatDate(actualShipmentDateTime);

        Assert.assertEquals("waybill was not created",expectedWaybillShipmentDateTime,formattedActualShipmentDateTime);

        System.out.println("waybill shipment is successfully created");



    }



    // Batch Create Shipments
    @Given("the user opens the Configure tab and adds Shipment as an additional column")
    public void theUserOpensTheConfigureTabAndAddsShipmentAsAnAdditionalColumn() throws InterruptedException {
        click(driver,shipment.shipmentOption);
        numberOfShipments=shipment.NumberOfShipments();


        click(driver,waybill.waybillOption);
        click(driver, waybill.configureTab);
        click(driver,waybill.removeAllButton);
        click(driver,waybill.applyButton);
        click(driver,waybill.searchColumnBox);
        waybill.searchColumnBox.sendKeys("Shipment",Keys.ENTER);
        click(driver,waybill.addSelectedButton);
        click(driver,waybill.applyButton);
        click(driver, waybill.configureTab);



    }

    @When("the user defines shipment values as {string}")
    public void theUserDefinesShipmentValuesAs(String arg0) {
        waybill.shipmentFilter.sendKeys("No",Keys.ENTER);

    }

    @And("the user turns on the Batch Mode toggle from the Batch\\/Inline tab and selects the first {int} shipments, then proceeds to batch create Shipments")
    public void theUserTurnsOnTheBatchModeToggleFromTheBatchInlineTabAndSelectsTheFirstShipmentsThenProceedsToBatchCreateShipments(int i) {
        click(driver,shipment.batchInlineButton);
        click(driver,shipment.batchModeToggle);
        shipment.selectShipments(i);
        click(driver,waybill.batchCreateShipments);

    }

    @When("the user creates new shipments")
    public void theUserCreatesNewShipments() throws InterruptedException {
        jsClick(driver, shipment.originStation);
        jsClick(driver, shipment.firstOriginStation);
        jsClick(driver, shipment.destinationStation);
        jsClick(driver, shipment.firstDestinationStation);
        jsClick(driver, shipment.patternBox);
        jsClick(driver, shipment.patternOption);
        jsClick(driver,shipment.comodityBox);
        jsClick(driver,shipment.firstComodityItem);
        jsClick(driver,waybill.createShipmentsButton);
        Thread.sleep(1000);

    }

    @Then("the new shipments should display on the shipment page")
    public void theNewShipmentsShouldDisplayOnTheShipmentPage() throws InterruptedException {

        click(driver,shipment.shipmentOption);
        Thread.sleep(1000);


        int actualNumberOfShipments=shipment.NumberOfShipments();

        int expectedNumberOfShipments=numberOfShipments+2;
        Assert.assertEquals("Batch create shipments from waybill is not successful ",expectedNumberOfShipments,(actualNumberOfShipments+1));

        System.out.println("Batch create shipments from waybill is successful");

    }

    @Given("user selects to inactivate the first row of waybill list")
    public void userSelectsToInactivateTheFirstRowOfWaybillList() {
        click(driver,waybill.firstRowButtonWaybill);
        click(driver,waybill.inactivateWaybill);
        click(driver,waybill.inactivateWaybillModalButton);
        click(driver,shipment.refreshButton);
    }

    @Then("user is able to inactivate the waybill")
    public void userIsAbleToInactivateTheWaybill() {
        String expectedTotalRecordsOfWaybill = waybill.totalRecordOfWaybill.getText();
        Assert.assertNotEquals("waybill can not be inactivated",expectedTotalRecordsOfWaybill,actualTotalRecordsOfWaybill);
        System.out.println("waybill is successfully inactivated");
    }




}
