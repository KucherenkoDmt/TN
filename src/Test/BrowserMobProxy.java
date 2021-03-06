package Test;


import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;



public class BrowserMobProxy {

    ProxyServer server = new ProxyServer(4444);
   // com.ning.http.client.ProxyServer server = new com.ning.http.client.ProxyServer(4444);
    private WebDriver driver;

    @Before
    public void startProxy() throws Exception {
        BrowserMobProxyServer proxy = new BrowserMobProxyServer();
        proxy.start(0);
        server = new ProxyServer(4444);
        server.start();
        server.autoBasicAuthorization("https://my.platformphoenix.com", "username", "password");
      //  Proxy proxy = server.seleniumProxy();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        FirefoxOptions test = new FirefoxOptions().merge(capabilities);
        driver = new FirefoxDriver(test);

    }

    @Test
    public void testAccessProtectedSite() throws Exception {
        driver.get("https://example.com");
        driver.findElement(By.className("sign-out"));
    }

    @After
    public void stopProxyServer() throws Exception {
        driver.quit();
        server.stop();
    }

}

/*
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
*/

