package firstpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class homework1 {

    @Test
    public void launchPage(){
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
       driver.get("https://www.youtube.com/");
       driver.quit();

    }
}
