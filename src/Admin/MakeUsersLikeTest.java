package Admin;

import Patterns.Log.ConsoleLogger;
import Patterns.Log.Logger;
import Patterns.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.fail;

public class MakeUsersLikeTest extends BasicClaas{
    List<String> emailOfusers = Reader.reader("FileForRead.txt");
    WebDriver driver = new FirefoxDriver();
    Logger logger = new ConsoleLogger();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public MakeUsersLikeTest() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        MakeUsersLikeTest makeUsersLikeTest = new MakeUsersLikeTest();
        makeUsersLikeTest.makeUserAsTests();
    }

    public void makeUserAsTests() throws Exception {
        super.enterToPhenix(driver);
        String usersLog = "";
        for (int i = 0; i < emailOfusers.size(); i++) {
            if (emailOfusers.get(i).isEmpty()) {
                logger.log("Empty line");
                continue;
            }
            logger.log("Current email is: " + emailOfusers.get(i));
            driver.get("https://my.platformphoenix.com/user/find");
            wait.until(ExpectedConditions.titleIs("My Application - Find User"));
            Thread.sleep(1000);
            logger.log("Type email");
            driver.findElement(By.id("FindUserForm_user")).sendKeys(emailOfusers.get(i));
            logger.log("Click to find user");
            driver.findElement(By.name("yt0")).click();
            if (super.isElementPresent(By.xpath("//a[text()=\"Mark all as testers\"]"), driver)){
                logger.log("Make the user as test");
                driver.findElement(By.xpath("//a[text()=\"Mark all as testers\"]")).click();

                logger.log("Taking of users info");
                String user_id = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr/td[3]")).getText();
                String user_email = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[3]/td")).getText();
                String reg_url = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[45]/td")).getText();
                String gender = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[14]/td")).getText();
                String orientation = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[15]/td")).getText();
                String LOC = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[18]/td")).getText();
                String trafic_souce = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[42]/td")).getText();
                String lid = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[46]/td")).getText();
                if (lid.equals("unknown")) {
                    logger.log("Isn't lid");
                    driver.quit();
                }
                String info = "reg url: " + reg_url + "\n" + " | Id: " + user_id + " |  user email: " + user_email + "\n" + " |  lid: " + lid + " | gender: "
                        + gender + " | orientation: " + orientation + " | loc: " + LOC + " | trafic_souce: " + trafic_souce;
                System.out.println(info);
                usersLog += info + "\n";
            } else {
                logger.log("There is no such user");
                continue;
            }
        }
        super.writeToFile(usersLog);
        super.tearDown(driver);
    }
}