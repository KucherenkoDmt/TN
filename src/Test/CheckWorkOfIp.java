package Test;

import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckWorkOfIp {

    public CheckWorkOfIp() throws InterruptedException {
    }

    @Test
    public void testIp() throws InterruptedException {
        WebDriver driver = new ChromeDriver(setIpTest("212.237.25.158:3128"));
        Thread.sleep(500);
        driver.get("http://2ip.ru");



    }

    public ChromeOptions setIpTest(String ip_address) throws InterruptedException {

        String proxySG = ip_address.trim();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxySG).setFtpProxy(proxySG).setSslProxy(proxySG).setSocksProxy(proxySG);

       // ChromeOptions chromeOptions = new ChromeOptions();
      //  chromeOptions.setProxy(proxy);
        return new ChromeOptions().setProxy(proxy);
    }
}
