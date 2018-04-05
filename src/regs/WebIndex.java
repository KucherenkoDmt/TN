package regs;

import Admin.MakeUsersLikeTest;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class WebIndex extends TestBaseWeb {


    public WebIndex() throws IOException, InterruptedException {
        super();
    }

    @Override
    protected void beforeTest() throws IOException {
        log("before test");

      //  int counter;
    }

    @Test
    public void makeRegistrationWeb() throws Exception {
        for (int i = 1; i < regInfo.size(); i++) {
            log("beginning of the registration cycle by row " + i);
            for (int j = 0; j < regInfo.get(i).getCounterOfRegistration(); j++) {
                log("beginning of the registration cycle by counter of reg " + j);
                this.driver.get(regInfo.get(i).getLink());
                log("Set ip address");
                writeIpAddressToCookie(regInfo.get(i).getIp_address());
                Thread.sleep(1000);
                log("Set gender");
                click(choseGenderWeb(regInfo.get(i).getNumberOfGenderValue()));
                log("Set age");
                choseCorrectedDOBandSetAge();
                String emailForRegistration = generateRandomEmail();
                log("Type email " + emailForRegistration);
                type(choseActiveElement("//div[@class='field_box']/input[@id='UserForm_email']", "//input[@id='email-field']"), emailForRegistration);
                log("Type password");
                type(choseActiveElement("//input[@class='frm-password']", " //input[@id='password-field']"), "111111");
                log("Check checkbox of Terms and click if it available");
                checkCheckboxOfTerms();
                log("click submit");
                click(choseActiveElement("//*[@id='submit-btn']", "//div[@class='submit_button']/button[@id='submit_button']", "button[@id='submit_button']"));
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
    public void afterTest() throws Exception {
        makeUsersLikeTest(emailOfUsers);
        log("Close driver");
    }

    public void makeUsersLikeTest(ArrayList<String> emailOfusers) throws Exception {
        MakeUsersLikeTest makeUsersLikeTest = new MakeUsersLikeTest();
        makeUsersLikeTest.makeUserAsTests(emailOfusers);
    }



    public void checkCheckboxOfTerms() {
        if (isElementPresent("//div[@id='terms_check']/label")) {
            click("//div[@id='terms_check']/label");
        }
    }
}
