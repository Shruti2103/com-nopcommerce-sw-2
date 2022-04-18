package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    // click on login link
    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void varifyUserShouldNavigateToLoginPageSucessfully() {
        // find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // This is from requirement for display message
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);
        // validate expexted message
        Assert.assertEquals("Not Nevigate to login page", expectedMessage, actualMessage);


    }

    @After
    public void testDown() {
        closeBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // finf login Link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // find emailfield element
        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys("nehamittal@gmail.com");
        // find the password field
        WebElement passwordfield = driver.findElement(By.id("Password"));
        passwordfield.sendKeys("nehamittal");
        // click log in after email and password
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginbutton.click();

        // varify logout
        String expectedMessage = "Log out";

        WebElement actualMessage = driver.findElement(By.linkText("Log out"));
        String actualresult = actualMessage.getText();
        Assert.assertEquals("Logout sucessfully", expectedMessage, actualresult);

        // log out
        WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        logout.click();

    }

    @Test
    public void TheErrorMessage() {
        // click on Login link
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();
        // find invalid emailfield
        WebElement invalidEmailID = driver.findElement(By.name("Email"));
        invalidEmailID.sendKeys("kinjal.....@gmail.com");
        //find password field invalid
        WebElement invalidpassword = driver.findElement(By.id("Password"));
        invalidpassword.sendKeys("123");
        // click lof in after email and password
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginbutton.click();
        // expexted message
        String expectedmessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        //actual message
        WebElement actualmessageElement = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
        String actualmessageElement1 = actualmessageElement.getText();
        //varify the test
        Assert.assertEquals("Login was unsucessful please correct the error and try again", expectedmessage, actualmessageElement1);


    }
    @After
    public void closetest(){
        closeBrowser();
    }
    

}


