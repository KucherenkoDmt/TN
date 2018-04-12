package regs;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.fail;

public class MobIndex extends TestBaseMob {


    @Test
    public void makeRegistrationMob() throws InterruptedException {
        for (int i = 1; i < regInfo.size(); i++) {
            log("beginning of the registration cycle by row " + i);
            for (int j = 1; j <= regInfo.get(i).getCounterOfRegistration(); j++) {
                log("beginning of the registration cycle by counter of reg " + j);
                log("open link " + regInfo.get(i).getLink());
                Thread.sleep(2000);
                this.driver.get(regInfo.get(i).getLink());
                log("Set ip address");
                writeIpAddressToCookie(regInfo.get(i).getIp_address());
                Thread.sleep(1000);
                log("click i'm new");
                click("//button[@id='showRegForm']");
                log("Set gender");
                click(choseGenderMob(regInfo.get(i).getNumberOfGenderValue()));
                log("Type screenname");
                type("//input[@class='input-text screenname']", "dfdklsgka");
                log("Set age");
                choseCorrectedDOBandSetAge();
              //  String emailForRegistration = generateRandomEmail();
                String emailForRegistration = chooseEmailForTest(regInfo.get(i).getEmailOfUser());
                log("Type email " + emailForRegistration);
                type("//input[@class='input-text']", emailForRegistration);
                log("Type password");
                type("//input[@class='input-text _passwordField']", "111111");
               // log("Check checkbox of Terms and click if it available");
                //    checkCheckboxOfTerms();
                log("click submit");
                click("//button[@id='btn_register_submit']");
                log("wait until page to load");
                Thread.sleep(5000);
                log("success registration");
                log("add to array email is: " + emailOfUsers.add(emailForRegistration));
                this.driver.manage().deleteAllCookies();
                Thread.sleep(500);
                log("next registration");
            }
        }
    }
    @Override
    protected void afterTest() throws Exception {
        makeUsersLikeTest(emailOfUsers);
        log("Close driver");
    }

    protected String choseGenderMob(int numberOfGender) {
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
