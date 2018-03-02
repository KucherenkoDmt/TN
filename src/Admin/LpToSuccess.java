package Admin;

import Patterns.Log.ConsoleLogger;
import Patterns.Log.Logger;
import Patterns.Log.TextAndFileLogger;
import Patterns.Reader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LpToSuccess {
    WebDriver driver = new FirefoxDriver();
    Logger lg = new ConsoleLogger();
    List lp = Reader.reader("FileForRead.txt");
    int counter = 0;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public LpToSuccess() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        LpToSuccess lpToSuccess = new LpToSuccess();
       // lpToSuccess.makeLpTestSuccess();
        lpToSuccess.enterToPhenix();


    }

    public void makeLpTestSuccess() throws IOException {
        lg.log("Open phenix");
        driver.get("https://my.platformphoenix.com/landing/pageList?ArrayProviderLandingFilterForm[landingId]=&ArrayProviderLandingFilterForm[name]=" + lp.get(counter) + "");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + lp.get(counter) + "')]/following-sibling::td[text()='testing']/following::*/a[text()=\"[test success]\"]")));

        lg.log("Made LP test success");
        driver.findElement(By.xpath("//*[contains(text(),'" + lp.get(counter) + "')]/following-sibling::td[text()='testing']/following::*/a[text()=\"[test success]\"]")).click();

        lg.log("Check of success");
        assertEquals("testSuccess", driver.findElement(By.xpath("//*[contains(text(),'${LP}')]/following-sibling::td[text()='testSuccess']")).getText());
    }
    private void enterToPhenix (){
        driver.get("https://my.platformphoenix.com");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("dmitrii.kucherenko");


        //driver.switchTo().alert().accept();


//нужно реализовать ввод пароля, логина + сабмит
    }
}
