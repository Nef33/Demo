package com.enterprise.steps;

import com.enterprise.utility.DB_Util;
import com.enterprise.utility.Driver;

import com.enterprise.utility.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Hooks {


   // private static final Logger logger = Logger.getLogger(Hooks.class.getName());


    @Before
    public void setUp() {
        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Utilities.screenshot(Driver.getDriver());
    }

    @After
    public void tearDown() {
    //    logger.info("Closing the browser...");
        System.out.println("this is coming from AFTER");

      /*  if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }*/

        Driver.closeDriver();

    }





    @Before("@db")
    public void setupDB(){
        System.out.println("Connecting to database...");
        DB_Util.createConnection();
    }

    @After("@db")
    public void closeDB(){
        System.out.println("Closing DB connection...");
        DB_Util.destroy();
    }
}
