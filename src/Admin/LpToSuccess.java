package Admin;

import Patterns.Log.ConsoleLogger;
import Patterns.Log.Logger;
import Patterns.Log.TextAndFileLogger;
import Patterns.Reader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LpToSuccess extends BasicClaas {
    WebDriver driver = new FirefoxDriver();
    Logger lg = new ConsoleLogger();
    List<String> lp = Reader.reader("FileForRead.txt");
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public LpToSuccess() throws IOException {
    }

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        LpToSuccess lpToSuccess = new LpToSuccess();
        lpToSuccess.makeLpTestSuccess();
    }

    public void makeLpTestSuccess() throws IOException, InterruptedException, AWTException {
        super.enterToPhenix(driver);
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        lg.log("Open phenix pageList");
        driver.get("https://my.platformphoenix.com/landing/pageList");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@href='/landing/pageList']")));
        lg.log("Start of making succsess status for LP");

        for (int i = 0; i < lp.size(); i++) {
            lg.log("Current LP is: " + lp.get(i));
            String urlLP = "https://my.platformphoenix.com/landing/pageList?ArrayProviderLandingFilterForm[landingId]=&ArrayProviderLandingFilterForm[name]=" + lp.get(i) + "";
            System.out.println(urlLP);
            driver.get(urlLP);
            wait.until(ExpectedConditions.titleIs("My Application - PageList Landing"));
            Thread.sleep(1000);

            String status = driver.findElement(By.xpath("//*[contains(text(),'" + lp.get(i) + "')]/following-sibling::td[7]")).getText();
            lg.log("Status of lp is: " + status);
            Thread.sleep(1000);
            if (lp.get(i).isEmpty()) {
                lg.log("Empty line");
                continue;
            }
            if (!status.equals("testing")) {
                lg.log("Status's Lp isn't testing");
                continue;
            } else {
                lg.log("Made LP test success");
                driver.findElement(By.xpath("//*[contains(text(),'" + lp.get(i) + "')]/following-sibling::td[text()='testing']/following::*/a[text()=\"[test success]\"]")).click();
                Thread.sleep(7000);

                lg.log("Check of success");
                assertEquals("testSuccess", driver.findElement(By.xpath("//*[contains(text()," + lp.get(i) + ")]/following-sibling::td[7]")).getText());
                lg.log("Next LP");
            }
            driver.quit();
        }
    }
}
