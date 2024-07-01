package com.enterprise.pages;

import com.enterprise.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class DiversionPage extends BasePage {

public DiversionPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(id = "carrierId")
    public WebElement carrierBox;
    @FindBy(xpath = "//*[@id='carrierId-menu']/div/ul/li")
    public List<WebElement> carrierList;

    @FindBy(id = "paymentMethodId")
    public WebElement freightTermsBox;
    @FindBy(xpath = "//*[@id='paymentMethodId-menu']/div/ul/li")
    public List<WebElement> freightTermsList;

    @FindBy(id = "loadedEmptyCodeId")
    public WebElement loadedEmptyBox;
    @FindBy(xpath = "//*[@id='loadedEmptyCodeId-menu']/div/ul/li")
    public List<WebElement> loadedEmptyList;

    @FindBy(id = "diversionStatusId")
    public WebElement statusBox;
    @FindBy(id = "diversionStatusId-clear-button")
    public WebElement clearStatusButton;
    @FindBy(xpath = "//*[@id='diversionStatusId-menu']/div/ul/li")
    public List<WebElement> statusList;
    @FindBy(id = "commodityId")
    public WebElement comodityBox;
    @FindBy(xpath = "//*[@id='commodityId-menu']/div/ul/li")
    public List<WebElement> comodityList;

    @FindBy(xpath = "//button[@aria-label='Show Equipment section']")
    public WebElement showEquipmentButton;
    @FindBy(id = "diversionEquipments")
    public WebElement addEquipmentBox;
    @FindBy(xpath = "//button[@data-testid='diversion-equipment-add-btn']")
    public WebElement addEquipmentButton;

    @FindBy(id = "diversionParties[0].partyId")
    public WebElement partyBox;

    @FindBy(xpath = "//*[@id='diversionParties[0].partyId-menu']/div/ul/li")
    public List<WebElement> partyList;
    @FindBy(linkText = "Diversions")
    public WebElement diversionOption;

    @FindBy(xpath = "//button[@data-testid='action-menu-toggle-0']")
    public WebElement firstDiversionArrow;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[2]")
    public WebElement editButton;


    @FindBy(id ="comment")
    public WebElement noteBox;

    @FindBy(linkText = "Terms of Use")
    public WebElement termsOfUSe;
    @FindBy(xpath ="//div[@data-testid='terms-of-use-section-body']/div/div/label/span/span")
    public WebElement acceptCheckBox;
    @FindBy(name ="submitButton")
    public WebElement saveChangesButton;
    @FindBy(xpath ="(//div[@col-id='diversionStatus'])[2]")
    public WebElement firstStatusValue;
    @FindBy(xpath ="(//div[@col-id='lastComment'])[2]")
    public WebElement firstLastNoteValue;

    @FindBy(xpath = "//*[@id='root']/div[2]/div[2]/div/div[3]/div[2]/div[4]")
    public WebElement totalNumberOfRecords;
    public int NumberOfRecords(){
        String TotalRecordText=totalNumberOfRecords.getText();
        // Split the string using space as delimiter
        String[] parts = TotalRecordText.split(" ");
        // Extract the first element
        String TotalNumberOfRecord = parts[0];
        int totalNumberOfRecords;
        totalNumberOfRecords = Integer.parseInt(TotalNumberOfRecord);
        System.out.println(totalNumberOfRecords);
        return totalNumberOfRecords;
    }
}

