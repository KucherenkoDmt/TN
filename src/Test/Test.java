package Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Test {
    WebDriver driver;


    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.ffMob();
    }

    public void ffMob() throws IOException {
      //  driver = new FirefoxDriver();
        String domain = "https://m.hellohotties.com/aff.php?dynamicpage=all_mlp_5st_peach_a_c_emln&isTesting=1&__no_cache=1";
        System.out.println(returnDomainFromUrl(domain));

    }

    public String returnDomainFromUrl(String url, WebDriver driverThis) {
        driverThis.get(url); //or take current domain
        JavascriptExecutor javascript = (JavascriptExecutor) driverThis;
        String DomainUsingJS = (String) javascript.executeScript("return document.split(\"www.\").pop().split(\".com\").shift()");
        System.out.println("My Current URL Is  : " + DomainUsingJS);
        return DomainUsingJS;
    }

    public String returnDomainFromUrl(String urlText) {
        String[] splitUrl = urlText.split("\\.");
         return splitUrl[1];
    }
}
