package regs;

import Admin.BasicClase;
import Admin.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.fail;

public class MobIndex extends TestBase {
    public MobIndex() throws IOException, InterruptedException {
    }


    @Override
    protected void beforeTest() throws InterruptedException, IOException {
        emulateMobile();
    }

    public void makeRegistrationMob() {

    }



}
