package com.enterprise.pages;


import com.enterprise.utility.Driver;
import com.enterprise.utility.Utilities;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.logging.Logger;

public class LoginPage extends BasePage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    Logger logger = Logger.getLogger(this.getClass().getName());

    private JsonObject configObj = Utilities.readConfigurations();
    private JsonObject envConfigObj = configObj.getAsJsonObject(env);

    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement edtEmail;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement edtPw;
    @FindBy(xpath = "//button[@aria-label=\"Log In\"]")
    public WebElement btnLogin;
    @FindBy(id = "client-switcher")
    public WebElement users;
    @FindBy(xpath = "//*[text()='RSI TEST CLIENT']")
    public WebElement rsiTestClient;
    @FindBy(xpath = "//*[text()='DIAMOND GREEN DIESEL']")
    public WebElement diamondGreenDieselClient;
    @FindBy(xpath = "//*[text()='RICHARDSON INTERNATIONAL']")
    public WebElement richardsonInternationalTestClient;


    public void rsiLogin() throws InterruptedException {
       // Login login = Login.getObjInstance(driver);
       Driver.getDriver().get(envConfigObj.get("url").getAsString());

        waitForElementToBeDisplayed(Driver.getDriver(), btnLogin);
        sendKeys(edtEmail, envConfigObj.get("userName").getAsString());
        sendKeys(edtPw, envConfigObj.get("password").getAsString());
        jsClick(Driver.getDriver(), btnLogin);

    }
    public void selectRsiTestClientUser() throws InterruptedException{

        jsClick(Driver.getDriver(),users);


        Actions actions = new Actions(Driver.getDriver());


        for (int i = 21; i <=75; i += 2)
        {
            actions.scrollToElement(Driver.getDriver().findElement(By.xpath("//*[@id='client-switcher-menu']/div[@class='VirtualList_virtual-list-wrapper__5TmIq']/ul/li[@id='client-switcher-item-" + i + "']"))).build().perform();
        }
        jsClick(Driver.getDriver(),rsiTestClient);


    }

   public void selectDiamondGreenDieselClientUser() throws InterruptedException
    {

        jsClick(Driver.getDriver(), users);


        Actions actions = new Actions(Driver.getDriver());


        for (int i = 21; i <= 30; i += 2)
        {
            actions.scrollToElement(Driver.getDriver().findElement(By.xpath("//*[@id='client-switcher-menu']/div[@class='VirtualList_virtual-list-wrapper__5TmIq']/ul/li[@id='client-switcher-item-" + i + "']"))).build().perform();
        }
        jsClick(Driver.getDriver(), diamondGreenDieselClient);

    }

    public void selectRichardsonInternationalTestClientUser() throws InterruptedException{

        jsClick(Driver.getDriver(),users);


        Actions actions = new Actions(Driver.getDriver());


        for (int i = 21; i <=75; i += 2)
        {
            actions.scrollToElement(Driver.getDriver().findElement(By.xpath("//*[@id='client-switcher-menu']/div[@class='VirtualList_virtual-list-wrapper__5TmIq']/ul/li[@id='client-switcher-item-" + i + "']"))).build().perform();
        }
        jsClick(Driver.getDriver(),richardsonInternationalTestClient);


    }
}
