package regs;

import Patterns.CSV.CsvCell;
import Patterns.CSV.ReadCSV4colon;
import Patterns.Log.AbstractLogger;
import Patterns.Log.ConsoleLogger;
import com.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected List<CsvCell> regInfo;
    protected ArrayList<String> emailOfUsers = new ArrayList<>();

    public TestBase() throws IOException, InterruptedException {
    }


    public void choseCorrectedDOBandSetAge() throws IOException {
        if (isElementPresent("//select[@id='UserForm_month']")) {
            log("this is old DOB");
            click("//select[@id='UserForm_day']/option[@value='01']");
            click("//select[@id='UserForm_month']/option[@value='01']");
            click("//select[@id='UserForm_year']/option[@value='1999']");
        } else {
            log("this is new DOB");
            click("//option[@value='18']");
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            this.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void enterToPhenix() throws IOException, AWTException, InterruptedException {
        log("Open phenix");
        this.driver.get("https://my.platformphoenix.com/");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\AutoITScrpt\\HandleAuthentication.exe");
        Thread.sleep(1000);
        this.driver.switchTo().alert().accept();
        log("Success login to phenix");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.titleIs("My Application - Base"));
    }

    protected void writeToFile(String usersLog) throws IOException {

        FileWriter fileWriter = new FileWriter("FileForWrite.txt");
        fileWriter.write(System.lineSeparator() + usersLog);
        // fileWriter.append(System.lineSeparator() + usersLog);
        fileWriter.close();
    }


    protected ArrayList<String> readerTxtFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    protected void csvDataRead() throws IOException, InterruptedException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\TN\\InfoForTesting.csv"));
        String[] csvCell;
        List<CsvCell> list = new ArrayList<>();
        while ((csvCell = reader.readNext()) != null) {
            CsvCell csvCell1 = new CsvCell(csvCell[0], csvCell[1], csvCell[2], csvCell[3]);
            list.add(csvCell1);
        }
    }

    protected void forScreen(WebDriver driverThis) throws IOException {
        File screenshot = ((TakesScreenshot) driverThis).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Z:\\selenium\\Screen\\screenshot.jpg"));
    }

    protected void writeIpAddressToCookie(String ip_address) {
        driver.manage().addCookie(new Cookie("ip_address", ip_address));
        driver.navigate().refresh();
    }

    public String returnDomainFromUrl(String urlText) {
        String[] splitUrl = urlText.split("\\.");
        return splitUrl[1];
    }

    protected String choseActiveElement(String xpath1, String xpath2, String xpath3) throws IOException {
        if (isElementPresent(xpath1)) {
            log("xpath1 works");
            return xpath1;
        }
        if (isElementPresent(xpath2)) {
            log("xpath2 works");
            return xpath2;
        }
        if (isElementPresent(xpath3)) {
            log("xpath3 works");
            return xpath3;
        }
        log("All of this xpath not active");
        return "";
    }

    protected String choseActiveElement(String xpath1, String xpath2) throws IOException {
        if (isElementPresent(xpath1)) {
            log("xpath1 works");
            return xpath1;
        }
        if (isElementPresent(xpath2)) {
            log("xpath2 works");
            return xpath2;
        }
        log("All of this xpath not active");
        return "";
    }

    protected Boolean isElementPresent(String xpath) {
        return this.driver.findElements(By.xpath(xpath)).size() != 0;
    }

    protected ChromeOptions emulateMobile() throws InterruptedException {
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;
    }

    protected String generateRandomEmail() {
        SimpleDateFormat sf = new SimpleDateFormat("dd-HH_mm.ss");
        Date date = new Date();
        return sf.format(date) + "tn@maildrop.ropot.net";
    }


    protected void click(String xpath) {
        this.driver.findElement(By.xpath(xpath)).click();
    }

    protected void type(String xpath, String text) {
        this.driver.findElement(By.xpath(xpath)).clear();
        this.driver.findElement(By.xpath(xpath)).sendKeys(text);
    }


    protected void log(String stringToLog) throws IOException {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        consoleLogger.log(stringToLog);
    }

}
