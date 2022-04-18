package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    // click on login click
    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void navigateToRegisterPageSuccessfully() {
        //select registration link
        WebElement registerbtn = driver.findElement(By.linkText("Register"));
        registerbtn.click();
        // to varify write epected and actual message
        String expectedresult = "Register";
        WebElement actualresult = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        String actualresult1 = actualresult.getText();
        System.out.println(actualresult1);
        //varify actual and expected
        Assert.assertEquals("Registration", expectedresult, actualresult1);


    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {

        // select registration link

        WebElement registration = driver.findElement(By.linkText("Register"));
        registration.click();
        //select gender radio button
        WebElement genderRadiobtn = driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderRadiobtn.click();
        //Enter first name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("neha");
        // Enter the lastname
        WebElement secondName = driver.findElement(By.xpath("//input[@id='LastName']"));
        secondName.sendKeys("mittal");
        // select day month and year
        WebElement day = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"));
        day.click();
        // select month
        WebElement month = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"));
        month.click();
        //selecy year
        WebElement year = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"));
        year.click();
        // Enter email address
        WebElement emailfield = driver.findElement(By.xpath("//input[@id='Email']"));
        emailfield.sendKeys("abcd13@gmail.com");
        //pasword field
        WebElement passwordfield = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordfield.sendKeys("sanketdesai");
        //confirmed password
        WebElement confirmedpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmedpassword.sendKeys("sanketdesai");
        // register button
        WebElement registerbtn = driver.findElement(By.name("register-button"));
        registerbtn.click();
        //check message
        String expectedresult = "Your registration completed";
      //  WebElement actualresult = driver.findElement(By.xpath("//button[@id='register-button']"));
       // String actualresult1 = actualresult.getText();
        //varify
      //  Assert.assertEquals("Register complete", expectedresult, actualresult1);
        // final registration varifying
        WebElement actual=driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actual1=actual.getText();
        Assert.assertEquals("Registration complete",expectedresult,actual1);




    }
    @After
    public void closetest(){
        closeBrowser();
    }

}
