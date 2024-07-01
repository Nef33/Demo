package com.enterprise.pages;

import com.enterprise.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class ShipmentMonitorPage extends BasePage {

    public ShipmentMonitorPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//*[@id='accordion-panel-Shipments']/div[4]/div/a")
    public WebElement shipmentMonitorOption;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[1]")
    public WebElement editTransactionButton;

    @FindBy(id = "waybillNumber")
    public WebElement waybillNumberBox;

    @FindBy(id = "errorCategoryId")
    public WebElement errorCategoryIdBox;

    @FindBy(xpath = "//input[@data-testid='errorCategoryId-batch-checkbox']")
    public WebElement errorCategoryCheckBox;

    @FindBy(id = "comment")
    public WebElement noteBox;

    @FindBy(xpath = "//input[@data-testid='comment-batch-checkbox']")
    public WebElement noteCheckBox;

    @FindBy(xpath = "(//div[@col-id='waybillNumber'])[2]")
    public WebElement firstWaybillColumnBox;

    @FindBy(xpath = "//input[@data-testid='waybillNumber-batch-checkbox']")
    public WebElement waybillNumberCheckBox;

    @FindBy(xpath = "//input[@data-testid='isErrorHandled-batch-checkbox']")
    public WebElement errorHandledCheckBox;

    @FindBy(xpath = "//input[@id='isErrorHandled-Yes']")
    public WebElement errorHandledYesButton;

    @FindBy(xpath = "//input[@id='isErrorHandled-No']")
    public WebElement errorHandledNoButton;

    @FindBy(xpath = "//*[@id='errorCategoryId-menu']/div/ul/li")
    public List<WebElement> errorCategoryIdOptions;

    @FindBy(xpath = "//div/a[contains(text(),'Proceed to batch')]")
    public WebElement proceedToBatchUpdate;
}
