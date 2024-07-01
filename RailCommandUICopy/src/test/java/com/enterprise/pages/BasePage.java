package com.enterprise.pages;


import com.enterprise.utility.Driver;
import com.enterprise.utility.Utilities;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@SuppressWarnings("all")
public class BasePage {

  // WebDriver driver = Driver.getDriver();
    Logger logger = Logger.getLogger(this.getClass().getName());
    public static String env = System.getProperty("env", "dev");
    public static JsonObject configObj = Utilities.readConfigurations();
    public static JsonObject envConfigObj = configObj.getAsJsonObject(env);


    //    Add Objects of all Page Objects
  //  public static LoginPage login = new LoginPage();


    public static Faker faker = new Faker();

    public boolean waitForElementToBeDisplayed(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }

    }

    public boolean waitForElementToBeDisplayed(WebDriver driver, WebElement element, int duration) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }

    }

    public boolean waitForElementToNotContainAttributeValue(WebDriver driver, WebElement element, String attribName, String attribVal) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, attribName, attribVal)));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForElementToBeInDocument(WebDriver driver, WebElement element, String attribName, String attribVal) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.domAttributeToBe(element, attribName, attribVal));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForFrameToLoad(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }

    }

    public boolean waitForUrlToContain(WebDriver driver, String url) {

        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.urlContains(url));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForElementNotToBeDisplayed(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
            try {
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
                webDriverWait.until(ExpectedConditions.invisibilityOf(element));
                return true;
            } catch (WebDriverException we) {
                return false;
            }

    }

    public boolean waitForElementNotToBeDisplayed(WebDriver driver, WebElement element, long secs) {
        driver=Driver.getDriver();
            try {
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(secs));
                webDriverWait.until(ExpectedConditions.invisibilityOf(element));
                return true;
            } catch (WebDriverException we) {
                return false;
            }

    }

    public boolean waitForElementToBeClickable(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        Utilities.screenshot(driver);

            try {
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
                return true;
            } catch (WebDriverException we) {
                Utilities.screenshot(driver);
                throw we;

            }

    }

    public boolean waitForElementToBeClickable(WebDriver driver, WebElement element, int num) {
        driver=Driver.getDriver();
        try{
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(num));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
                return true;
            } catch (WebDriverException we) {
                Utilities.screenshot(driver);
                throw we;
            }

    }

    public boolean waitForElementsListTobeGreaterThanNum(WebDriver driver, By element, int Num) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, Num));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForElementTextToBe(WebDriver driver, WebElement element, String text) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForElementTextToBe(WebDriver driver, WebElement element, String text, long secs) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(secs));
            webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForElementTextNotToBeEmpty(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        try {
            new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return element.getText().length() != 0;
                        }
                    });
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForElementToBeSelected(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.elementToBeSelected(element));
            return true;
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public boolean waitForListOfElmsToLad(WebDriver driver, List<WebElement> element) {
        driver=Driver.getDriver();
            try {
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
                return true;
            } catch (WebDriverException we) {
                Utilities.screenshot(driver);
                throw we;
            }

    }

    public boolean waitForListOfElmsToLad(WebDriver driver, List<WebElement> element, long time) {
        driver=Driver.getDriver();
            try {
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(time));
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
                return true;
            } catch (WebDriverException we) {
                Utilities.screenshot(driver);
                throw we;
            }

    }

    public void scrollTillEndOfPage(WebDriver driver) {
        driver=Driver.getDriver();
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (WebDriverException we) {
            Utilities.screenshot(driver);
            throw we;
        }
    }

    public void selectElementByIndex(WebElement selectElement, int index) {
        Select select = new Select(selectElement);
        select.selectByIndex(index);
    }

    public void selectElementByText(WebElement selectElement, String text) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(text);
    }

    public void selectElementByValue(WebElement selectElement, String text) {
        Select select = new Select(selectElement);
        select.selectByValue(text);
    }

    public void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");
    }

    public void scrollUp(WebDriver driver, int value) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -" + value + ")");
    }

    public void scrollDown(WebDriver driver) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }

    public void scrollDown(WebDriver driver, int value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + value + ")");
    }

    public void scrollRight(WebDriver driver, WebElement value) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", value);
    }

    public void scrollRightTillElemenIsDiplayed(WebDriver driver, WebElement value) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int ctr = 0;
        boolean isDisplayed = false;
        while (!isDisplayed && ctr++ < 5) {
            try {

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 200", value);
                isDisplayed = value.isDisplayed();
            } catch (WebDriverException e) {
                Utilities.screenshot(driver);
                System.out.println("Element not displayed... scrolling to right.....");
            }
        }
    }

    public void scrollRight(WebDriver driver) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 500");
    }

    public void scrollIntoView(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (StaleElementReferenceException se) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    public void scrollDownToBottom(WebDriver driver) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void switchToParentFrame(WebDriver driver) {
        driver=Driver.getDriver();
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent(WebDriver driver) {

        driver=Driver.getDriver();
        driver.switchTo().defaultContent();
    }

    public void closeCurrentWindow(WebDriver driver) {
        driver=Driver.getDriver();
        driver.close();
    }

    public void quitDriver(WebDriver driver) {
        driver=Driver.getDriver();
        logger.info("Closing browser");
        driver.quit();
    }

    public void click(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        waitForElementToBeClickable(driver, element);
        scrollIntoView(driver, element);
        logger.info("Clicking on element " + element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            Utilities.screenshot(driver);
            jsClick(driver, element);
        }
    }

    public void jsClick(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        waitForElementToBeClickable(driver, element);
        scrollIntoView(driver, element);
        logger.info("Clicking on element " + element);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (ScriptTimeoutException se) {
            se.printStackTrace();
        }
    }

    public void jsClear(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].value=''", element);
    }

    public void jsClearSendKeys(WebDriver driver, WebElement element, String text) {
        driver=Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element);
        element.sendKeys(text);
    }

    public boolean waitForAlertToBeDisplayed(WebDriver driver) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configObj.get("defaultTimeOut").getAsInt()));
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (WebDriverException we) {
            throw we;
        }
    }

    public boolean waitForAlertToBeDisplayed(WebDriver driver, long time) {
        driver=Driver.getDriver();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(time));
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (WebDriverException we) {
            throw we;
        }
    }

    public boolean fluentWaitForElementTextNotToBeEmpty(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(90000));
        wait.pollingEvery(Duration.ofSeconds(1000));
        wait.ignoring(NoSuchElementException.class);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return element.getText().length() != 0;
            }
        });
        return true;

    }

    public boolean fluentWaitForElementToBeDisplayed(WebDriver driver, WebElement element) {
        driver=Driver.getDriver();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public void sendKeys(WebElement elm, String text) throws InterruptedException {

        try {
            elm.click();
        } catch (WebDriverException we) {
        }
        elm.clear();

        Thread.sleep(500);
        elm.sendKeys(text);
}

    public void sendKeysUsingActionsWithoutEnter(WebDriver driver, WebElement elm, String text) throws InterruptedException {
        driver=Driver.getDriver();
        Actions actions = new Actions(driver);
        click(driver, elm);
        actions.sendKeys(text).build().perform();
    }

    public void waitForPageToLoad(WebDriver driver) {
        driver=Driver.getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(configObj.get("pageLoadTimeOut").getAsInt())).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public static void setClipBoard(String file) {
        StringSelection obj = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
    }

    public static void uploadFile(String filePath) throws AWTException {
        setClipBoard(filePath);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
// Nefise's code from this line

    public static String formatDate(String date) {
        // Define the formatter for the input format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");

        // Parse the given string into LocalDateTime object
        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);

        // Define the formatter for the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");

        // Format the LocalDateTime object into the desired format
        String formattedDateTime = dateTime.format(outputFormatter);

        return formattedDateTime;
    }

    public static boolean downladPDFfile(String expectedFileType) throws Exception {
        String sourceDir="C:\\Users\\kayan\\Downloads";
        String targetDir="C:\\Users\\kayan\\OneDrive - Trinity Industries Inc\\Desktop\\BOLfiles";

        moveLatestFile(sourceDir,targetDir);

        File folder=new File(targetDir);
        File[] fileList=folder.listFiles();
        boolean isFilePresent=false;
        for(File file:fileList){

            if (file.isFile()&&file.exists()){
                String fileName=file.getName();
                System.out.println(fileName);

                if(fileName.contains(expectedFileType)){
                    isFilePresent=true;
                }
            }
        }

    return isFilePresent;
    }

    public static void moveLatestFile(String sourceDir, String targetDir) throws Exception {
        File downloadDir = new File(sourceDir);

        // Find the latest downloaded file
        File latestFile = Arrays.stream(downloadDir.listFiles())
                .filter(file -> !file.isDirectory())
                .max(Comparator.comparingLong(File::lastModified))
                .orElseThrow(() -> new Exception("No files found in download directory"));

        // Move the file to the target directory
        Files.move(latestFile.toPath(), Paths.get(targetDir, latestFile.getName()));
        System.out.println("File downloaded and moved to: " + targetDir + "/" + latestFile.getName());
    }


    public static void deleteDownloadFile() throws Exception {

        String targetDir="C:\\Users\\kayan\\OneDrive - Trinity Industries Inc\\Desktop\\BOLfiles";



        File folder = new File(targetDir);

        FileUtils.cleanDirectory(folder);
    }}



