package regs;

import Patterns.CSV.ReadCSV4colon;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseMob extends TestBase {
    public TestBaseMob() throws IOException, InterruptedException {
    }
    @Before
    public void setUp() throws InterruptedException, IOException {
        this.driver = new ChromeDriver(emulateMobile());
        log("Before test");
        regInfo = ReadCSV4colon.csvDataRead();
        log("reg info is readed and have row :" + regInfo.size());
        wait = new WebDriverWait(this.driver, 15);
        this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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

    protected String choseGenderMob(int numberOfGender) throws IOException {
        // 1 - male
        // 2 - female
        if (numberOfGender == 1) {
            log("male sated");
            return choseActiveElement("//label[@id='tab_gender_male']", "");
        }
        if (numberOfGender == 2) {
            log("female sated");
            return choseActiveElement("//label[@id='tab_gender_female']","");
        }
        log("wrong value of gender so sated male");
        return choseActiveElement( "//label[@id='tab_gender_male']", "");
    }

}
