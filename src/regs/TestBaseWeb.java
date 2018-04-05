package regs;

import Patterns.CSV.ReadCSV4colon;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseWeb extends TestBase{
    public TestBaseWeb() throws IOException, InterruptedException {
    }
    @Before
    public void setUp() throws InterruptedException, IOException {
        this.driver = new ChromeDriver();
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
    protected String choseGenderWeb(int numberOfGender) throws IOException {
        // 1 - male
        // 2 - female
        if (numberOfGender == 1) {
            log("male sated");
            return choseActiveElement("//option[@value='male-female']", "//span[contains(@class,'gender_m')]", "//option[@value='male']");
        }
        if (numberOfGender == 2) {
            log("female sated");
            return choseActiveElement("//option[@value='female-male']", "//span[contains(@class,'gender_w')]", "//option[@value='female']");
        }
        log("wrong value of gender so sated male");
        return choseActiveElement( "//option[@value='male-female']", "//span[contains(@class,'gender_m')]", "//option[@value='male']");
    }

}
