package Admin;

import Patterns.Log.AbstractLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class BasicClaas extends AbstractLogger {

    protected boolean isElementPresent(By by, WebDriver thisDriver) {
        try {
            thisDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterToPhenix(WebDriver driverThis) throws IOException, AWTException, InterruptedException {
        log("Open phenix");
        driverThis.get("https://my.platformphoenix.com/");
        Runtime.getRuntime().exec("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\AutoITScrpt\\HandleAuthentication.exe");
        Thread.sleep(1000);
        driverThis.switchTo().alert().accept();
        log("Success login to phenix");
        Thread.sleep(5000);
        new WebDriverWait(driverThis, 15).until(ExpectedConditions.titleIs("My Application - Base"));
    }
    public void writeToFile(String usersLog) throws IOException {

        FileWriter fileWriter = new FileWriter("FileForWrite.txt");
        fileWriter.write(System.lineSeparator() + usersLog);
       // fileWriter.append(System.lineSeparator() + usersLog);
        fileWriter.close();
    }
    public void tearDown(WebDriver driverThis) throws Exception {
        driverThis.quit();
    }

    @Override
    protected void doLogging(String stringToLog) throws IOException {
        System.out.println(stringToLog);
    }
}
