package com.enterprise.pages;

import com.enterprise.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcknowledgementsPage extends BasePage{


    public AcknowledgementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Acknowledgements")
    public WebElement acknowledgementsOption;

    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[3]")
    public WebElement editShipment;
    @FindBy(xpath = "//div[@class='ActionsMenu_actions-menu__207Eg']/ul/li[4]")
    public WebElement cancelShipment;
}
