package GenerateBySeleniumIDE;

import javafx.scene.control.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class OdnoklikGBS {

    public class NewTest {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "https://www.katalon.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testNew() throws Exception {
            String i = "1";
            String x = "1";
            String count = "500";
            // ERROR: Caught exception [ERROR: Unsupported command [while | storedVars['i']<=storedVars['count'] | ]]
            String index = "iamnaughty.com";
            driver.get("http://m." + index);
            driver.findElement(By.id("showRegForm")).click();
            driver.findElement(By.id("UserForm_login")).clear();
            driver.findElement(By.id("UserForm_login")).sendKeys("qq");
            new Select(driver.findElement(By.id("UserForm_age"))).selectByVisibleText("18");
            //runScript | document.cookie = "ip_address=81.159.113.252; path=/; expires=2020-01-01 00:00:00:0" | ]]
            //runScript | var locator = document.getElementById('UserForm_location');&nbsp;&nbsp;locator.value='London'; | ]]
            //getEval | {new Date().getTime()} | ]]
            String random_mail = "mob" + "date_for_mail" + "@maildrop.ropot.net";
            System.out.println(random_mail);
            driver.findElement(By.xpath(".//*[@id='UserForm_email']")).clear();
            driver.findElement(By.xpath(".//*[@id='UserForm_email']")).sendKeys(random_mail);
            driver.findElement(By.id("UserForm_password")).clear();
            driver.findElement(By.id("UserForm_password")).sendKeys("Q1!@_-");
            driver.findElement(By.id("btn_register_submit")).click();

            System.out.println("${user_id}");
         String output = "";
            // storedVars['output']= storedVars['user_id'].split("m.").pop().split("/").shift(); | ]]
            String transfer_to = "&transfer_to=" + output;
            String locale = "&locale=en";
            String source = "&source=" + index;
            driver.get(baseUrl + "${user_id}" + source + transfer_to + locale);
            // ERROR: Caught exception [ERROR: Unsupported command [runScript | document.cookie = "ip_address=81.159.113.252; path=/; expires=2020-01-01 00:00:00:0" | ]]
            // ERROR: Caught exception [ERROR: Unsupported command [getEval | if (selenium.isElementPresent('id=one_click_btn') == true) {nextMove = 'label1'}&nbsp;&nbsp;if (selenium.isElementPresent('id=join_button') == true) {nextMove = 'label2'} | ]]
            // ERROR: Caught exception [unknown command [gotolabel]]
            // ERROR: Caught exception [ERROR: Unsupported command [label | label1 | ]]
            driver.findElement(By.xpath("//*[contains(@class,'one_click_btn')]")).click();
            // ERROR: Caught exception [unknown command [gotolabel]]
            // ERROR: Caught exception [ERROR: Unsupported command [label | label2 | ]]
            driver.findElement(By.id("join_button")).click();
            // ERROR: Caught exception [unknown command [gotolabel]]
            // ERROR: Caught exception [ERROR: Unsupported command [label | finish | ]]
            driver.get("https://my.platformphoenix.com/user/find");
            driver.findElement(By.id("FindUserForm_user")).clear();
            driver.findElement(By.id("FindUserForm_user")).sendKeys(random_mail);
            driver.findElement(By.name("yt0")).click();
            driver.findElement(By.xpath("//*[@id='main-layout']/div/div/div[2]/div[10]/div/a[1]")).click();
            String source_id = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr[1]/td[3]")).getText();
            String source_index_name = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr[1]/td[4]")).getText();
            String transfer = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr[2]/td[3]")).getText();
            String transfer_index_name = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr[2]/td[4]")).getText();
            String user_email = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[3]/td")).getText();
            String reg_url = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[45]/td")).getText();
            System.out.println("source_id: " + source_id + " | " + source_index_name + " | trasfer " + transfer + " | " + transfer_index_name + " | " + user_email + " | URL: " + reg_url);
            System.out.println("${user_id}");
            driver.get("http://www." + index);
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='account_index']/div[2] | //*[@id='menuAvatar']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='account_index']/div[2] | //*[@id='menuAvatar']")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='account_index']/div[2] | //*[@id='toolbarRside']/a"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='account_index']/div[2] | //*[@id='toolbarRside']/a")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='logoutButton']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='logoutButton']")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='popupLogoutConfirmYes']/div/div"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='popupLogoutConfirmYes']/div/div")).click();
            driver.get(baseUrl + "${user_id}");
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='account_index']/div[2] | //*[@id='menuAvatar']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='account_index']/div[2] | //*[@id='menuAvatar']")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='account_index']/div[2] | //*[@id='toolbarRside']/a"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='account_index']/div[2] | //*[@id='toolbarRside']/a")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='logoutButton']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='logoutButton']")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='popupLogoutConfirmYes']/div/div"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//*[@id='popupLogoutConfirmYes']/div/div")).click();
            // ERROR: Caught exception [ERROR: Unsupported command [deleteAllVisibleCookies |  | ]]
            // ERROR: Caught exception [ERROR: Unsupported command [getEval | ${i}+1 | ]]
            System.out.println("");
            // ERROR: Caught exception [ERROR: Unsupported command [endWhile |  | ]]
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                String alertText = driver.switchTo().alert().getText();

                if (acceptNextAlert) {
                    driver.switchTo().alert().accept();
                } else {
                    driver.switchTo().alert().dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
}
