package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

        public void openBrowser(String baseurl){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //Launch the url
        driver.get(baseurl);
        // maximise window
       driver.manage().window().maximize();
       //give implicite time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public void closeBrowser(){
        driver.quit();
    }

}
