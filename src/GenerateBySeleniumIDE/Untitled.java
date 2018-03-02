package GenerateBySeleniumIDE;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Untitled {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.flirt.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("span.gender_w.selected")).click();
        new Select(driver.findElement(By.id("UserForm_age"))).selectByVisibleText("18");
        driver.findElement(By.id("UserForm_email")).clear();
        driver.findElement(By.id("UserForm_email")).sendKeys("6+01_03.1together@maildrop.ropot.net");
        driver.findElement(By.id("UserForm_password")).clear();
        driver.findElement(By.id("UserForm_password")).sendKeys("111111");
        driver.findElement(By.id("submit_button")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
        driver.findElement(By.id("FindUserForm_user")).clear();
        driver.findElement(By.id("FindUserForm_user")).sendKeys("6");
        driver.findElement(By.id("FindUserForm_user")).clear();
        driver.findElement(By.id("FindUserForm_user")).sendKeys("6+01_03.1together@maildrop.ropot.net");
        driver.findElement(By.name("yt0")).click();
        driver.findElement(By.linkText("Mark all as testers")).click();
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
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}