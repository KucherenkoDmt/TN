package GenerateBySeleniumIDE;

    import java.util.concurrent.TimeUnit;
    import org.junit.Before;
    import org.junit.Test;
    import org.openqa.selenium.*;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.junit.*;

    import static org.junit.Assert.*;

public class MakeUsersLikeTestsGBS {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

       @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "tn";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testMakeUsersLikeTests() throws Exception {
            String i = "1";
            String x = "1";
            String count = "500";
            // ERROR: Caught exception [unknown command [while]]
            // ERROR: Caught exception [unknown command [readCSV]]
            // ERROR: Caught exception [unknown command [storeCellValue]]
            // Open domain
            System.out.println("domain#${url}");
            driver.get("https://my.platformphoenix.com/user/find");
            driver.findElement(By.id("FindUserForm_user")).clear();
            driver.findElement(By.id("FindUserForm_user")).sendKeys("${url}");
            driver.findElement(By.name("yt0")).click();
            driver.findElement(By.xpath("//a[text()=\"Mark all as testers\"]")).click();
            String user_id = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr/td[3]")).getText();
            String user_email = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[3]/td")).getText();
            String reg_url = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[45]/td")).getText();
            String gender = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[14]/td")).getText();
            String orientation = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[15]/td")).getText();
            String LOC = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[18]/td")).getText();
            String trafic_souce = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[42]/td")).getText();
           /* try {
                assertThat("unknown", !(driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[46]/td")).getText()));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }*/
            String lid = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[46]/td")).getText();
            System.out.println("reg url: " + reg_url + " | Id: " + user_id + " |  user email: " + user_email + " |  lid: " + lid + " | gender: " + gender + " | orientation: " + orientation + " | loc: " + LOC + " | trafic_souce: " + trafic_souce);
            // конец цикла
            // ERROR: Caught exception [ERROR: Unsupported command [getEval | ${i}+1 | ]]
            // ERROR: Caught exception [unknown command [endWhile]]
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
