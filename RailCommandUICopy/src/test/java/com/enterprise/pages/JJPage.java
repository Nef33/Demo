package com.enterprise.pages;

import com.enterprise.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JJPage {
    public JJPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[@data-testid='Shipments-nav-group']")
    public WebElement shipmentDropdown;
}
