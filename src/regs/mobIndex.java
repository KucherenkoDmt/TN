package regs;

import Admin.BasicClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class mobIndex extends BasicClass {
    //сначала ,tp ооп

    //читать линки с файла
    @BeforeClass
    public void setUp() throws IOException {
        List<String> urlOfIndex = super.readerTxtFile("FileForReader");

    }
// мобильная версия
    // прокси

    //сделать регу
    @Test
    public void regs() {

    }

    //нужно сделать юзеров тестовыми + трекинг(готов метод)
    @Test
    public void makeUsersAsTests() throws AWTException, InterruptedException, IOException {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        super.enterToPhenix(firefoxDriver);
    }
}
