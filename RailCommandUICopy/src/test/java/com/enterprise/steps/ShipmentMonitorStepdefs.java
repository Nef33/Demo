package com.enterprise.steps;


import com.enterprise.pages.*;
import com.enterprise.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ShipmentMonitorStepdefs extends BasePage {

    private WebDriver driver;
    ShipmentPage shipment;
    ShipmentMonitorPage shipmentMonitor;
    public ShipmentMonitorStepdefs(){
        Logger logger = Logger.getLogger(this.getClass().getName());

        this.driver= Driver.getDriver();
        this.shipment= new ShipmentPage();
        this.shipmentMonitor=new ShipmentMonitorPage();

    }

    @And("user is on the Shipment Tab")
    public void userIsOnTheShipmentTab() {

        click(driver,shipment.shipmentDropdown);
    }

    @Then("user navigates to the shipment monitor page")
    public void userNavigatesToTheShipmentMonitorPage() {
        click(driver,shipmentMonitor.shipmentMonitorOption);
    }

    @Given("user selects the first shipment to edit")
    public void userSelectsTheFirstShipmentToEdit() {
        click(driver,shipment.firstShipment);
        click(driver,shipmentMonitor.editTransactionButton);
    }
    String expectedWaybillNumber = "2024";
    @When("user makes edits to the first shipment")
    public void userMakesEditsToTheFirstShipment() {
        // edits waybillNumberBox
        click(driver,shipmentMonitor.waybillNumberBox);
        jsClear(driver,shipmentMonitor.waybillNumberBox);
        shipmentMonitor.waybillNumberBox.sendKeys(expectedWaybillNumber);
        click(driver,shipmentMonitor.errorCategoryIdBox);

        for (int i = 0; i < shipmentMonitor.errorCategoryIdOptions.size(); i++)

        {
            if (i == 4)
            {

                shipmentMonitor.errorCategoryIdOptions.get(i).click();


            }

        }
        click(driver,shipmentMonitor.noteBox);
        shipmentMonitor.noteBox.sendKeys("Shipment Monitor Edit Transaction Automation Test");
        click(driver,shipment.saveChangesButton);
    }

    @Then("the first shipment is updated successfully")
    public void theFirstShipmentIsUpdatedSuccessfully() {
        String actualWaybillNumber=shipmentMonitor.firstWaybillColumnBox.getText();
        Assert.assertEquals("Shipment is not updated",expectedWaybillNumber,actualWaybillNumber);
        System.out.println("Shipment is on Shipment Monitor page is successfully updated");

    }


    //Batch Edit from Shipment Monitor page
    @Given("the user turns on the Batch Mode toggle from the Batch\\/Inline tab on Shipment Monitor Page")
    public void theUserTurnsOnTheBatchModeToggleFromTheBatchInlineTabOnShipmentMonitorPage() {
        click(driver,shipment.batchInlineButton);
        click(driver,shipment.batchModeToggle);
    }

    @When("the user selects the first {int} shipments and proceeds to batch update on Shipment Monitor Page")
    public void theUserSelectsTheFirstShipmentsAndProceedsToBatchUpdateOnShipmentMonitorPage(int arg0) {
        shipment.selectShipments(3);
        click(driver,shipmentMonitor.proceedToBatchUpdate);
    }

    @And("the user edits the waybillNumber, error handle value, and error category")
    public void theUserEditsTheWaybillNumberErrorHandleValueAndErrorCategory() {
    click(driver,shipmentMonitor.waybillNumberCheckBox);
    click(driver,shipmentMonitor.waybillNumberBox);
    shipmentMonitor.waybillNumberBox.sendKeys(expectedWaybillNumber);

    click(driver,shipmentMonitor.errorHandledCheckBox);
    click(driver,shipmentMonitor.errorHandledYesButton);

    click(driver,shipmentMonitor.errorCategoryCheckBox);
    click(driver,shipmentMonitor.errorCategoryIdBox);

        for (int i = 0; i < shipmentMonitor.errorCategoryIdOptions.size(); i++)

        {
            if (i == 4)
            {

                shipmentMonitor.errorCategoryIdOptions.get(i).click();


            }

        }

        click(driver,shipmentMonitor.noteCheckBox);
        click(driver,shipmentMonitor.noteBox);
        shipmentMonitor.noteBox.sendKeys("Shipment Monitor Edit Transaction Automation Test");
        click(driver,shipment.saveChangesButton);
    }

    @Then("the first {int} shipments from Shipment Monitor page should be updated with the new values on the shipment list")
    public void theFirstShipmentsFromShipmentMonitorPageShouldBeUpdatedWithTheNewValuesOnTheShipmentList(int arg0) {
    String actualWaybillNumber=shipmentMonitor.firstWaybillColumnBox.getText();
    Assert.assertEquals("shipment monitor batch update is not successful",expectedWaybillNumber,actualWaybillNumber);
        System.out.println("Shipment batch edit is successful on Shipment Monitor page");


    }

}
