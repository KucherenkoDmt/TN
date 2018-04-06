package regs;

import Patterns.CSV.ReadCSV4colon;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBaseMob extends TestBase {

    @Before
    public void setUp() throws InterruptedException, IOException {
        this.driver = new ChromeDriver(emulateMobile());
        log("Before test");
        regInfo = ReadCSV4colon.csvDataRead();
        log("reg info is readed and have row :" + (regInfo.size()-1));
        wait = new WebDriverWait(this.driver, 15);
        this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        beforeTest();
    }
    protected void beforeTest() throws InterruptedException, IOException {}

    @After
    public void tearDown() throws Exception {
        log("After test");
        String emails = "";
        for (int i = 0; i < emailOfUsers.size(); i++) {
            emails += emailOfUsers.get(i) + "\n";
        }
        System.out.println(emails);
        afterTest();
        this.driver.quit();
    }
    protected void afterTest() throws Exception {

    }
    protected ChromeOptions emulateMobile() throws InterruptedException {
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;
    }



}
