package Patterns.Screepts;


import Admin.BasicClass;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Screepts extends BasicClass{
    WebDriver driver = new  FirefoxDriver();


    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        Screepts screepts = new Screepts();
      //  screepts.getPhenixCookie();
        screepts.emulateMobile();


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
        super.enterToPhenix(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<Cookie> totalCookies = driver.manage().getCookies();
        System.out.println("Total Number Of cookies : " + totalCookies.size());

        for (Cookie currentCookie : totalCookies) {
            System.out.println(String.format("%s -> %s -> %s -> %s", "Domain Name : " + currentCookie.getDomain(),
                    "Cookie Name : " + currentCookie.getName(), "Cookie Value : " + currentCookie.getValue(), "Cookie Expiry : "
                            + currentCookie.getExpiry()));
         //   driver.manage().deleteCookieNamed(currentCookie.getName());
        }
        driver.close();
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
        driver.manage().window().maximize();
       // enter to site
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<Cookie> totalCookies = driver.manage().getCookies();
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
        driver.manage().addCookie(name);
        System.out.println();
    }
    public void deleteCookie(){

        driver.manage().deleteCookieNamed("testCoockie");
    }


    public void proxy(){
        String PROXY = "localhost:8080";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY).setSocksProxy(PROXY);
        DesiredCapabilities cap =new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);
     //   fprofile.setPreference("general.useragent.override", "iPhone");
        driver = new FirefoxDriver();
    }

    public void screenshot() {

    }

    public void firefoxAcc() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("MySelenium");

        System.setProperty("webdriver.gecko.driver", "Z:\\Soft\\firefoxdriver\\geckodriver.exe");
       FirefoxOptions firefoxOptions = new FirefoxOptions((Capabilities) profile);
        driver = new FirefoxDriver(/*myProfile*/);
        driver.get("https://www.google.com.ua/?hl=ru");
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
    protected void enterToPhoenixByCrome(WebDriver driverThis) throws IOException, AWTException, InterruptedException {
        System.out.println("Open phoenix");
        driverThis.get("https://my.platformphoenix.com/");
        System.out.println("1");

        //driverThis.switchTo().alert().sendKeys("log");
        System.out.println("2");
        Runtime.getRuntime().exec("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\AutoITScrpt\\Chrome.exe");

        Thread.sleep(1000);
        driverThis.switchTo().alert().accept();
        System.out.println("Success login to phoenix");
        Thread.sleep(5000);
        new WebDriverWait(driverThis, 15).until(ExpectedConditions.titleIs("My Application - Base"));
    }
}
