package Admin;

import Patterns.Log.AbstractLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasicClass extends AbstractLogger {

    protected boolean isElementPresent(By by, WebDriver thisDriver) {
        try {
            thisDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void enterToPhenix(WebDriver driverThis) throws IOException, AWTException, InterruptedException {
        log("Open phenix");
        driverThis.get("https://my.platformphoenix.com/");
        Runtime.getRuntime().exec("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\AutoITScrpt\\HandleAuthentication.exe");
        Thread.sleep(1000);
        driverThis.switchTo().alert().accept();
        log("Success login to phenix");
        Thread.sleep(5000);
        new WebDriverWait(driverThis, 15).until(ExpectedConditions.titleIs("My Application - Base"));
    }
    protected void writeToFile(String usersLog) throws IOException {

        FileWriter fileWriter = new FileWriter("FileForWrite.txt");
        fileWriter.write(System.lineSeparator() + usersLog);
       // fileWriter.append(System.lineSeparator() + usersLog);
        fileWriter.close();
    }
    protected void tearDown(WebDriver driverThis) throws Exception {
        driverThis.quit();
    }
    protected  List<String> reader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
    protected void forScreen(WebDriver driverThis) throws IOException {
        File screenshot = ((TakesScreenshot)driverThis).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Z:\\selenium\\Screen\\screenshot.jpg"));
    }

    @Override
    protected void doLogging(String stringToLog) throws IOException {
        System.out.println(stringToLog);
    }

}
