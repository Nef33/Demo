package com.enterprise.pages;

import com.enterprise.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class WaybillPage extends BasePage{

    public WaybillPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Waybills")
    public WebElement waybillOption;

    @FindBy(xpath = "//button[@data-testid='action-menu-toggle-0']")
    public WebElement firstRowButtonWaybill;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[1]")
    public WebElement viewWaybill;

    @FindBy(xpath = "//*[text()='Create Shipment']")
    public WebElement createShipmentButtonWaybill;

    @FindBy(id = "patternId")
    public WebElement patternBoxWaybill;

    @FindBy(id = "patternId-item-0")
    public WebElement firstOptionPatternBoxWaybill;

    @FindBy(id = "shipmentCommodities[0].commodityId")
    public WebElement commodityBoxWaybill;

    @FindBy(id = "shipmentCommodities[0].commodityId-item-0")
    public WebElement firstOptionCommodityBoxWaybill;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[4]")
    public WebElement inactivateWaybill;

    @FindBy(xpath = "//*[@id='root']/div[2]/div[2]/div/div[3]/div[2]/div[4]")
    public WebElement totalRecordOfWaybill;

    @FindBy(xpath = "/html/body/div[9]/div/div/div[3]/button[1]")
    public WebElement inactivateWaybillModalButton;

    //Batch Create Shipment
    @FindBy(xpath = "//button[@data-testid='report-settings-button']")
    public WebElement configureTab;

    @FindBy(id ="column-picker")
    public WebElement searchColumnBox;

    @FindBy(xpath ="//button[@data-testid='remove-all-columns']")
    public WebElement removeAllButton;
    @FindBy(xpath ="//button[@data-testid='add-column']")
    public WebElement addSelectedButton;
    @FindBy(xpath ="//button[text()='Apply']")
    public WebElement applyButton;
    @FindBy(id ="hasShipment-quick-filter")
    public WebElement shipmentFilter;

   @FindBy(partialLinkText ="create Shipments")
    public WebElement batchCreateShipments;
   @FindBy(name ="submitButton")
    public WebElement createShipmentsButton;


}
