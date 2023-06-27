package signinModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSigninModule {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void signInTest() {
        // Navigate to Amazon sign-in page
        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fs%3Fk%3Damazon%2Blogin%2Bto%2Bmy%2Baccount%26hvadid%3D556129898822%26hvdev%3Dc%26hvlocphy%3D9001030%26hvnetw%3Dg%26hvqmt%3De%26hvrand%3D14270058374076683946%26hvtargid%3Dkwd-364435124097%26hydadcr%3D3321_10311071%26tag%3Dgoogcana-20%26ref%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

        // Find and click on the Sign-In link
        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("shiv01tester@gmail.com");

        // Find and click on the "Continue" button
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        // Find and fill in the password field
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("Shivani@123");

        // Find and click on the "Sign-In" button
        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
