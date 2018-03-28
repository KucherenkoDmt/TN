package regs;

import Admin.BasicClass;
import Admin.MakeUsersLikeTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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

public class WebIndex extends BasicClass {
    WebDriver driver = new ChromeDriver(setIp());
    WebDriverWait wait = new WebDriverWait( this.driver, 10);
    List<String> urlOfIndex = super.readerTxtFile("FileForRead.txt");
    ArrayList<String> emailOfUsers = new ArrayList<>();
    int numberOfRegistration = 2;

    public WebIndex() throws IOException, InterruptedException {}

    @Test
    public void regs() throws Exception {

        for (int i = 0; i < urlOfIndex.size(); i++) {
            for (int j = 0; j < numberOfRegistration; j++) {

              //  setIp();
                log("Open index");
                this.driver.get(urlOfIndex.get(i));
                Thread.sleep(2500);
                log("Set gender");
                click("//span[@class='gender_w selected']");
                log("Set age");
                click("//select[@name='UserForm[age]']/option[@value='18']");
                log("Type email");
                String emailForRegistration = generateRandomEmail();
                type("//*[@id='UserForm_email']", emailForRegistration);
                log("Type password");
                type("//input[@class='frm-password']", "111111");
                log("click submit");
                click("//button[@id='submit_button']");
                              Thread.sleep(1500);
                log("success registration whit email: " + emailForRegistration);
                this.driver.manage().deleteAllCookies();
                Thread.sleep(2000);
                log("add to array email is: " + emailOfUsers.add(emailForRegistration));

                log("next registration");
            }
        }
    }
    @Test
    public void makeTestsUser() throws Exception {
        makeUsersLikeTest(emailOfUsers);
    }


    public void makeUsersLikeTest(ArrayList<String> emailOfusers) throws Exception {
        MakeUsersLikeTest makeUsersLikeTest = new MakeUsersLikeTest();
        makeUsersLikeTest.makeUserAsTests(emailOfusers);
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
        SimpleDateFormat sf = new SimpleDateFormat("dd-HH_mm.ss+SSS");
        Date date = new Date();
        return sf.format(date) + "tn@maildrop.ropot.net";
    }
}
