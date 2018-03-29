package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeAcc {
    public void chromeAcc() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=Z:\\profile\\Chrome\\User Data\\Profile 1");
        //     options.addArguments("chrome.switches", "--disable-extensions");
        //  options.addArguments("user-data-dir="+userProfile);
        options.addArguments("--start-maximized");

       WebDriver driver = new ChromeDriver(options);
        driver.get("https://my.platformphoenix.com/base/login");

        Thread.sleep(1000);
        driver.switchTo().alert();
        driver.switchTo().activeElement().submit();
    }
}

