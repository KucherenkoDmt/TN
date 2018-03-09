package Patterns.Screepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.XpiDriverService;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Screepts {
    WebDriver driver;

    public static void main(String[] args) {
        Screepts screepts = new Screepts();
        screepts.firefoxAcc();
    }

    public void screenshot() {

    }

    public void firefoxAcc() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("MySelenium");

        System.setProperty("webdriver.gecko.driver", "Z:\\Soft\\firefoxdriver\\geckodriver.exe");
        driver = new FirefoxDriver( /*myProfile*/);
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
}
