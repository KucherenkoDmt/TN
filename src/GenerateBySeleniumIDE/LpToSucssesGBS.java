package GenerateBySeleniumIDE;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LpToSucssesGBS {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new ChromeDriver();
            baseUrl = "tn";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testUntitled() throws Exception {

            System.out.println("${LP}");
            driver.get("https://my.platformphoenix.com/landing/pageList?ArrayProviderLandingFilterForm[landingId]=&ArrayProviderLandingFilterForm[name]=${LP}");
            driver.findElement(By.xpath("//*[contains(text(),'${LP}')]/following-sibling::td[text()='testing']/following::*/a[text()=\"[test success]\"]")).click();
            assertEquals("testSuccess", driver.findElement(By.xpath("//*[contains(text(),'${LP}')]/following-sibling::td[text()='testSuccess']")).getText());
            // конец цикла


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
        }



