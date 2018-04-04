package Test;

import Patterns.CSV.CsvCell;
import Patterns.CSV.ReadCSV4colon;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import sun.java2d.cmm.Profile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Test {
    WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        Test test = new Test();
        test.test();
    }

    public void test() throws IOException, InterruptedException {
       driver = new FirefoxDriver();
       driver.get("https://my.platformphoenix.com");
       driver.manage().addCookie(new Cookie("PHPSESSID", "03edaa9420c8347735ce1eb5e334dbdf"));
       driver.manage().addCookie(new Cookie("locale", "no"));
       driver.manage().addCookie(new Cookie("_uuid", "5ac25fdd5df499.43880151"));
       driver.navigate().refresh();

    }
}


