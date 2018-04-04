package regs;

import Admin.TestBase;
import Admin.MakeUsersLikeTest;
import Patterns.CSV.CsvCell;
import Patterns.CSV.ReadCSV4colon;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

public class WebIndexFromFile extends TestBase {


    public WebIndexFromFile() throws IOException, InterruptedException {
        super();
    }

    @Override
    protected void beforeTest() throws IOException {
        log("before test");
        int counter;
    }

    @Test
    public void makeRegistrationWeb() throws Exception {
        for (int i = 1; i < regInfo.size(); i++) {
            log("beginning of the registration cycle by row " + i);
            for (int j = 0; j < regInfo.get(i).getCounterOfRegistration(); j++) {
                log("beginning of the registration cycle by counter of reg " + j);
                this.driver.get(regInfo.get(i).getLink());
                log("Set ip address");
                writeIpAddressToCookie(regInfo.get(i).getIp_address());
                Thread.sleep(1000);
                log("Set gender");
                click(choseGender(regInfo.get(i).getNumberOfGenderValue()));
                log("Set age");
                choseCorrectedDOBandSetAge();
                String emailForRegistration = generateRandomEmail();
                log("Type email " + emailForRegistration);
                type(choseActiveElement("//div[@class='field_box']/input[@id='UserForm_email']", "//input[@id='email-field']"), emailForRegistration);
                log("Type password");
                type(choseActiveElement("//input[@class='frm-password']", " //input[@id='password-field']"), "111111");
                log("Check checkbox of Terms and click if it available");
                checkCheckboxOfTerms();
                log("click submit");
                click(choseActiveElement(this.driver, "//*[@id='submit-btn']", "//div[@class='submit_button']/button[@id='submit_button']", "button[@id='submit_button']"));
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

    @Override
    public void afterTest() throws Exception {
        log("After test");
        String emails = "";
        for (int i = 0; i < emailOfUsers.size(); i++) {
            emails += emailOfUsers.get(i) + "\n";
        }
        System.out.println(emails);
        makeUsersLikeTest(emailOfUsers);
        log("Close driver");
    }

    private String choseGender(int numberOfGender) throws IOException {
        // 1 - male
        // 2 - female
        if (numberOfGender == 1) {
            log("male sated");
            return choseActiveElement(this.driver, "//option[@value='male-female']", "//span[contains(@class,'gender_m')]", "//option[@value='male']");
        }
        if (numberOfGender == 2) {
            log("female sated");
            return choseActiveElement(this.driver, "//option[@value='female-male']", "//span[contains(@class,'gender_w')]", "//option[@value='female']");
        }
        log("wrong value of gender so sated male");
        return choseActiveElement(this.driver, "//option[@value='male-female']", "//span[contains(@class,'gender_m')]", "//option[@value='male']");
    }


    public void makeUsersLikeTest(ArrayList<String> emailOfusers) throws Exception {
        MakeUsersLikeTest makeUsersLikeTest = new MakeUsersLikeTest();
        makeUsersLikeTest.makeUserAsTests(emailOfusers);
    }


    public void click(String xpath) {
        this.driver.findElement(By.xpath(xpath)).click();
    }

    public void type(String xpath, String text) {
        this.driver.findElement(By.xpath(xpath)).clear();
        this.driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public String generateRandomEmail() {
        SimpleDateFormat sf = new SimpleDateFormat("dd-HH_mm.ss");
        Date date = new Date();
        return sf.format(date) + "tn@maildrop.ropot.net";
    }

    public void choseCorrectedDOBandSetAge() {
        if (isElementPresent("//select[@id='UserForm_month']")) {
            System.out.println("this is old DOB");
            click("//select[@id='UserForm_day']/option[@value='01']");
            click("//select[@id='UserForm_month']/option[@value='01']");
            click("//select[@id='UserForm_year']/option[@value='1999']");
        } else {
            System.out.println("this is new DOB");
            click("//option[@value='18']");
        }
    }

    public void checkCheckboxOfTerms() {
        if (isElementPresent("//div[@id='terms_check']/label")) {
            click("//div[@id='terms_check']/label");
        }
    }
}
