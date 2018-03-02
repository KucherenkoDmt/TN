package Admin;

import Patterns.Log.AbstractLogger;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DriverCommand;


import java.io.IOException;
import java.rmi.Remote;



public class EnterToPhenix extends AbstractLogger {


    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
       // log("Open phenix");
        driver.get("https://my.platformphoenix.com");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("dmitrii.kucherenko");
        System.out.println(alert.getText());



    }

    @Override
    protected void doLogging(String stringToLog) throws IOException {
        System.out.println(stringToLog);
    }
}
