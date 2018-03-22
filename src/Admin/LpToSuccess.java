package Admin;

import Patterns.Reader;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LpToSuccess extends BasicClass {
    WebDriver driver = new FirefoxDriver();
    List<String> lp = Reader.reader("FileForRead.txt");
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public LpToSuccess() throws IOException {
    }

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        LpToSuccess lpToSuccess = new LpToSuccess();
        lpToSuccess.makeLpTestSuccess();
    }
    @Test
    public void makeLpTestSuccess() throws IOException, InterruptedException, AWTException {
        super.enterToPhenix(driver);
        //   System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        log("Open phenix pageList");
        driver.get("https://my.platformphoenix.com/landing/pageList");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@href='/landing/pageList']")));
        log("Start of making success status for LP");
        String notTestingStetusLp = "";
        for (int i = 0; i < lp.size(); i++) {
            log("Current LP is: " + lp.get(i));
            String urlLP = "https://my.platformphoenix.com/landing/pageList?ArrayProviderLandingFilterForm[landingId]=&ArrayProviderLandingFilterForm[name]=" + lp.get(i) + "";
            System.out.println(urlLP);
            driver.get(urlLP);
            wait.until(ExpectedConditions.titleIs("My Application - PageList Landing"));
            Thread.sleep(1000);

            String status = driver.findElement(By.xpath("//*[text()='" + lp.get(i) + "']/following-sibling::td[7]")).getText();
            log("Status of lp is: " + status);
            Thread.sleep(500);
            if (lp.get(i).isEmpty()) {
                log("Empty line");
                continue;
            }
            if (!status.equals("testing")) {
                log("Status Lp isn't testing");
                notTestingStetusLp += ("Lp: " + lp.get(i) + " status is " + status + "\n");
                continue;
            } else {
                log("Made LP test success");
                driver.findElement(By.xpath("//*[text()='" + lp.get(i) + "']/following::a[text()=\"[action]\"]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[text()='" + lp.get(i) + "']/following::*/a[text()=\"[test success]\"]")).click();
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='" + lp.get(i) + "'])")));
                Thread.sleep(2000);

                log("Check of success");
                assertEquals("testSuccess", driver.findElement(By.xpath("//*[text()='" + lp.get(i) + "']/following-sibling::td[7]")).getText());
                log("Next LP");
            }

        }
        log("Not success LP");
        System.out.println(notTestingStetusLp);
        driver.quit();
    }
}
