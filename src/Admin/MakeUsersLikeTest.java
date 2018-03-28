package Admin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class MakeUsersLikeTest extends BasicClass {
    ArrayList<String> emailOfusers = super.readerCsvFile("make_user.csv");
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public MakeUsersLikeTest() throws IOException {
    }

   @Test
   public void makeUserLikeTests() throws Exception {
        makeUserAsTests(emailOfusers);
   }


    public void makeUserAsTests(ArrayList<String> emailOfusers) throws Exception {
        super.enterToPhenix(driver);
        String usersLog = "";
        for (int i = 0; i < emailOfusers.size(); i++) {
            Thread.sleep(1000);
            if (emailOfusers.get(i).isEmpty()) {
                log("Empty line");
                continue;
            }
            log("Current email is: " + emailOfusers.get(i));
            driver.get("https://my.platformphoenix.com/user/find");
            wait.until(ExpectedConditions.titleIs("My Application - Find User"));
            Thread.sleep(1000);
            log("Type email");
            driver.findElement(By.id("FindUserForm_user")).sendKeys(emailOfusers.get(i));
            log("Click to find user");
            driver.findElement(By.name("yt0")).click();
            Thread.sleep(3000);
            if (super.isElementPresent(By.xpath("//a[text()=\"Mark all as testers\"]"), driver)){
                log("Make the user as test");
                driver.findElement(By.xpath("//a[text()=\"Mark all as testers\"]")).click();
                Thread.sleep(1500);
                log("Taking of users info");
                String user_id = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr/td[3]")).getText();
                String user_email = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[3]/td")).getText();
                String reg_url = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[45]/td")).getText();
                String gender = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[14]/td")).getText();
                String orientation = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[15]/td")).getText();
                String LOC = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[18]/td")).getText();
                String trafic_souce = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[42]/td")).getText();
                String lid = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[46]/td")).getText();
                /*if (lid.equals("unknown")) {
                    log("Isn't lid");
                    driver.quit();}*/

                String info = "reg url: " + reg_url + "\n" + "Id: " + user_id + " |  user email: " + user_email + "\n" + "lid: " + lid + " | gender: "
                        + gender + " | orientation: " + orientation + " | loc: " + LOC + " | trafic_souce: " + trafic_souce;
                System.out.println(info);
                usersLog += info + "\n";
            } else {
                log("There is no such user");
                continue;
            }
            log("Next one");
        }
        super.writeToFile(usersLog);
        super.tearDown(driver);
    }
    public void makeUserAsTests(String emailOfusers) throws Exception {
        super.enterToPhenix(driver);
        String usersLog = "";
        for (int i = 0; i < 1; i++) {
            Thread.sleep(1000);
            if (emailOfusers.isEmpty()) {
                log("Empty line");
                continue;
            }
            log("Current email is: " + emailOfusers);
            driver.get("https://my.platformphoenix.com/user/find");
            wait.until(ExpectedConditions.titleIs("My Application - Find User"));
            Thread.sleep(1000);
            log("Type email");
            driver.findElement(By.id("FindUserForm_user")).sendKeys(emailOfusers);
            log("Click to find user");
            driver.findElement(By.name("yt0")).click();
            Thread.sleep(3000);
            if (super.isElementPresent(By.xpath("//a[text()=\"Mark all as testers\"]"), driver)){
                log("Make the user as test");
                driver.findElement(By.xpath("//a[text()=\"Mark all as testers\"]")).click();
                Thread.sleep(1500);
                log("Taking of users info");
                String user_id = driver.findElement(By.xpath("//*[@id='yw2']/table/tbody/tr/td[3]")).getText();
                String user_email = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[3]/td")).getText();
                String reg_url = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[45]/td")).getText();
                String gender = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[14]/td")).getText();
                String orientation = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[15]/td")).getText();
                String LOC = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[18]/td")).getText();
                String trafic_souce = driver.findElement(By.xpath("//*[@id='yw3']/tbody/tr[42]/td")).getText();
                String lid = driver.findElement(By.xpath(".//*[@id='yw3']/tbody/tr[46]/td")).getText();
                /*if (lid.equals("unknown")) {
                    log("Isn't lid");
                    driver.quit();}*/

                String info = "reg url: " + reg_url + "\n" + "Id: " + user_id + " |  user email: " + user_email + "\n" + "lid: " + lid + " | gender: "
                        + gender + " | orientation: " + orientation + " | loc: " + LOC + " | trafic_souce: " + trafic_souce;
                System.out.println(info);
                usersLog += info + "\n";
            } else {
                log("There is no such user");
                continue;
            }
            log("Next one");
        }
        super.writeToFile(usersLog);
        super.tearDown(driver);
    }
}