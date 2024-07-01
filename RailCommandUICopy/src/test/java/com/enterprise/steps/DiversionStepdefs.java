package com.enterprise.steps;

import com.enterprise.pages.BasePage;
import com.enterprise.pages.DiversionPage;
import com.enterprise.pages.LoginPage;
import com.enterprise.pages.ShipmentPage;
import com.enterprise.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class DiversionStepdefs extends BasePage {
    Logger logger = Logger.getLogger(this.getClass().getName());
    DiversionPage diversion;
    ShipmentPage shipment;
    LoginPage login;
    String expectedStatus;
    String expectedNote;
    int actualNumberOfRecords;
    private WebDriver driver;

    public DiversionStepdefs() {


        this.login = new LoginPage();
        this.driver = Driver.getDriver();
        this.shipment = new ShipmentPage();
        this.diversion = new DiversionPage();

    }

    @Given("user opens diversion page")
    public void user_opens_diversion_page() {
        click(driver, shipment.shipmentDropdown);
        click(driver, diversion.diversionOption);

    }

    @When("user creates a diversion")
    public void userCreatesADiversion() throws InterruptedException {

        actualNumberOfRecords = diversion.NumberOfRecords();
        click(driver, shipment.createTab);
        click(driver, diversion.carrierBox);
        expectedStatus = "ABC (Atlantic Bulk Carrier)";
        for (WebElement each : diversion.carrierList) {
            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                each.click();
            }
        }

        click(driver, diversion.freightTermsBox);
        expectedStatus = "Prepaid";
        for (WebElement each : diversion.freightTermsList) {
            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                each.click();
            }
        }

        click(driver, diversion.loadedEmptyBox);
        expectedStatus = "Loaded";
        for (WebElement each : diversion.loadedEmptyList) {
            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                each.click();
            }
        }

        click(driver, diversion.comodityBox);
        expectedStatus = "Canola oil";
        for (WebElement each : diversion.comodityList) {
            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                each.click();
            }

        }

        click(driver, diversion.statusBox);
        expectedStatus = "Submitted";
        for (WebElement each : diversion.statusList) {
            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                each.click();
            }

        }

        click(driver, diversion.addEquipmentBox);
        sendKeys(diversion.addEquipmentBox, "NEF1234567");
        jsClick(driver, diversion.addEquipmentButton);


        click(driver, diversion.partyBox);
        expectedStatus = "BARSTOW (atlanta, CA)";
        for (WebElement each : diversion.partyList) {
            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                each.click();
            }

        }


        click(driver, diversion.termsOfUSe);
        diversion.acceptCheckBox.isDisplayed();
        jsClick(driver, diversion.acceptCheckBox);
        click(driver, diversion.saveChangesButton);

    }

    @Then("new diversion appears on the first row of Diversions page")
    public void newDiversionAppearsOnTheFirstRowOfDiversionsPage() throws InterruptedException {
        Thread.sleep(2000);
        click(driver, shipment.refreshButton);
        int expectedNumberOfRecords = diversion.NumberOfRecords();


        Assert.assertEquals("Diversion was not created", expectedNumberOfRecords, (actualNumberOfRecords + 1));


    }

    //Edit Diversion
    @When("user selects first diversion to edit")
    public void user_selects_first_diversion_to_edit() {
        click(driver, diversion.firstDiversionArrow);
        click(driver, diversion.editButton);

    }

    @When("user edits shipment from Edit Diversion tab")
    public void user_edits_shipment_from_edit_diversion_tab() throws InterruptedException {

        click(driver, diversion.clearStatusButton);
        click(driver, diversion.statusBox);

        expectedStatus = "Completed";
        for (WebElement each : diversion.statusList) {

            if (each.getText().equalsIgnoreCase(expectedStatus)) {
                jsClick(driver, each);
                break;
            }
        }
        click(driver, diversion.noteBox);
        expectedNote = "Diversion is edited";
        sendKeys(diversion.noteBox, expectedNote);
        click(driver, diversion.termsOfUSe);
        diversion.acceptCheckBox.isDisplayed();
        jsClick(driver, diversion.acceptCheckBox);
        click(driver, diversion.saveChangesButton);

    }

    @Then("updated diversion appears with new values on the first row of Diversions page")
    public void updated_diversion_appears_with_new_values_on_the_first_row_of_diversions_page() throws InterruptedException {
        Thread.sleep(2000);
        String actualStatus = diversion.firstStatusValue.getText();
        Assert.assertEquals("Status is not equal", expectedStatus, actualStatus);

        String actualNote = diversion.firstLastNoteValue.getText();
        Assert.assertEquals("Note is not same", expectedNote, actualNote);

    }


}
