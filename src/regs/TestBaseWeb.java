package regs;

import Patterns.CSV.ReadCSV4colon;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseWeb extends TestBase{

    @Override
    protected void beforeTestBefore() throws InterruptedException {
        this.driver = new ChromeDriver();
    }


    protected String choseGenderWeb(int numberOfGender)  {
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
