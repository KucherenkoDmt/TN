package Test;

import Patterns.CSV.CsvCell;
import Patterns.CSV.ReadCSV4colon;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
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
        ReadCSV4colon readCSV4colon = new ReadCSV4colon();
        List<CsvCell> list = readCSV4colon.csvDataRead();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCounterOfRegistration());
            System.out.println(list.get(i).getIp_address());
            System.out.println(list.get(i).getLink());
            System.out.println(list.get(i).getNumberOfGenderValue());
        }
    }
}


