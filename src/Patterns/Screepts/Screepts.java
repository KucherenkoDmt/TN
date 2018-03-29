package Patterns.Screepts;


import Admin.BasicClass;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpRequest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Screepts extends BasicClass{
    WebDriver driverFF;
    WebDriver driverCR;


    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        Screepts screepts = new Screepts();
      //  screepts.getPhenixCookie();
        screepts.proxyCR();
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

    public void getPhenixCookie() throws AWTException, InterruptedException, IOException {

        super.enterToPhenix(driverFF);
        driverFF.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<Cookie> totalCookies = driverFF.manage().getCookies();
        System.out.println("Total Number Of cookies : " + totalCookies.size());

        for (Cookie currentCookie : totalCookies) {
            System.out.println(String.format("%s -> %s -> %s -> %s", "Domain Name : " + currentCookie.getDomain(),
                    "Cookie Name : " + currentCookie.getName(), "Cookie Value : " + currentCookie.getValue(), "Cookie Expiry : "
                            + currentCookie.getExpiry()));
         //   driver.manage().deleteCookieNamed(currentCookie.getName());
        }
        driverFF.close();
        WebDriver driver2 = new  FirefoxDriver();

        log("close and open driver");
        Thread.sleep(3000);
      //  driver2.get("https://my.platformphoenix.com/");
        for (Cookie currentCookie : totalCookies) {
            Cookie name = new Cookie(currentCookie.getName(), currentCookie.getValue());
            driver2.manage().addCookie(name);
        }
        driver2.get("https://my.platformphoenix.com/");
    }

    public void getCookie() throws AWTException, InterruptedException, IOException {
        driverFF.manage().window().maximize();
       // enter to site
        driverFF.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<Cookie> totalCookies = driverFF.manage().getCookies();
        System.out.println("Total Number Of cookies : " + totalCookies.size());

        for (Cookie currentCookie : totalCookies) {
            System.out.println(String.format("%s -> %s -> %s -> %s", "Domain Name : " + currentCookie.getDomain(),
                    "Cookie Name : " + currentCookie.getName(), "Cookie Value : " + currentCookie.getValue(), "Cookie Expiry : "
                            + currentCookie.getExpiry()));
        }
    }

    public void setCookie() throws AWTException, InterruptedException, IOException {
       // enter to site
        Cookie name = new Cookie("testCoockie", "WSfed-ffsd-234DFGe-YUTYU");
        driverFF.manage().addCookie(name);
        System.out.println();
    }
    public void setLocByCookie() throws AWTException, InterruptedException, IOException {
        // enter to site
        driverCR.get("https://www.flirt.com");
        Thread.sleep(3000);
        driverCR.manage().deleteCookieNamed("locale");
        driverCR.manage().deleteCookieNamed("locale:");

        driverCR.manage().deleteAllCookies();
        Thread.sleep(1000);
        Cookie loc = new Cookie("locale:", "es", ".flirt.com", "/", null, true, true);
        Cookie loc1 = new Cookie("locale", "es", ".flirt.com", "/", null, true, true);

        driverCR.manage().addCookie(loc);

        Thread.sleep(1000);

        driverCR.manage().addCookie(loc1);
        driverCR.manage().addCookie(loc);

        driverCR.navigate().refresh();

        System.out.println();
    }

    public void deleteCookie(){

        driverFF.manage().deleteCookieNamed("testCoockie");
    }

    public void proxyFF() throws InterruptedException {
        driverFF = new FirefoxDriver();
        String PROXY = "185.145.202.171:3128";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY).setSocksProxy(PROXY);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);
        FirefoxOptions firefoxOptions = new FirefoxOptions().merge(cap);
        driverFF = new FirefoxDriver(firefoxOptions);
        Thread.sleep(2000);
        driverFF.get("https://2ip.ru/");
    }

    public void proxyCR() throws InterruptedException{

        String proxySG = "185.145.202.171:3128";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxySG).setFtpProxy(proxySG).setSslProxy(proxySG).setSocksProxy(proxySG);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setProxy(proxy);

        WebDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(2000);
        driver.get("https://2ip.ru");
    }


    public void screenshot() throws IOException {
        File screenshot = ((TakesScreenshot)this.driverFF).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Z:\\selenium\\Screen\\screenshot.jpg"));
    }

    public void firefoxAcc() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("MySelenium");

        System.setProperty("webdriver.gecko.driver", "Z:\\Soft\\firefoxdriver\\geckodriver.exe");
       FirefoxOptions firefoxOptions = new FirefoxOptions((Capabilities) myProfile);
        driverFF = new FirefoxDriver(firefoxOptions);
        driverFF.get("https://www.google.com.ua/?hl=ru");
    }

    public String returnDomainFromUrl(String url, WebDriver driverThis) {
        driverThis.get(url); //or take current domain
        JavascriptExecutor javascript = (JavascriptExecutor) driverThis;
        String DomainUsingJS = (String) javascript.executeScript("return document.domain");
        System.out.println("My Current URL Is  : " + DomainUsingJS);
        return DomainUsingJS;
    }

    public void isElementPresent(WebDriver driverThis) {
        Boolean isElementPresent = driverThis.findElements(By.xpath("some xpath")).size() != 0;
    }
}
