package com.enterprise.pages;


import com.enterprise.utility.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShipmentPage extends BasePage{

    public ShipmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[@data-testid='Shipments-nav-group']")
    public WebElement shipmentDropdown;
    @FindBy(linkText = "Shipments")
    public WebElement shipmentOption;

    @FindBy(linkText = "Create")
    public WebElement createTab;

    @FindBy(id = "patternOrigin")
    public WebElement originStation;

    @FindBy(id = "patternDestination")
    public WebElement destinationStation;

    @FindBy(xpath = "//div[@id='patternOrigin-menu']/div/ul/li[contains(normalize-space(), 'atlanta, CA')]")
    public WebElement atlantaOption;
    @FindBy(id ="patternOrigin-item-0")
    public WebElement firstOriginStation;

    @FindBy(xpath = "//div[@id='patternDestination-menu']/div/ul/li[contains(normalize-space(), 'CHICAGO, SL')]")
    public WebElement chicagoSLOption;
    @FindBy(id = "patternDestination-item-0")
    public WebElement firstDestinationStation;

    @FindBy(id = "patternId")
    public WebElement patternBox;

    @FindBy(id = "patternId-item-0")
    public WebElement patternOption;

    @FindBy(xpath = "//div[@class='ValidationFeedback_validation-feedback-wrapper__k7NYk']/div/input[@id='shipmentExtendedReferences[0].referenceText']")
    public WebElement extendedReferenceTextBox;

    @FindBy(id = "shipmentEquipments[0].equipmentCode")
    public WebElement equipmentBox;

    @FindBy(id = "shipmentEquipments[0].equipmentCode-item-0")
    public WebElement equipmentSelection;

    @FindBy(id = "shipmentEquipments[0].weight")
    public WebElement weightBox;

    @FindBy(id = "commodityId")
    public WebElement comodityBox;
    @FindBy(xpath ="//*[@id='commodityId-menu']/div/ul/li[1]")
    public WebElement firstComodityItem;
    @FindBy(name = "submitButton")
    public WebElement reviewBOL;

    @FindBy(xpath = "//button[normalize-space()='Create Shipment']")
    public WebElement createShipmentTab;

    @FindBy(xpath = "//div[@row-index='0']/div[@col-id='shipped']")
    public WebElement shippedDateBoxShipments;

    @FindBy(xpath = "//div[@row-index='0']/div[@col-id='bol']")
    public WebElement bolBoxShipments;

    @FindBy(xpath = "//div[@row-index='0']/div[@col-id='equipmentCode']")
    public WebElement equipmentBoxShipments;

    @FindBy(xpath = "//div[@row-index='0']/div[@col-id='weight']")
    public WebElement weightBoxShipments;

    @FindBy(xpath = "//div[@row-index='0']/div[@col-id='scac']")
    public WebElement scacBoxShipments;

    @FindBy(id = "shipped-date")
    public WebElement shippedDateBox;

    @FindBy(id = "shipped-time")
    public WebElement shippedTimeBox;

    @FindBy(id ="additional-info-nav-item")
    public WebElement detailsTab;

    @FindBy(id = "shipmentParties[2].federalTaxpayerId")
    public WebElement federalTaxIdNumber;

    @FindBy(id = "route-line-haul")
    public WebElement lineHaul;

    @FindBy(xpath = "//*[text()='Refresh']")
    public WebElement refreshButton;

    @FindBy(xpath = "//button[@data-testid='action-menu-toggle-0']")
    public WebElement firstShipment;

    @FindBy(xpath = "//a[text()='Edit 'and text()='Shipment']")
    public WebElement editShipment;

    @FindBy(xpath = "//a[text()='Cancel 'and text()='Shipment']")
    public WebElement cancelShipment;


    @FindBy(xpath = "//button[text()='Download BOL as PDF']")
    public WebElement downloadBOLasPDF;

    @FindBy(id = "weightQualifierId-toggle-button")
    public WebElement weightQualifierToggleButton;

    @FindBy(id = "weightQualifierId-item-1")
    public WebElement weightQualifierSecondOption;

    @FindBy(id = "weightUnitId")
    public WebElement weightUnitBox;
    @FindBy(id = "originCity")
    public WebElement originCityBox;

    @FindBy(id = "originState")
    public WebElement originStateBox;

    @FindBy(xpath = "//li[@id='weightUnitId-item-1']")
    public WebElement weightUnitSecondOption;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[2]")
    public WebElement extendedReferenceBox;

    @FindBy(id = "timeZoneId")
    public WebElement timeZoneBox;

    @FindBy(id = "timeZoneId-item-1")
    public WebElement timeZoneSecondOption;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[2]")
    public WebElement additionalInstructionsTextBox;

    @FindBy(id = "shipmentEvent.comment")
    public WebElement editCommentTextBox;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[2]")
    public WebElement billingTypeDetailsBox;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[2]")
    public WebElement weightTypeDetailsBox;

    @FindBy(id = "shipmentTypeId")
    public WebElement shipmentTypeDetailsBox;

    @FindBy(id = "shipmentTypeId-item-1")
    public WebElement shipmentTypeDetailsBoxSecondOption;

    @FindBy(xpath = "//*[text()='Save Changes']")
    public WebElement saveChangesButton;

    @FindBy(id = "history-nav-item")
    public WebElement historyTab;

    @FindBy(xpath = "(//div[@col-id='comment'])[2]")
    public WebElement firstCommentColumnHistoryTab;
    @FindBy(xpath = "(//div[@col-id='originCity'])[2]")
    public WebElement firstOriginCityColumn;
    @FindBy(xpath = "(//div[@col-id='originStae'])[2]")
    public WebElement firstOriginStateColumn;

    @FindBy(id = "shipmentStatusType-quick-filter-toggle-button")
    public WebElement shipmentStatusTypeFilterButton;
    @FindBy(xpath = "//div/ul/li/span[contains(text(), 'Shipped')]")
    public WebElement shipmentStatusTypeShippedOption;

    @FindBy(id = "shipmentEvent.shipmentCancellationReasonId")
    public WebElement shipmentCancelationReasonBox;

    @FindBy(id = "shipmentEvent.comment")
    public WebElement cancelationCommentBox;

    @FindBy(id = "shipmentEvent.sendEmail-Yes")
    public WebElement sendCancelationEmailYesCheckBox;

    @FindBy(id = "shipmentEvent.sendEmail-No")
    public WebElement sendCancelationEmailNoCheckBox;

    @FindBy(xpath = "//div[@id='shipmentEvent.shipmentCancellationReasonId-menu']/div/ul/li[4]")
    public WebElement shipmentCancelationFourthReason;

    @FindBy(xpath = "//button[text()='Cancel Shipment']")
    public WebElement cancelShipmentButton;


    @FindBy(xpath = "//input[@class='GridBatchCheckbox_checkbox__fDDYU']")
    public List<WebElement> shipmentCheckBoxList;

    // Selecting shipments by clicking checkboxes
    public void selectShipments(int numberOfShipments) {
        for (int i = 1; i < numberOfShipments+1; i++) {
            shipmentCheckBoxList.get(i).click();
        }
    }

    // Finding shipment shipped dates
    @FindBy(xpath = "//div[@col-id='shipped']")
    public List<WebElement> shipmentShippedDateList ;

    // Selecting actual shipped dates
    public List<String> selectActualShippedDates(int numberOfShippedDates) {
        List<String> formattedActual = new ArrayList<>();
        for (int i = 1; i < numberOfShippedDates+1; i++) {
            shipmentShippedDateList.get(i).click();
            String actualShipmentDateTime = shipmentShippedDateList.get(i).getText();
            String formattedActualShipmentDate = formatDate(actualShipmentDateTime);
            formattedActual.add(formattedActualShipmentDate);
        }
        return formattedActual;
    }

    // Selecting expected shipped dates
    List<String> formattedActual = new ArrayList<>();
    public List<String> selectExpectedShippedDates(int numberOfShippedDates) {
        List<String> expectedShippedDates = new ArrayList<>();
        for (int i = 1; i < numberOfShippedDates+1; i++) {
            System.out.println(shipmentShippedDateList.get(i));
            shipmentShippedDateList.get(i).click();
            String expectedShipmentDateTime = shipmentShippedDateList.get(i).getText();

         expectedShippedDates.add(expectedShipmentDateTime);
        }
        return expectedShippedDates;
    }

    //Batch and Inline Editing WebElements

    @FindBy(xpath = "//button[@data-testid='batch-button']")
    public WebElement batchInlineButton;

    @FindBy(xpath = "//span[contains(text(),'Batch Mode')]")
    public WebElement batchModeToggle;

    @FindBy(xpath = "//div/a[contains(text(),'Proceed to batch')][1]")
    public WebElement proceedToBatchCancellation;

    @FindBy(xpath = "//div/a[contains(text(),'Proceed to batch')][2]")
    public WebElement proceedToBatchUpdate;

    @FindBy(xpath = "//*[@data-testid='shipmentEquipments[0].weight-batch-checkbox']")
    public WebElement weightCheckBox;

    @FindBy(xpath = "//input[@data-testid='shipped-batch-checkbox']")
    public WebElement shippedDateCheckBox;

    @FindBy(id = "shipped-calendar-toggle")
    public WebElement shippedCalendarToggle;

    @FindBy(xpath = "//button[contains(@class, 'DayView_tile__xcLKh DayView_today__uySa0')]")
    public WebElement shippedTodaysDate;

    @FindBy(xpath = "//button[@class='DayView_tile__xcLKh DayView_today__uySa0 DayView_selected-day__L9YK1 DayView_day-from-current-month__RfBIx']/preceding-sibling::*[1]")
    public WebElement shippedYesterdaysDate;

    @FindBy(xpath = "//button[text()='Cancel Shipments']")
    public WebElement cancelShipmentsBatch;

    @FindBy(xpath = "//span[contains(text(),'Inline Editing')]")
    public WebElement inlineEditingToggle;

    @FindBy(xpath = "//button[contains(text(),'Submit Inline Edit')]")
    public WebElement submitInlineEditButton;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[contains(@id,'shipped-date')]")
    public WebElement inlineShippedDateBox;

    @FindBy(xpath = "//input[contains(@id,'shipped-time')]")
    public WebElement inlineShippedTimeBox;

    @FindBy(xpath = "//button[contains(@id, 'shipped-clear-button')]")
    public List<WebElement> shippedDateClearButtons;

    @FindBy(xpath = "//button[@class='DayView_tile__xcLKh DayView_today__uySa0  DayView_day-from-current-month__RfBIx']/preceding-sibling::*[1]")
    public WebElement shippedDateYesterdaysDate;

    @FindBy(xpath = "//button[contains(@id, 'shipped-calendar-toggle')]")
    public List<WebElement> shippedCalendarToggles;
    @FindBy(xpath = "//div[@class='Pagination_total-records__9-+PM ']")
    public WebElement totalNumberOfShipmentsText;

    public int NumberOfShipments(){
        String TotalRecordOfShipmentsText=totalNumberOfShipmentsText.getText();
        // Split the string using space as delimiter
        String[] parts = TotalRecordOfShipmentsText.split(" ");
        // Extract the first element
        String TotalNumberOfShipments = parts[0];
        String totalNumberWithoutComma = TotalNumberOfShipments.replace(",", "");
        int totalNumberOfShipments = Integer.parseInt(totalNumberWithoutComma);
        System.out.println(totalNumberOfShipments);
        return totalNumberOfShipments;
    }


    List<String> inlineExpectedDateTimes = new ArrayList<>();

    public List<String> fillOutExpectedShippedDates(int numberOfShippedDates) {
        for (int i = 0; i < numberOfShippedDates; i++) {
            shipmentShippedDateList.get(i + 1).click();
            shippedDateClearButtons.get(i).click();
            shippedCalendarToggles.get(i).click();
            shippedDateYesterdaysDate.click();
            String expectedShippedDateTime = inlineShippedDateBox.getAttribute("value") + " " + inlineShippedTimeBox.getAttribute("value");
            inlineExpectedDateTimes.add(expectedShippedDateTime);
            System.out.println(expectedShippedDateTime);
        }
        return inlineExpectedDateTimes;
    }

    @FindBy(xpath = "//div[@col-id='bol']/div/div/div/input")
    public List<WebElement> shipmentEditBOLValueList;

    @FindBy(xpath = "//div[@col-id='bol']")
    public List<WebElement> shipmentBOLValueList;

    List<String> expectedBOLValues = new ArrayList<>();

    public List<String> fillOutExpectedBOLValues(String bol, int numberOfBOL) {
        for (int i = 0; i < numberOfBOL; i++) {
            shipmentEditBOLValueList.get(i).click();
            shipmentEditBOLValueList.get(i).clear();
            shipmentEditBOLValueList.get(i).sendKeys(bol);
            expectedBOLValues.add(bol);
        }
        return expectedBOLValues;
    }

    @FindBy(xpath = "//div[@col-id='originCity']/div/div/div/input")
    public List<WebElement> shipmentEditOriginCityValueList;

    @FindBy(xpath = "//div[@col-id='originCity']")
    public List<WebElement> shipmentOriginCityValueList;

    List<String> expectedOriginCityValues = new ArrayList<>();

    public List<String> fillOutExpectedOriginCityValues(String originCity, int numberOfOriginCity) {
        for (int i = 0; i < numberOfOriginCity; i++) {
            shipmentEditOriginCityValueList.get(i).click();
            shipmentEditOriginCityValueList.get(i).clear();
            shipmentEditOriginCityValueList.get(i).sendKeys(originCity);
            expectedOriginCityValues.add(originCity);
        }
        return expectedOriginCityValues;
    }


    @FindBy(xpath = "//div[@col-id='originState']/div/div/div/div/input")
    public List<WebElement> shipmentEditOriginStateValueList;

    @FindBy(xpath = "//div[@col-id='originState']")
    public List<WebElement> shipmentOriginStateValueList;

    @FindBy(xpath = "//button[contains(@id, 'originState-clear-button')]")
    public List<WebElement> originStateClearButtons;
    List<String> expectedOriginStateValues = new ArrayList<>();

    public List<String> fillOutExpectedOriginStateValues(String originState, int numberOfOriginState) {
        for (int i = 0; i < numberOfOriginState; i++) {
            shipmentEditOriginStateValueList.get(i).click();
            originStateClearButtons.get(i).click();
            shipmentEditOriginStateValueList.get(i).sendKeys(originState);
            shipmentEditOriginStateValueList.get(i).sendKeys(Keys.ENTER);
            expectedOriginStateValues.add(originState);
        }
        return expectedOriginStateValues;
    }


    @FindBy(xpath = "//div[@col-id='destinationCity']/div/div/div/input")
    public List<WebElement> shipmentEditDestinationCityValueList;
    @FindBy(xpath = "//div[@col-id='destinationCity']")
    public List<WebElement> shipmentDestinationCityValueList;
    List<String> expectedDestinationCityValues = new ArrayList<>();

    public List<String> fillOutExpectedDestinationCityValues(String destinationCity, int numberOfDestinationCity) {
        for (int i = 0; i < numberOfDestinationCity; i++) {
            shipmentEditDestinationCityValueList.get(i).click();
            shipmentEditDestinationCityValueList.get(i).clear();
            shipmentEditDestinationCityValueList.get(i).sendKeys(destinationCity);
            expectedDestinationCityValues.add(destinationCity);
        }
        return expectedDestinationCityValues;
    }

    @FindBy(xpath = "//div[@col-id='destinationState']/div/div/div/div/input")
    public List<WebElement> shipmentEditDestinationStateValueList;
    @FindBy(xpath = "//div[@col-id='destinationState']")
    public List<WebElement> shipmentDestinationStateValueList;
    @FindBy(xpath = "//button[contains(@id, 'destinationState-clear-button')]")
    public List<WebElement> destinationStateClearButtons;
    List<String> expectedDestinationStateValues = new ArrayList<>();

    public List<String> fillOutExpectedDestinationStateValues(String destinationState, int numberOfDestinationState) {
        for (int i = 0; i < numberOfDestinationState; i++) {
            shipmentEditDestinationStateValueList.get(i).click();
            destinationStateClearButtons.get(i).click();
            shipmentEditDestinationStateValueList.get(i).sendKeys(destinationState);
            shipmentEditDestinationStateValueList.get(i).sendKeys(Keys.ENTER);
            expectedDestinationStateValues.add(destinationState);
        }
        return expectedDestinationStateValues;
    }






}
