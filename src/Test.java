import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Test {
    WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) {
        Test test = new Test();
        test.ffMob();
    }

    public void ffMob() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("MySelenium");

        System.setProperty("webdriver.gecko.driver", "Z:\\Soft\\firefoxdriver\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(myProfile);
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.google.com.ua/?hl=ru");

     //   fprofile.setPreference("general.useragent.override", "iPhone");
    }
}
