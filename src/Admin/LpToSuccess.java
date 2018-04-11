package Admin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LpToSuccess extends BasicClase {
    WebDriver driver = new FirefoxDriver();
    List<String> lp = super.readerTxtFile("FileForRead.txt");
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public LpToSuccess() throws IOException, InterruptedException {
        super();
    }

    @Test
    public void makeLpTestSuccess() throws IOException, InterruptedException, AWTException {
        super.enterToPhenix(driver);
        driver.manage().window().maximize();

        log("Start of making success status for LP");
        String notTestingStetusLp = "";
        String landingPage = "";
        for (int i = 0; i < lp.size(); i++) {
            landingPage = lp.get(i).trim();
            log("Current LP is: " + landingPage);
            String urlLP = "https://my.platformphoenix.com/landing/pageList?ArrayProviderLandingFilterForm[landingId]=&ArrayProviderLandingFilterForm[name]=" + landingPage + "";
            System.out.println(urlLP);
            driver.get(urlLP);
            wait.until(ExpectedConditions.titleIs("My Application - PageList Landing"));
            Thread.sleep(1000);

            String status = driver.findElement(By.xpath("//td[text()='" + landingPage + "']/following-sibling::td[7]")).getText();
            log("Status of lp is: " + status);
            Thread.sleep(500);
            if (lp.get(i).isEmpty()) {
                log("Empty line");
                continue;
            }
            if (!status.equals("testing")) {
                log("Status Lp isn't testing");
                notTestingStetusLp += ("Lp: " + landingPage + " status is " + status + "\n");
                continue;
            } else {
                log("Made LP test success");
                driver.findElement(By.xpath("//*[text()='" + landingPage + "']/following::a[text()=\"[action]\"]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[text()='" + landingPage + "']/following::*/a[text()=\"[test success]\"]")).click();
                Thread.sleep(2000);
                //нужно вейтер добавить

                log("Check of success");
                assertEquals("testSuccess", driver.findElement(By.xpath("//*[text()='" + landingPage + "']/following-sibling::td[7]")).getText());
                log("Next LP");
            }

        }
        log("Not successed LP is: " + "\n" + notTestingStetusLp);
        driver.quit();
    }
}
