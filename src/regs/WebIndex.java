package regs;

import Admin.BasicClase;
import Admin.TestBase;
import Admin.MakeUsersLikeTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebIndex extends BasicClase {
    WebDriver driver;
    WebDriverWait wait;
    List<String> urlOfIndex = super.readerTxtFile("FileForRead.txt");
  //   List<CsvCell> regInfo = ReadCSV4colon.csvDataRead();

    ArrayList<String> emailOfUsers = new ArrayList<>();
    int numberOfRegistration = 1;

    public WebIndex() throws IOException, InterruptedException {
    }

    @Before
    public void beforeTest() throws InterruptedException {
        this.driver = new ChromeDriver(setIp());
        wait = new WebDriverWait(this.driver, 15);
        this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void regs() throws Exception {
        for (int i = 0; i < urlOfIndex.size(); i++) {
            for (int j = 0; j < numberOfRegistration; j++) {
                log("Open index");
                this.driver.get(urlOfIndex.get(i));
                Thread.sleep(2000);
                log("Set gender");
                click(choseActiveElement(this.driver, "//option[@value='female-male']", "//span[@class='gender_w selected']", "//option[@value='female']"));
                log("Set age");
                choseCorrectedDOBandSetAge();
                String emailForRegistration = generateRandomEmail();
                log("Type email " + emailForRegistration);
                type(choseActiveElement(this.driver, "//div[@class='field_box']/input[@id='UserForm_email']", "//input[@id='email-field']"), emailForRegistration);
                log("Type password");
                type(choseActiveElement(this.driver, "//input[@class='frm-password']", " //input[@id='password-field']"), "111111");
                log("Check checkbox of Terms and click if it available");
                checkCheckboxOfTerms();
                log("click submit");
                click(choseActiveElement(this.driver,  "//*[@id='submit-btn']", "//div[@class='submit_button']/button[@id='submit_button']", "button[@id='submit_button']"));
                log("wait until page to load");
                Thread.sleep(5000);
                log("success registration");
                log("add to array email is: " + emailOfUsers.add(emailForRegistration));
                this.driver.manage().deleteAllCookies();
                Thread.sleep(500);
                log("next registration");
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        String emails = "";
        for (int i = 0; i < emailOfUsers.size(); i++) {
            emails += emailOfUsers.get(i) + "\n";
        }
        System.out.println(emails);
        makeUsersLikeTest(emailOfUsers);
        log("Close driver");
        driver.quit();
    }

    public void makeUsersLikeTest(ArrayList<String> emailOfusers) throws Exception {
        MakeUsersLikeTest makeUsersLikeTest = new MakeUsersLikeTest();
        makeUsersLikeTest.makeUserAsTests(emailOfusers);
    }

    public ArrayList<String> getEmailOfUsers() {
        return this.emailOfUsers;
    }

    public ChromeOptions setIp() throws InterruptedException {

        String proxySG = "178.62.117.231:3128";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxySG).setFtpProxy(proxySG).setSslProxy(proxySG).setSocksProxy(proxySG);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setProxy(proxy);
        return chromeOptions;
    }

    public void click(String xpath) {
        this.driver.findElement(By.xpath(xpath)).click();
    }

    public void type(String xpath, String text) {
        this.driver.findElement(By.xpath(xpath)).clear();
        this.driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public String generateRandomEmail() {
        SimpleDateFormat sf = new SimpleDateFormat("+dd-HH_mm.ss");
        Date date = new Date();
        return sf.format(date) + "tn@maildrop.ropot.net";
    }

    public void choseCorrectedDOBandSetAge() {
        if (isElementPresent("//select[@id='UserForm_month']", this.driver)) {
            System.out.println("this is old DOB");
            click("//select[@id='UserForm_day']/option[@value='01']");
            click("//select[@id='UserForm_month']/option[@value='01']");
            click("//select[@id='UserForm_year']/option[@value='1999']");
        }
        else {
            System.out.println("this is new DOB");
            click("//option[@value='18']");
        }
    }

    public void checkCheckboxOfTerms(){
       if(isElementPresent("//div[@id='terms_check']/label", this.driver)){
           click("//div[@id='terms_check']/label");
        }
    }
}
