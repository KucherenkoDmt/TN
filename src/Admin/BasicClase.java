package Admin;

import Patterns.CSV.CsvCell;
import Patterns.CSV.ReadCSV4colon;
import Patterns.Log.AbstractLogger;
import com.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicClase extends AbstractLogger {


    public BasicClase() throws IOException, InterruptedException {
    }


    protected void tearDown(WebDriver driver){
        driver.quit();
    }


    protected void enterToPhenix(WebDriver driver) throws IOException, AWTException, InterruptedException {
        log("Open phenix");
        driver.get("https://my.platformphoenix.com/");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\AutoITScrpt\\HandleAuthentication.exe");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        log("Success login to phenix");
        Thread.sleep(5000);
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleIs("My Application - Base"));
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

    public void csvDataRead() throws IOException, InterruptedException {
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

    public void proxyCR() throws InterruptedException {

        String proxySG = "185.145.202.171:3128";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxySG).setFtpProxy(proxySG).setSslProxy(proxySG).setSocksProxy(proxySG);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setProxy(proxy);

        WebDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(2000);

    }

    public String returnDomainFromUrl(String urlText) {
        String[] splitUrl = urlText.split("\\.");
        return splitUrl[1];
    }

    public String choseActiveElement(WebDriver driverThis, String xpath1, String xpath2, String xpath3) {
        if (isElementPresent(xpath1, driverThis)) {
            System.out.println("xpath1 works");
            return xpath1;
        }
        if (isElementPresent(xpath2, driverThis)) {
            System.out.println("xpath2 works");
            return xpath2;
        }
        if (isElementPresent(xpath3, driverThis)) {
            System.out.println("xpath3 works");
            return xpath3;
        }
        System.out.println("All of this xpath not active");
        return "";
    }

    public String choseActiveElement(WebDriver driverThis, String xpath1, String xpath2) {
        if (isElementPresent(xpath1, driverThis)) {
            System.out.println("xpath1 works");
            return xpath1;
        }
        if (isElementPresent(xpath2, driverThis)) {
            System.out.println("xpath2 works");
            return xpath2;
        }
        System.out.println("All of this xpath not active");
        return "";
    }

    public Boolean isElementPresent(String xpath, WebDriver driverThis) {
        return driverThis.findElements(By.xpath(xpath)).size() != 0;
    }
    protected boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    protected void doLogging(String stringToLog){
        System.out.println(stringToLog);
    }

}
