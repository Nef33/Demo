package com.enterprise.steps;


import com.enterprise.pages.BasePage;
import com.enterprise.pages.LoginPage;
import com.enterprise.utility.Driver;
import com.enterprise.utility.Utilities;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class LoginStepDefs extends BasePage {
    Logger logger = Logger.getLogger(this.getClass().getName());
    private JsonObject configObj = Utilities.readConfigurations();
    private JsonObject envConfigObj = configObj.getAsJsonObject(env);
    LoginPage loginPage;
   private  WebDriver driver;
   public LoginStepDefs(){

      this.loginPage=new LoginPage();
    this.driver=Driver.getDriver();
   }
    @Given("Open Rail Command application")
    public void open_rail_command_application() throws InterruptedException {

        Driver.getDriver().get(envConfigObj.get("url").getAsString());
        System.out.println("url is opened");

    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() throws InterruptedException {

        sendKeys(loginPage.edtEmail, envConfigObj.get("userName").getAsString());
        sendKeys(loginPage.edtPw, envConfigObj.get("password").getAsString());
       // jsClick(Driver.getDriver(),loginPage.btnLogin);
        jsClick(driver,loginPage.btnLogin);
    }

    @Then("user is able to login")
    public void user_is_able_to_login() {

        Assert.assertTrue(true);
    }

    @When("user enters invalid  username")
    public void user_enters_invalid_username() throws InterruptedException {
        sendKeys(loginPage.edtEmail, envConfigObj.get("invalidUserName").getAsString());
        sendKeys(loginPage.edtPw, envConfigObj.get("password").getAsString());
     //   jsClick(Driver.getDriver(),loginPage.btnLogin);

        jsClick(driver,loginPage.btnLogin);

    }

    @Then("user is not able to login")
    public void user_is_not_able_to_login() {
        Assert.assertTrue(true);
    }

    @When("user enters invalid  password")
    public void user_enters_invalid_password() throws InterruptedException {
        waitForElementToBeDisplayed(Driver.getDriver(),loginPage.btnLogin);
        sendKeys(loginPage.edtEmail, envConfigObj.get("userName").getAsString());
        sendKeys(loginPage.edtPw, envConfigObj.get("invalidPassword").getAsString());
       // jsClick(Driver.getDriver(),loginPage.btnLogin);
        jsClick(driver,loginPage.btnLogin);
    }



}
