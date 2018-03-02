import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ForTest {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        Robot robot = new Robot();
        driver.get("https://translate.google.com.ua");
        driver.findElement(By.xpath("//*[@id=\"source\"]"));
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_Z);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_Z);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_0);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_9);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_8);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_1);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_3);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_1);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_6);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_3);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_9);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_6);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_LEFT_PARENTHESIS);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ASTERISK);
        //звездачка
       // robot.keyPress(KeyEvent.VK_Z+KeyEvent.VK_SHIFT);

    }
}
