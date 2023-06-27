package paymentModule;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

	public class AddPayment {

		    private WebDriver driver;

		    public void setUp() {
		        
		        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		        
		        driver = new ChromeDriver();

		        // Maximize the browser window
		        driver.manage().window().maximize();

		        // Navigate to Amazon homepage
		        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fs%3Fk%3Damazon%2Blogin%2Bto%2Bmy%2Baccount%26hvadid%3D556129898822%26hvdev%3Dc%26hvlocphy%3D9001030%26hvnetw%3Dg%26hvqmt%3De%26hvrand%3D14270058374076683946%26hvtargid%3Dkwd-364435124097%26hydadcr%3D3321_10311071%26tag%3Dgoogcana-20%26ref%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

		        
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		        // Find and fill in the email field
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

		        // Find the "Hello, Sign in" element
		        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));

		        // Perform mouse hover action on the element
		        Actions actions = new Actions(driver);
		        actions.moveToElement(accountElement).perform();

		        // Find and click on the "Your Account" option in the drop-down menu
		        WebElement yourAccountOption = driver.findElement(By.xpath("//span[contains(text(),'Your Account')]"));
		        yourAccountOption.click();

		        
		        

		        // Find and click on the "Payment options" module
		        WebElement paymentOptionsModule = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[2]/a/div/div/div/div[2]/h2"));
		        paymentOptionsModule.click();

		        
		        
		       //Click on Add Payment Method
		        WebElement addPayment = driver.findElement(By.xpath("//*[@id=\"pp-TlZXwK-29\"]/div/div/div[1]/img"));
		        addPayment.click();
		        
		        // Find and click on the "Add a card" button
		        WebElement addCardButton = driver.findElement(By.xpath("//span[contains(text(),'Add a card')]"));
		        addCardButton.click();

		       
		        

		        // Fill in the card details
		        WebElement cardNumberField = driver.findElement(By.id("pp-yvnl_95"));
		        cardNumberField.sendKeys("5555555555554444");

		        WebElement cardNameField = driver.findElement(By.id("pp-EqrsuR-18"));
		        cardNameField.sendKeys("Shivani Tester");
		        
		        WebElement expiryDateField = driver.findElement(By.id("pp-yvnl_99"));
		        expiryDateField.sendKeys("0524");

		        WebElement cvvField = driver.findElement(By.id("pp-yvnl_96"));
		        cvvField.sendKeys("100");

		        // Save the card details
		        WebElement saveCardButton = driver.findElement(By.id("pp-yvnl_110"));
		        saveCardButton.click();

		        

		        // Find and click on the "Choose as default" button for the added card
		        WebElement chooseDefaultButton = driver.findElement(By.xpath("//span[contains(text(),'Choose as default')]"));
		        chooseDefaultButton.click();

		        

		        // Close the browser
		        driver.quit();
		    }

		    public static void main(String[] args) {
		        AddPayment test = new AddPayment();
		        test.setUp();
		    }
		}
