package com.enterprise.utility;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utilities {

    public static JsonObject readConfigurations() {
        try {
            String data = Files.readString(Path.of("src/test/resources/config.json"));
            return new Gson().fromJson(data, JsonObject.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return new JsonObject();
        }
    }


    //  @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot(WebDriver driver) {
        try {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            Allure.addAttachment("screenshot", "Unable to take screenshot");
        }
        return new byte[1];
    }


    public static void writeDataIntoACsvFile(String data, String fileName, boolean isAppend) throws IOException {
        File fis = new File("src/test/resources/" + fileName);
        try (PrintWriter pw = new PrintWriter(new FileWriter(fis, isAppend), true)) {
            pw.write(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Files are not available in directory");
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile.getName();
    }

    public static void setClipBoard(String file) {
        StringSelection obj = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
    }

    public static void uploadDownloadFile(String filePath) throws AWTException {
        setClipBoard(filePath);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
