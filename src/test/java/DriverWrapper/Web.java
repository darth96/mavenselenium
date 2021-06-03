package DriverWrapper;

import Utils.TestConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    // Methods related to Web-launch, close

    private static WebDriver driver;

   // @Before
    public void openUrl() {
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestConstant.tenSeconds, TimeUnit.SECONDS);
    }

    public void openUrl2(String url) {
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(TestConstant.tenSeconds, TimeUnit.SECONDS);
    }


    public void closePage() {
        driver.close();
    }

  //  @After
    public void quitPages() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }



}