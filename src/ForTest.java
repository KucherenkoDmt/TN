import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class ForTest {
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        WebDriver driver = new FirefoxDriver();
        System.out.println("1");
        driver.get("https://www.google.com/?gws_rd=ssl");
        Thread.sleep(5000);
        WebElement fname = driver.findElement(By.id("gb_705645"));
        if(fname.isEnabled())
        {
            System.out.print("\nText box First name is enabled. Take your action.");
        }
        else
        {
            System.out.print("\nText box First name is disabled. Take your action.");
        }
    }
}

