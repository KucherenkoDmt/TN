package Admin;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;



public class EnterToPhenix extends RemoteWebDriver {


    public static void main(String[] args) {
        EnterToPhenix enterToPhenix = new EnterToPhenix();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://my.platformphoenix.com");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("dmitrii.kucherenko");
      //  System.out.println(alert.getText());
        enterToPhenix.sendKeyss("psw");
    }


    public void sendKeyss(String keysToSend) {
        if(keysToSend==null) {
            throw new IllegalArgumentException("Keys to send should be a not null CharSequence");
        }
        execute(DriverCommand.SET_ALERT_VALUE, ImmutableMap.of("text", keysToSend));
    }
}
