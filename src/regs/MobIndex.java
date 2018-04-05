package regs;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.fail;

public class MobIndex extends TestBaseMob {
    public MobIndex() throws IOException, InterruptedException {
    }

    @Test
    public void makeRegistrationMob() throws IOException, InterruptedException {
        for (int i = 1; i < regInfo.size(); i++) {
            log("beginning of the registration cycle by row " + i);
            for (int j = 1; j <= regInfo.get(i).getCounterOfRegistration(); j++) {
                log("beginning of the registration cycle by counter of reg " + j);
                log("open link " + regInfo.get(i).getLink());
                this.driver.get(regInfo.get(i).getLink());
                log("Set ip address");
                writeIpAddressToCookie(regInfo.get(i).getIp_address());
                Thread.sleep(1000);
                log("click i'm new");
                click("//button[@id='showRegForm']");
                log("Set gender");
                click(choseGenderMob(regInfo.get(i).getNumberOfGenderValue()));
                log("Set age");
                choseCorrectedDOBandSetAge();
                String emailForRegistration = generateRandomEmail();
                log("Type email " + emailForRegistration);
                type(choseActiveElement("//div[@class='field_box']/input[@id='UserForm_email']", "//input[@id='email-field']"), emailForRegistration);
               /* log("Type password");
                type(choseActiveElement("//input[@class='frm-password']", " //input[@id='password-field']"), "111111");
                log("Check checkbox of Terms and click if it available");
                //    checkCheckboxOfTerms();
                log("click submit");
                click(choseActiveElement(this.driver, "//*[@id='submit-btn']", "//div[@class='submit_button']/button[@id='submit_button']", "button[@id='submit_button']"));
                log("wait until page to load");
                Thread.sleep(5000);
                log("success registration");
                log("add to array email is: " + emailOfUsers.add(emailForRegistration));
                this.driver.manage().deleteAllCookies();
                Thread.sleep(500);
                log("next registration");*/
            }
        }

    }

    @Override
    protected void afterTest() throws Exception {
        click("");
    }
}
