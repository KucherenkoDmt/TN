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

public class LpToSuccess {
    WebDriver driver = new FirefoxDriver();
    Logger lg = new ConsoleLogger();
    List lp = Reader.reader("FileForRead.txt");
    int counter = 0;
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public LpToSuccess() throws IOException {
    }

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        LpToSuccess lpToSuccess = new LpToSuccess();

           lpToSuccess.enterToPhenix();
        //  Thread.sleep(10000);

        lpToSuccess.makeLpTestSuccess();

    }

    public void makeLpTestSuccess() throws IOException, InterruptedException {

        lg.log("Open phenix");
        driver.get("https://my.platformphoenix.com/landing/pageList");
        Thread.sleep(10000);
        driver.manage().logs();
        lg.log("Open phenix lp page");
        Thread.sleep(10000);
       driver.switchTo().parentFrame();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@href='/landing/pageList']")));

        System.out.println(driver.getCurrentUrl());


        System.out.println(lp.get(counter));
        String urlLP = "https://my.platformphoenix.com/landing/pageList?ArrayProviderLandingFilterForm[landingId]=&ArrayProviderLandingFilterForm[name]=" + lp.get(counter) + "";
        System.out.println(urlLP);

        lg.log("Open phenix lp page with lp");
        driver.navigate().to(urlLP);
        driver.get(urlLP);
        Thread.sleep(10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + lp.get(counter) + "')]/following-sibling::td[text()='testing']/following::*/a[text()=\"[test success]\"]")));

        lg.log("Made LP test success");
        driver.findElement(By.xpath("//*[contains(text(),'" + lp.get(counter) + "')]/following-sibling::td[text()='testing']/following::*/a[text()=\"[test success]\"]")).click();

        lg.log("Check of success");
        assertEquals("testSuccess", driver.findElement(By.xpath("//*[contains(text(),'${LP}')]/following-sibling::td[text()='testSuccess']")).getText());
    }

    private void enterToPhenix() throws IOException, AWTException, InterruptedException {


        lg.log("Open phenix");
        driver.get("https://dmitrii.kucherenko:Zz0981316396(^@my.platformphoenix.com");
        //  driver.get("https://my.platformphoenix.com");
      /*  Alert alert = driver.switchTo().alert();
        lg.log("Add login");
        alert.sendKeys(MyData.login);

        lg.log("switch field");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_Z);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.keyPress(KeyEvent.VK_Z);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyPress(KeyEvent.VK_9);
        robot.keyPress(KeyEvent.VK_8);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_3);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_6);
        robot.keyPress(KeyEvent.VK_3);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.keyPress(KeyEvent.VK_9);
        robot.keyPress(KeyEvent.VK_6);
        robot.keyPress(KeyEvent.VK_SHIFT+KeyEvent.VK_9);
        robot.keyPress(KeyEvent.VK_SHIFT+KeyEvent.VK_6);*/





        Thread.sleep(5000);
        lg.log("Add password");
        //driver.switchTo().alert().sendKeys("dsf");


        lg.log("Submit");
     //   driver.switchTo().alert().accept();

        //*/

    }
}
