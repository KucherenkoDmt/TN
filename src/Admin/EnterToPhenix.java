package Admin;

import Patterns.Log.AbstractLogger;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DriverCommand;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.rmi.Remote;



public class EnterToPhenix extends AbstractLogger {


    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://my.platformphoenix.com/");
        Runtime.getRuntime().exec("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\AutoITScrpt\\HandleAuthentication.exe");
        Thread.sleep(5000);


    }
        @Override
    protected void doLogging(String stringToLog) throws IOException {
        System.out.println(stringToLog);
    }
}
