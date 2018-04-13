package regs;

import Admin.MakeUsersLikeTest;
import Patterns.CSV.CsvCell;
import Patterns.CSV.ReadCSV4colon;
import Patterns.Log.ConsoleLogger;
import Patterns.Log.TextAndFileLogger;
import com.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    @Before
    public void setUp() throws InterruptedException, IOException {
        beforeTestBefore();
        log("Before test");
        regInfo = csvDataRead();
        log("reg info is readed and have row :" + (regInfo.size()-1));
        wait = new WebDriverWait(this.driver, 15);
        this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        beforeTestAfter();
    }
    protected void beforeTestBefore() throws InterruptedException {}
    protected void beforeTestAfter() {}

    @After
    public void tearDown() throws Exception {
        log("After test");
        String emails = "";
        for (int i = 0; i < emailOfUsers.size(); i++) {
            emails += emailOfUsers.get(i) + "\n";
        }
        logConsolAndLogFile(emails);
        makeUsersLikeTest(emailOfUsers);
        log("Close driver");
        afterTest();
        this.driver.quit();
    }
    protected void afterTest() throws Exception {
    }

    protected boolean isElementPresent(By by) {
        try {
            this.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void makeUsersLikeTest(ArrayList<String> emailOfusers) throws Exception {
        MakeUsersLikeTest makeUsersLikeTest = new MakeUsersLikeTest();
        makeUsersLikeTest.makeUserAsTests(emailOfusers);
    }

    protected List<CsvCell> csvDataRead() throws InterruptedException, IOException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\TN\\InfoForTesting.csv"));
        String[] csvCell;
        List<CsvCell> list = new ArrayList<>();
        while ((csvCell = reader.readNext()) != null) {
            CsvCell csvCell1 = new CsvCell(csvCell[0], csvCell[1], csvCell[2], csvCell[3], csvCell[4]);
            list.add(csvCell1);
        }
        return list;
    }

    protected void writeIpAddressToCookie(String ip_address) {
        driver.manage().addCookie(new Cookie("ip_address", ip_address));
        driver.navigate().refresh();
    }

    protected String choseActiveElement(String xpath1, String xpath2, String xpath3) {
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

    protected String choseActiveElement(String xpath1, String xpath2)  {
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

    protected void log(String stringToLog){
        ConsoleLogger consoleLogger = new ConsoleLogger();
        consoleLogger.log(stringToLog);
    }

    protected void logConsolAndLogFile(String stringToLog){
        TextAndFileLogger textAndFileLogger = new TextAndFileLogger();
        textAndFileLogger.log(stringToLog);
    }

    protected String chooseEmailForTest(String emailOfUser){
        if(emailOfUser.length()<2){
            return generateRandomEmail();
        }
        else return emailOfUser;
    }

    public void choseCorrectedDOBandSetAge() {
        if (isElementPresent("//select[@id='UserForm_month']")) {
            log("this is old DOB");
            click("//select[@id='UserForm_day']/option[@value='01']");
            click("//select[@id='UserForm_month']/option[@value='01']");
            click("//select[@id='UserForm_year']/option[@value='1999']");
        } else {
            log("this is new DOB");
            click("//option[@value='26']");
        }
    }

    protected void enterToPhenix() throws InterruptedException, IOException {
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

    protected void forScreen(WebDriver driverThis) throws IOException {
        File screenshot = ((TakesScreenshot) driverThis).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Z:\\selenium\\Screen\\screenshot.jpg"));
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

    protected String returnDomainFromUrl(String urlText) {
        String[] splitUrl = urlText.split("\\.");
        return splitUrl[1];
    }

}
