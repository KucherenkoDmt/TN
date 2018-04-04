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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractLogger {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected List<CsvCell> regInfo;
    protected ArrayList<String> emailOfUsers = new ArrayList<>();

    public TestBase() throws IOException, InterruptedException {
    }

    @Before
    public void setUp() throws InterruptedException, IOException {
        this.driver = new ChromeDriver();
        log("Before test");
        regInfo = ReadCSV4colon.csvDataRead();
        log("reg info is readed and have row :" + regInfo.size());
        wait = new WebDriverWait(this.driver, 15);
        this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        beforeTest();
    }
    protected void beforeTest() throws InterruptedException, IOException {}

    @After
    public void tearDown() throws Exception {
        afterTest();
        this.driver.quit();
    }

    protected void afterTest() throws Exception {}

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

    public void writeIpAddressToCookie(String ip_address){
        driver.manage().addCookie(new Cookie("ip_address", ip_address));
        driver.navigate().refresh();
    }

    public String returnDomainFromUrl(String urlText) {
        String[] splitUrl = urlText.split("\\.");
        return splitUrl[1];
    }

    public String choseActiveElement(WebDriver driverThis, String xpath1, String xpath2, String xpath3) throws IOException {
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

    public String choseActiveElement(String xpath1, String xpath2) throws IOException {
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

    public Boolean isElementPresent(String xpath) {
        return this.driver.findElements(By.xpath(xpath)).size() != 0;
    }
    public void emulateMobile() throws InterruptedException {
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);
        driver.get("https://m.flirt.com/");
    }

        @Override
    protected void doLogging(String stringToLog) throws IOException {
        System.out.println(stringToLog);
    }

}
